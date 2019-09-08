package fr.stateofmind.methodreference;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    public static void main(String[] args) {
        StudentDataBase.getAllStudents().forEach(System.out::println);

        Consumer<Student> printListOfActivities = Student::printListOfActivities;
        StudentDataBase.getAllStudents().forEach(printListOfActivities);
    }
}
