package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {
        Car result = null;
        switch (type) {
            case 0:
                result = new Truck ( numberOfPassengers );
                break;
            case 1:
                result = new Sedan ( numberOfPassengers );
                break;
            case 2:
                result = new Cabriolet ( numberOfPassengers );
                break;
        }
        return result;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception (  );
        fuel += numberOfLiters;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        if (date.after ( summerStart ) && date.before ( summerEnd ) )
            return true;
        return false;
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (!isSummer ( date, SummerStart, SummerEnd )) {
            consumption = getWinterConsumption ( length );
        } else {
            consumption = getSummerConsumption ( length );
        }
        return consumption;
    }

    private boolean canPassengersBeTransferred() {
        if (isDriverAvailable () && fuel > 0l)
            return true;
        return false;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred ())
            return numberOfPassengers;
        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed() ; //{
//        if (type == TRUCK)
//            return 80;
//        if (type == SEDAN)
//            return 120;
//        return 90;
//    }

//    public static void main(String[] args) {
//        Car car = new Car(0, 3);
//        System.out.println (car.driverAvailable);
//    }
}