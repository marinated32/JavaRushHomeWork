package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        StringBuilder res = new StringBuilder (  );
        res.append ( number );
        res.append ( " =" );
        int powCount3 = 0;

        while (number > 0) {
            int ost = number % 3;
            number = number / 3;

            if (ost == 1) {
                res.append ( " + " );
                res.append ( (int) (Math.pow ( 3, powCount3 )));
            } else if (ost == 2) {
                res.append ( " - " );
                res.append ( (int) (Math.pow ( 3, powCount3 ) ));
                number++;
            }
            powCount3++;
        }
        System.out.println (res.toString ());
    }
}