package fr.stateofmind.lambda;

import fr.stateofmind.lambda.data.Student;
import fr.stateofmind.lambda.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () -> new Student("Bob", 2, 3.6, "male", Arrays.asList("Swimming", "Running"));
        System.out.println("studentSupplier.get() = " + studentSupplier.get());

        Supplier<List<Student>> studentsSupplier = () -> StudentDataBase.getAllStudents();
        System.out.println("studentsSupplier.get() = " + studentsSupplier.get());
    }
}
