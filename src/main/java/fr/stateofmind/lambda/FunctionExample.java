package fr.stateofmind.lambda;

import java.util.function.Function;

public class FunctionExample {
    static Function<String, String> toUppercase = name -> name.toUpperCase();
    static Function<String, String> concat = name -> name.concat("Concat");

    public static void main(String[] args) {
        System.out.println("Result : " + toUppercase.apply("Java8"));

        System.out.println("AndThen = " + toUppercase.andThen(concat).apply("test"));
        System.out.println("Compose = " + toUppercase.compose(concat).apply("test"));
    }
}
