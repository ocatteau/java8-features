package fr.stateofmind.stream;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamMapReduceExample {

    public static void main(String[] args) {
        System.out.println("noOfNoteBooks() = " + noOfNoteBooks());
    }

    private static int noOfNoteBooks() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGradeLevel() >= 3)
                .map(Student::getNotebooks) // Stream<Integer>
//                .reduce(0, (a, b) -> a + b);
                .reduce(0, Integer::sum);
    }
}
