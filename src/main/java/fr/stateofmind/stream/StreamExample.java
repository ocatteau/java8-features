package fr.stateofmind.stream;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        Predicate<Student> studentPredicate = student -> student.getGradeLevel() >= 3;
        Predicate<Student> studentGpaPredicate = student -> student.getGpa() >= 3.8;
        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
                .filter(studentPredicate)
                .filter(studentGpaPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println("studentMap = " + studentMap);
    }
}
