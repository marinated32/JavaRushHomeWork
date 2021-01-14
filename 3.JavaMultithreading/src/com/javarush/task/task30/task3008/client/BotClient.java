package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage ( "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды." );
            super.clientMainLoop ();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage ( message );

            if (message == null || !message.contains(": ")) {
                return;
            }

            if (!(message == null) && message.contains ( ": " )) {

                String[] res = message.split ( ":", 2 );
                String userName = res[0].trim ();
                String data = res[1].trim ();
                SimpleDateFormat format = null;

                if (data.equals ( "дата" )) {
                    format = new SimpleDateFormat ( "d.MM.YYYY" );
                    sendTextMessage ( String.format ( "Информация для %s: %s" , userName, format.format ( new GregorianCalendar().getTime() ) ));
                }else if (data.equals ( "день" )) {
                    format = new SimpleDateFormat ( "d" );
                    sendTextMessage ( String.format ( "Информация для %s: %s" , userName, format.format ( new GregorianCalendar().getTime() ) ));
                }else if (data.equals ( "месяц" )) {
                    format = new SimpleDateFormat ( "MMMM" );
                    sendTextMessage ( String.format ( "Информация для %s: %s" , userName, format.format ( new GregorianCalendar().getTime() ) ));
                }else if (data.equals ( "год" )) {
                    format = new SimpleDateFormat ( "YYYY" );
                    sendTextMessage ( String.format ( "Информация для %s: %s" , userName, format.format ( new GregorianCalendar().getTime() ) ));
                }else if (data.equals ( "время" )) {
                    format = new SimpleDateFormat ( "H:mm:ss" );
                    sendTextMessage ( String.format ( "Информация для %s: %s" , userName, format.format ( new GregorianCalendar().getTime() ) ));
                }else if (data.equals ( "час" )) {
                    format = new SimpleDateFormat ( "H" );
                    sendTextMessage ( String.format ( "Информация для %s: %s" , userName, format.format ( new GregorianCalendar().getTime() ) ));
                }else if (data.equals ( "минуты" )) {
                    format = new SimpleDateFormat ( "m" );
                    sendTextMessage ( String.format ( "Информация для %s: %s" , userName, format.format ( new GregorianCalendar().getTime() ) ));
                }else if (data.equals ( "секунды" )) {
                    format = new SimpleDateFormat ( "s" );
                    sendTextMessage ( String.format ( "Информация для %s: %s" , userName, format.format ( new GregorianCalendar().getTime() ) ));
                } else {
                    return;
                }
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread ();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + String.valueOf ( (int) (Math.random () * 100) );
    }

    public static void main(String[] args) {
//        SimpleDateFormat format = new SimpleDateFormat ( "d.MM.YYYY" );
//        Calendar calendar = new GregorianCalendar (  );
//        Date date = calendar.getTime ();
//        System.out.println (format.format ( date ));
//
//        String prob = "Боб: информация для ";
//        String[] res = prob.split ( ":" );
//        for (String st: prob.split ( ":",2 ))
//            System.out.println (st);
//        String line = "Bob";
//        System.out.println (line.equals (res[1]) );

//        System.out.println (String.format ( "Информация для %s: %s" , line, format.format ( new GregorianCalendar().getTime() ) ));



        BotClient bot = new BotClient ();
//        System.out.println (bot.getUserName ());
        bot.run ();
    }
}
