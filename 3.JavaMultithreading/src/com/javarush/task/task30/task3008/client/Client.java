package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        return ConsoleHelper.readString ();
    }

    protected int getServerPort() {
        return ConsoleHelper.readInt ();
    }

    protected String getUserName() {
        return ConsoleHelper.readString ();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread ();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send ( new Message ( MessageType.TEXT, text ) );
        } catch (IOException e) {
            e.printStackTrace ();
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread ();
        socketThread.setDaemon ( true );
        socketThread.start ();
        synchronized (this) {
            try {
                this.wait ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
               return;
            }
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage ( "Соединение установлено. Для выхода наберите команду 'exit'." );
        }
        else {
            ConsoleHelper.writeMessage ( "Произошла ошибка во время работы клиента." );
        }

        String text = "";
        while (clientConnected && !text.equals("exit")) {
            text = ConsoleHelper.readString ();
            if (shouldSendTextFromConsole ())
                sendTextMessage ( text );
        }
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {ConsoleHelper.writeMessage ( message );}

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage ( userName + "entered" );
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage ( userName + "just exit" );
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify ();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive ();
                if (message.getType () == MessageType.NAME_REQUEST) {
                    String userName = getUserName ();
                    connection.send ( new Message ( MessageType.USER_NAME, userName ) );
                } else if (message.getType () == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged ( true );
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive ();
                if (message.getType () == MessageType.TEXT) {
                    processIncomingMessage ( message.getData () );
                } else if (message.getType () == MessageType.USER_ADDED) {
                    informAboutAddingNewUser ( message.getData () );
                } else if (message.getType () == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser ( message.getData () );
                } else throw new IOException("Unexpected MessageType");
            }
        }

        @Override
        public void run() {
            try {
                String adress = getServerAddress ();
                int port = getServerPort ();
                Socket socket = new Socket ( adress, port );
                connection = new Connection ( socket );
                clientHandshake ();
                clientMainLoop ();
            } catch (UnknownHostException e) {
                e.printStackTrace ();
            } catch (IOException e) {
                notifyConnectionStatusChanged ( false );
                e.printStackTrace ();
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged ( false );
                e.printStackTrace ();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client ();
        client.run();
    }


}
