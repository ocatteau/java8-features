package fr.stateofmind.interactivedeclarative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImperativeVsDeclarativeExample2 {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 3, 4, 4, 2, 6, 7, 8);
        /** Imperative **/
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer value : values) {
            if (!uniqueList.contains(value)) {
                uniqueList.add(value);
            }
        }
        System.out.println("uniqueList = " + uniqueList);

        /** Declarative **/
        List<Integer> uniqList = values.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqList);
    }
}
