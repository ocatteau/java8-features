package fr.stateofmind.stream;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamFlatMapExample {

    public static void main(String[] args) {
        List<String> names = StudentDataBase.getAllStudents()
                .stream() // Stream<Student>
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(toList());
        System.out.println("names = " + names);

        long nbActivities = StudentDataBase.getAllStudents()
                .stream() // Stream<Student>
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
        System.out.println("nbActivities = " + nbActivities);
    }
}
