package fr.stateofmind.lambda;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionStudentExample {


    private static final Predicate<Student> p2 = s -> s.getGpa() >= 3.9;

    private static Function<List<Student>, Map<String, Double>> studentFunction = (students -> {
        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach(student -> {
            if (p2.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });
        return studentGradeMap;
    });

    public static void main(String[] args) {
        Map<String, Double> gradeMap = studentFunction.apply(StudentDataBase.getAllStudents());
        System.out.println("gradeMap = " + gradeMap);
    }
}
