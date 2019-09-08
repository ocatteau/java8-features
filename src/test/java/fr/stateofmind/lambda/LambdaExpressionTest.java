package fr.stateofmind.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.fest.assertions.Assertions.assertThat;

public class LambdaExpressionTest {


    @Test public void returnString() throws Exception {
        LambdaExpression fct = () -> "luke";
        String actual = fct.returnString();

        assertThat(actual).isEqualTo("luke");
    }

    @Test public void addIntValues() throws Exception {
        SimpleAddIntExpression fct = (int a, int b) -> a + b;
        int actual = fct.addIntValues(12, 3);

        assertThat(actual).isEqualTo(15);
    }

    @Test public void collection1() throws Exception {
        List<Person> persons = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 44),
                new Person("Thomas", "Carlyle", 50),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39));

        Collections.sort(persons, (person1, person2) -> person1.getLastName().compareTo(person2.getLastName()));

        persons.stream().forEach(p -> System.out.println(p));

        System.out.println();

        persons.stream().filter(p -> p.getLastName().startsWith("C")).forEach(System.out::println);
    }

    @Test public void lambdaStaticCall() throws Exception {
        Thread thread = new Thread(LambdaExpressionTest::printHello);
        thread.start();
    }

    @Test public void forEachOnCollection() throws Exception {
        List<Person> persons = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 44),
                new Person("Thomas", "Carlyle", 50));
        assertThat(persons).onProperty("age").containsExactly(60, 44, 50);

        persons.forEach(p -> p.setAge(20));

        assertThat(persons).onProperty("age").containsExactly(20, 20, 20);
    }

    private static void printHello() {
        System.out.println("Hello");
    }
}