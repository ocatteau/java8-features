package fr.stateofmind.methodreference;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RefacorMethodReferenceExample {

//    private static final Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;
    private static final Predicate<Student> p1 = RefacorMethodReferenceExample::greatgerThanGradeLevel;

    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () -> new Student("Bob", 3, 3.6, "male", Arrays.asList("Swimming", "Running"));
        System.out.println(p1.test(studentSupplier.get()));
    }

    public static boolean greatgerThanGradeLevel(Student student) {
        return student.getGradeLevel() >= 3;
    }
}
