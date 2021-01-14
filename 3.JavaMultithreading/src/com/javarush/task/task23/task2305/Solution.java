package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] result = new Solution[2];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Solution();
            result[i].innerClasses[0] = result[i].new InnerClass();
            result[i].innerClasses[1] = result[i].new InnerClass();
        }
        return result;
    }

    public static void main(String[] args) {
        getTwoSolutions ();
    }
}
