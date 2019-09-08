package fr.stateofmind.lambda.localvariable;

import java.util.function.Consumer;

public class LambdaVariableExample2 {
    static int value = 3;

    public static void main(String[] args) {

        Consumer<Integer> c1 = i -> {
            value++;
            System.out.println(value + i);
        };

        c1.accept(4);
    }
}
