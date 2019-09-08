package fr.stateofmind.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StreamMinMaxExample {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6, 7, 8, 9, 10);
        System.out.println("maxValue = " + maxValue(integers));
        System.out.println("minValue = " + minValue(integers));

        Optional<Integer> maxValueOptional = maxValueOptional(integers);
        if (maxValueOptional.isPresent()) {
            System.out.println("maxValueOptional = " + maxValueOptional);
        }
        Optional<Integer> minValueOptional = minValueOptional(integers);
        if (minValueOptional.isPresent()) {
            System.out.println("minValueOptional = " + minValueOptional);
        }

        Optional<Integer> maxValueEmptyOptional = maxValueOptional(Collections.emptyList());
        if (!maxValueOptional.isPresent()) {
            System.out.println("list is empty");
        }

    }

    private static int maxValue(List<Integer> integers) {
        return integers.stream()
//                .reduce(0, (a, b) -> a > b ? a : b);
                .reduce(0, Integer::max);
    }

    private static int minValue(List<Integer> integers) {
        return integers.stream()
//                .reduce(0, (a, b) -> a < b ? a : b);
                .reduce(0, Integer::min);
    }

    private static Optional<Integer> maxValueOptional(List<Integer> integers) {
        return integers.stream().reduce(Integer::max);
    }

    private static Optional<Integer> minValueOptional(List<Integer> integers) {
        return integers.stream().reduce(Integer::min);
    }
}
