package fr.stateofmind.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionsVsStreamExample {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Bob");
        names.add("Bill");
        names.add("Tim");

        names.remove(0);

        System.out.println("names = " + names);

        Stream<String> nameStream = names.stream();
        nameStream.forEach(System.out::println);
//        nameStream.forEach(System.out::println);
    }
}
