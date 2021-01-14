package com.javarush.task.task14.task1408;


public class RussianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 4;
    }
    
    public String getDescription() {
//        String result = this.getDescription();
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.",
        Country.RUSSIA, this.getCountOfEggsPerMonth());
    }
}