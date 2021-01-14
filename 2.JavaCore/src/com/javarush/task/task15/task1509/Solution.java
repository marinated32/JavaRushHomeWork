package com.javarush.task.task15.task1509;

public class Solution {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();

        printName(man);
        printName(woman);
    }

    public static void printName(Human human) {
        if (human instanceof Man)
            System.out.println ( "Man" );
        else
            System.out.println ( "Woman" );
    }

    public static class Human {

    }

    public static class Man extends Human {

    }

    public static class Woman extends Human {

    }
}
