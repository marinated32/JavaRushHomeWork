package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<> (  );

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection: connectionMap.values ()) {
            try {
                connection.send ( message );
            } catch (IOException e) {
                System.out.println ("Failed to send Message: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args)  {
        int port = ConsoleHelper.readInt ();

        try (ServerSocket serverSocket = new ServerSocket ( port )) {
            ConsoleHelper.writeMessage ( "Server is running" );

            while (true) {
                Handler handler = new Handler ( serverSocket.accept () );
                handler.start ();
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println(socket.getRemoteSocketAddress()+ "");
            try (Connection currentConection = new Connection ( socket )) {
                String newClient = serverHandshake ( currentConection );
                sendBroadcastMessage ( new Message ( MessageType.USER_ADDED, newClient ) );
                notifyUsers ( currentConection, newClient );
                serverMainLoop ( currentConection, newClient );
                connectionMap.remove ( newClient );
                sendBroadcastMessage ( new Message ( MessageType.USER_REMOVED, newClient ) );
                ConsoleHelper.writeMessage ( "new connection was closed" + currentConection.getRemoteSocketAddress () );
            } catch (IOException e) {
                e.printStackTrace ();
            } catch (ClassNotFoundException e) {
                e.printStackTrace ();
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send ( new Message ( MessageType.NAME_REQUEST ) );
            Message result = connection.receive ();

            if ( result.getType() == MessageType.USER_NAME ) {
                String newClient = result.getData ();
                if (!newClient.isEmpty () && !connectionMap.containsKey ( newClient )) {
                    connectionMap.put ( newClient, connection );
                    connection.send ( new Message ( MessageType.NAME_ACCEPTED ) );
                    return newClient;
                }
            }
            return serverHandshake ( connection );
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name: connectionMap.keySet ()) {
                if (!name.equals ( userName )) {
                    connection.send ( new Message ( MessageType.USER_ADDED, name ) );
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive ();
                if (message.getType () == MessageType.TEXT  ) {
                    Message newMessage = new Message ( MessageType.TEXT, userName +
                            ": " + message.getData ());
                    sendBroadcastMessage ( newMessage );
                } else {
                    ConsoleHelper.writeMessage ( "Error" );
                }
            }
        }
    }
}