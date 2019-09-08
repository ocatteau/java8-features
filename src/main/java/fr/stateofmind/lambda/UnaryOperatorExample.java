package fr.stateofmind.lambda;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    public static void main(String[] args) {
        UnaryOperator<String> unaryOperator = s -> s.concat("Concat");
        System.out.println("unaryOperator = " + unaryOperator.apply("unaryOp"));
    }
}
