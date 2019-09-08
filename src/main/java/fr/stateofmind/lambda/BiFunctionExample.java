package fr.stateofmind.lambda;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {
    static Predicate<Student> p2 = s -> s.getGpa() >= 3.9;

    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction
            = (students, studentPredicate) -> {
        HashMap<String, Double> studentGradeMap = new HashMap<>();
        students.forEach(student -> {
            if (studentPredicate.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });
        return studentGradeMap;
    };

    public static void main(String[] args) {
        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), p2));
    }
}
