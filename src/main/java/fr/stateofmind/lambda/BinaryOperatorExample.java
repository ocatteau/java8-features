package fr.stateofmind.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class BinaryOperatorExample {

    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (a,b) -> a * b;
        System.out.println("binaryOperator = " + binaryOperator.apply(3, 4));

        Comparator<Integer> comparator = Comparator.naturalOrder();
        System.out.println("maxBy :" + BinaryOperator.maxBy(comparator).apply(3, 4));
        System.out.println("maxBy :" + BinaryOperator.minBy(comparator).apply(3, 4));
    }
}
