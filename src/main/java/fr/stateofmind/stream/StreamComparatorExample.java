package fr.stateofmind.stream;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamComparatorExample {

    public static void main(String[] args) {
        sortStudentsByName().forEach(System.out::println);
        System.out.println("---");
        sortStudentsByGpa().forEach(System.out::println);
        System.out.println("---");
        sortStudentsByGpaDesc().forEach(System.out::println);
    }

    private static List<Student> sortStudentsByName() {
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(toList());
    }

    private static List<Student> sortStudentsByGpa() {
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(toList());
    }
    private static List<Student> sortStudentsByGpaDesc() {
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(toList());
    }
}
