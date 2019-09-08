package fr.stateofmind.lambda;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static final List<Student> ALL_STUDENTS = StudentDataBase.getAllStudents();

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (a,b) -> System.out.println("a = " + a + " - b = " + b);
        biConsumer.accept("java7", "java8");

        BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println("a*b = " + a * b);
        BiConsumer<Integer, Integer> division = (a, b) -> System.out.println("a/b = " + a / b);

        multiply.andThen(division).accept(10, 5);

        nameAndActivities();
    }

    private static void nameAndActivities() {
        BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + " : " + activities);
        ALL_STUDENTS.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }
}
