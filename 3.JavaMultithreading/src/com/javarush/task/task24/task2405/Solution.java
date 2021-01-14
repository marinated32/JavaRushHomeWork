package com.javarush.task.task24.task2405;

/* 
Black box
*/

import static com.javarush.task.task24.task2405.SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM;

public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {
        //напишите тут ваш код
        public void someAction() {
            //напишите тут ваш код
//            if (param == 99) {
//                super.someAction();
//            }
            if (param > 0) {

                for (int i = 0; i < 5; i++) {
                    System.out.println (param);
                    param--;
                }
                FirstClass firstClass = new FirstClass () {
                    @Override
                    public Action getDependantAction() {
                        return null;
                    }

//                    if (true) {
//                        super.someAction();
//                    }
                };
                firstClass.someAction ();

//                SecondClass secondClass = new SecondClass ();
//                secondClass.someAction ();
//                System.out.println (SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM + param);

                new SecondClass(){
                    @Override
                    public void someAction() { // тут переопределяем метод
                        super.someAction();
                        System.out.println(SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.substring(1) + (param)); // так нужно чтобы вернуть на строчку назад.
                    }
                }.someAction();
            }else {
                SecondClass secondClass = new SecondClass ();
                secondClass.someAction ();
                System.out.println (SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.substring(1) + (param));

//                new SecondClass(){
//                    @Override
//                    public void someAction() { // тут переопределяем метод
////                        super.someAction();
//                        System.out.println(SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.substring(1) + (param)); // так нужно чтобы вернуть на строчку назад.
//                    }
//                }.someAction();
            }
        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}
