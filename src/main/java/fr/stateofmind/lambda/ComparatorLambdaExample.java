package fr.stateofmind.lambda;

import java.util.Comparator;

public class ComparatorLambdaExample {

    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // 0 -> o1=o2 / 1 -> o1>o2 / -1 -> o1<o2
            }
        };

        System.out.println("Compare 3 and 2 : " + comparator.compare(3, 2)); // 1

        // Java 8 lambda
        Comparator<Integer> lambdaComparator1 = (Integer a, Integer b) ->  a.compareTo(b);
        System.out.println("Compare 3 and 2 using lambda : " + lambdaComparator1.compare(3, 2)); // 1

        Comparator<Integer> lambdaComparator2 = (a, b) ->  a.compareTo(b);
        System.out.println("Compare 3 and 2 using lambda : " + lambdaComparator2.compare(3, 2)); // 1

    }
}
