package com.javarush.task.task14.task1408;


public class BelarusianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 8;
    }
    
    public String getDescription() {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.",
                Country.BELARUS, this.getCountOfEggsPerMonth());
    }
}