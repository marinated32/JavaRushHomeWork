package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public int i;
    public String name;

    public static void main(String[] args) {

    }

    public Solution(int i) {}

    private Solution(String name){}

    protected Solution(int i, String name){}

    Solution(String name, int i) {}


}

