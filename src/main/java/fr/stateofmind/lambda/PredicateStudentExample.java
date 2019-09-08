package fr.stateofmind.lambda;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateStudentExample {

    public static final List<Student> STUDENTS =StudentDataBase.getAllStudents();
    private static final Consumer<Student> NAME_CONSUMER = student -> System.out.println(student.getName());
    private static final Consumer<Student> ACTIVITIES_CONSUMER = student -> System.out.println(student.getActivities());
    private static final Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;
    private static final Predicate<Student> p2 = s -> s.getGpa() >= 3.9;

    public static void main(String[] args) {
        printNameAndActivitiesUsingCondition();
    }

    private static void printNameAndActivitiesUsingCondition() {
        STUDENTS.forEach(student -> {
            if (p1.and(p2).test(student)) {
                NAME_CONSUMER.andThen(ACTIVITIES_CONSUMER).accept(student);
            }
        });
    }
}
