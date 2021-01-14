package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String url = reader.readLine ();
        reader.close ();

        char[] charURL = url.toCharArray ();
        char[] copyURL = new char[charURL.length];
//        char[] copySTR = new char[30];
        String key = "";
        String value = "";
        List<String> list = new ArrayList<> (  );
        List<String> keys = new ArrayList<> (  );
        List<String> values = new ArrayList<> (  );
        Map<String, String> map = new LinkedHashMap <> (  );

        for (int i = 0; i < charURL.length; i++) {
            if (  charURL[i] == '?'){
                copyURL = Arrays.copyOfRange (charURL, i+1, charURL.length);
            }
        }
//        System.out.println(Arrays.toString ( copyURL ));

        for (int i = 0; i < copyURL.length; i++) {
            if (copyURL[i] == '&' ){
                list.add ( key );
                key = "";
            }else {
                key += String.copyValueOf ( new char[]{copyURL[i]} );
            }

            if (i == copyURL.length-1){
                list.add ( key );
                key = "";
            }
        }
//        System.out.println ( list ); //norm

        for (String str: list){
            if (str.contains ( "=" )){
                char[] ch = new char[str.length ()];
                ch = str.toCharArray ();
                int indexNum = new String(ch).indexOf('=');
//                System.out.println ( indexNum );   //norm

                for (int i = 0; i < indexNum; i++) {
                    key += String.copyValueOf ( new char[]{ch[i]} );
                }
                for (int i = indexNum+1; i < ch.length; i++) {
                    value += String.copyValueOf ( new char[]{ch[i]} );
                }
//                System.out.println ( key + " " + value );
                keys.add ( key );
                values.add ( value );
//                map.put ( key, value );

//                System.out.println ( keys );
//                System.out.println ( values );

                key = "";
                value = "";

            }else {
                keys.add ( str );
                values.add( null );
//                map.put ( str, null );
            }
        }


//        System.out.println(list);
//        System.out.println();
//        for (Map.Entry<String, String> pair: map.entrySet()){
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
//        System.out.println("keys");
//        for ( String s : map.keySet() ) {
//            System.out.print( s  + " ");
//        }
//        System.out.println();

        for (String s : keys)
            System.out.print ( s + " " );

        System.out.println (  );
        for (int i = 0; i < keys.size (); i++) {
            if (keys.get ( i ).equals ( "obj" )) {
                try {
                    alert ( Double.parseDouble ( values.get (i) ) );
                } catch (NumberFormatException e) {
                    alert ( values.get (i) );
                }
            }
        }

//        for (Map.Entry<String, String> pair: map.entrySet ()) {
//            if (pair.getKey ().equals ( "obj" )) {
//                try {
//                    alert ( Double.parseDouble ( pair.getValue () ) );
//                } catch (NumberFormatException e) {
//                    alert ( pair.getValue () );
//                }
//            }
//        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
