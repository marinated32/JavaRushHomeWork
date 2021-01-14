package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new ArrayList ();

            String[] res = loadWheelNamesFromDB ();
            if (res == null || res.length == 0) {
                throw new IllegalArgumentException ();
            }

            for (String str: res) {
                if (res.length == 4){
                    wheels.add ( Wheel.valueOf ( str ) );
                }
                else {
                    throw new IllegalArgumentException ();
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car some = new Car();
    }
}
