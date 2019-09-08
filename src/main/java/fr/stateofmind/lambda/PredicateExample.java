package fr.stateofmind.lambda;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PredicateExample {

    public static final Predicate<Integer> EVEN_PREDICATE = i -> i % 2 == 0;
    public static final Predicate<Integer> FIVE_DIV_PREDICATE = i -> i % 5 == 0;

    public static void main(String[] args) {
        System.out.println("even = " + EVEN_PREDICATE.test(4));

        predicateAnd();
        predicateOr();
        predicateNegate();
    }

    private static void predicateAnd() {
        System.out.println("Divisible by 5 and 2 : " + EVEN_PREDICATE.and(FIVE_DIV_PREDICATE).test(10));
    }

    private static void predicateOr() {
        System.out.println("Divisible by 5 or 2 : " + EVEN_PREDICATE.or(FIVE_DIV_PREDICATE).test(9));
        System.out.println("Divisible by 5 or 2 : " + EVEN_PREDICATE.or(FIVE_DIV_PREDICATE).test(4));
    }

    private static void predicateNegate() {
        System.out.println("Not divisible by 5 or 2 : " + EVEN_PREDICATE.and(FIVE_DIV_PREDICATE).test(9));
    }
}
