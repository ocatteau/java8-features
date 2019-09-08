package fr.stateofmind.methodreference;

import java.util.function.Function;

public class FunctionMethodReferenceExample {

    public static void main(String[] args) {
        Function<String, String> toUppercase = String::toUpperCase;
        System.out.println(toUppercase.apply("test"));
    }
}
