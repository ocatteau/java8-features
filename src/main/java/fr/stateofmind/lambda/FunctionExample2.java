package fr.stateofmind.lambda;

public class FunctionExample2 {

    public static void main(String[] args) {
        String result = performConcat("Hello");

        System.out.println("result = " + result);
    }

    private static String performConcat(String hello) {
        return FunctionExample.concat.apply(hello);
    }
}
