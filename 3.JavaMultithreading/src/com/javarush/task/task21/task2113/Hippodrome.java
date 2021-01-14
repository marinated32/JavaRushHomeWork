package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static void main(String[] args) {
        game = new Hippodrome ( new ArrayList<> (  ) );
        Horse first = new Horse ( "first", 3d, 0d );
        Horse second = new Horse ( "second", 3d, 0d );
        Horse fird = new Horse ( "fird", 3d, 0d );

        game.horses.add ( first );
        game.horses.add ( second );
        game.horses.add ( fird );
        
        game.run ();
        game.printWinner ();
    }

    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public Hippodrome() {
    }

    public void move() {
        for (Horse horse: horses) {
            horse.move ();
        }
    }

    public void print() {
        for (Horse horse: horses) {
            horse.print ();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println ();
        }
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move ();
            print ();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double dis = 0d;
        for (Horse horse: horses) {
            if ( horse.getDistance () > dis ) {
                dis = horse.getDistance ();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println ("Winner is " + getWinner ().getName () + "!");
    }

}
