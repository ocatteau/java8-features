package fr.stateofmind.lambda.localvariable;

import java.util.function.Consumer;

public class LambdaVariableExample3 {

    public static void main(String[] args) {
        LambdaVariable lambdaVariable = new LambdaVariable();
        lambdaVariable.updateInstance();
        System.out.println("lambdaVariable.getValue() = " + lambdaVariable.getValue());
    }

    public static class LambdaVariable {
        int value = 3;

        public void updateInstance() {
            Consumer<Integer> c1 = i -> {
                value++;
                System.out.println(value + i);
            };

            c1.accept(4);
        }

        public int getValue() {
            return value;
        }
    }
}
