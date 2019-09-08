package fr.stateofmind.stream;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 5, 7);

        System.out.println("multiply(integers) = " + multiply(integers));
        Optional<Integer> result = multiplyWithoutIdentity(integers);
        System.out.println("multiplyWithoutIdentity(integers) = "
                + result.isPresent() + " " + result.get());

        Optional<Integer> emptyOptional = multiplyWithoutIdentity(Collections.emptyList());
        System.out.println("emptyOptional.isPresent() = " + emptyOptional.isPresent());

        Optional<Student> highestGpaStudent = getHighestGpaStudent();
        if (highestGpaStudent.isPresent()) {
            System.out.println("highestGpaStudent : " + highestGpaStudent.get());
        }
    }

    private static int multiply(List<Integer> integerList) {
        return integerList.stream()
                .reduce(1, (a, b) -> a * b);
    }

    private static Optional<Integer> multiplyWithoutIdentity(List<Integer> integerList) {
        return integerList.stream()
                .reduce((a, b) -> a * b);
    }

    private static  Optional<Student> getHighestGpaStudent() {
        return StudentDataBase.getAllStudents().stream()
                .reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
    }
}
