package fr.stateofmind.interactivedeclarative;

import java.util.stream.IntStream;

public class ImperativeVsDeclarativeExample1 {

    public static void main(String[] args) {
        /** Imperative **/
        int sum = 0;
        for (int i = 1; i <= 100; i++){
             sum += i;
        }
        System.out.println("sum = " + sum);

        /** Declarative **/
        int sum1 = IntStream.rangeClosed(1, 100).sum();
        System.out.println("sum1 = " + sum1);

        int sum2 = IntStream.rangeClosed(1, 100).parallel().sum();
        System.out.println("sum2 = " + sum2);

    }
}
