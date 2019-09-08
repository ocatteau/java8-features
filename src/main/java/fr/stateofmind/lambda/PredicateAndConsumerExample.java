package fr.stateofmind.lambda;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    public static final List<Student> STUDENTS =StudentDataBase.getAllStudents();
    private static final Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;
    private static final Predicate<Student> p2 = s -> s.getGpa() >= 3.9;
    
    public static void main(String[] args) {
        printNameAndActivities();
        System.out.println("----------------------------------");
        printNameAndActivitiesBiPredicate();
    }

    private static void printNameAndActivities() {
        BiConsumer<String, List<String>> consumer = (name, activities) -> System.out.println(name + " : " + activities);
        Consumer<Student> studentConsumer = student -> {
            if (p1.and(p2).test(student)) {
                consumer.accept(student.getName(), student.getActivities());
            }
        };
        STUDENTS.forEach(studentConsumer);
    }

    private static void printNameAndActivitiesBiPredicate() {
        BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa >= 3.9;
        BiConsumer<String, List<String>> consumer = (name, activities) -> System.out.println(name + " : " + activities);
        Consumer<Student> studentConsumer = student -> {
            if (biPredicate.test(student.getGradeLevel(), student.getGpa())) {
                consumer.accept(student.getName(), student.getActivities());
            }
        };
        STUDENTS.forEach(studentConsumer);
    }
}
