package fr.stateofmind.lambda;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    private static final List<Student> STUDENT_LIST =StudentDataBase.getAllStudents();
    private static final Consumer<Student> NAME_CONSUMER = student -> System.out.println(student.getName());
    private static final Consumer<Student> ACTIVITIES_CONSUMER = student -> System.out.println(student.getActivities());

    public static void main(String[] args) {
        Consumer<String> uppercase = (s) -> System.out.println("s = " + s.toUpperCase());
        uppercase.accept("value");

        System.out.println("------------------------");
        printName();
        System.out.println("------------------------");
        printNameAndActivities();
        System.out.println("------------------------");
        printNameAndActivitiesUsingCondition();
    }

    private static void printName() {
        STUDENT_LIST.forEach(NAME_CONSUMER);
    }

    private static void printNameAndActivities() {
        STUDENT_LIST.forEach(NAME_CONSUMER.andThen(ACTIVITIES_CONSUMER));
    }

    private static void printNameAndActivitiesUsingCondition() {
        System.out.println("ConsumerExample.printNameAndActivitiesUsingCondition");
        STUDENT_LIST.forEach(student -> {
            if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
                NAME_CONSUMER.andThen(ACTIVITIES_CONSUMER).accept(student);
            }
        });
    }
}
