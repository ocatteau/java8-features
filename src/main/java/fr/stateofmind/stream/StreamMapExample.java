package fr.stateofmind.stream;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class StreamMapExample {

    public static void main(String[] args) {
        Set<String> names = StudentDataBase.getAllStudents()
                .stream() // Stream<Student>
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<String>
                .collect(toSet());
        System.out.println("names = " + names);
    }
}
