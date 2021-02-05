package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public void recurse(int n) {
        for (int i = 2; i < n+1; i++) {
            if (n % i == 0) {
                System.out.print (i + " ");
                n = n/i;
                recurse ( n );
                break;
            }
        }
    }

//    public static void main(String[] args) {
//        Solution sol = new Solution ();
//        sol.recurse ( 20 );
//    }
}
