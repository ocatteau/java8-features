package fr.stateofmind.lambda.localvariable;

import java.util.function.Consumer;

public class LambdaVariableExample1 {

    public static void main(String[] args) {
        int i = 0;
        Consumer<Integer> c1 = i1 -> System.out.println(i1);
    }
}
