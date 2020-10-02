package com.Study.lambda.funtionalinterface.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.sun.tools.javac.util.Assert;
import org.junit.Test;


/**
 * @Author daiyuanyang
 * @Date 2020/9/12 8:37 下午
 */
public class TestStudent {
    public static List<Student> listOfStudents;

    static {
        listOfStudents = new ArrayList<Student>();

        listOfStudents.add(new Student(111, "John", 81.0, "Mathematics"));
        listOfStudents.add(new Student(222, "Harsha", 79.5, "History"));
        listOfStudents.add(new Student(333, "Ruth", 87.2, "Computers"));
        listOfStudents.add(new Student(444, "Aroma", 63.2, "Mathematics"));
        listOfStudents.add(new Student(555, "Zade", 83.5, "Computers"));
        listOfStudents.add(new Student(666, "Xing", 58.5, "Geography"));
        listOfStudents.add(new Student(777, "Richards", 72.6, "Banking"));
        listOfStudents.add(new Student(888, "Sunil", 86.7, "History"));
        listOfStudents.add(new Student(999, "Jordan", 58.6, "Finance"));
        listOfStudents.add(new Student(101010, "Chris", 89.8, "Computers"));
    }

    @Test
    public void PredicateTest(){
        Predicate<Student> mathematicsPredicate = (Student student) -> student.getSpecialization().equals("Mathematics");

        List<Student> mathematicsStudents = new ArrayList<Student>();

        for (Student student : listOfStudents) {
            if (mathematicsPredicate.test(student)) {
                mathematicsStudents.add(student);
            }
        }

        Assert.check(mathematicsStudents.size()>0);
    }

    @Test
    public void CosumerTest(){
        Consumer<Student> percentageConsumer = (Student student) -> {
            System.out.println(student.getName()+" : "+student.getPercentage());
        };

        for (Student student : listOfStudents) {
            percentageConsumer.accept(student);
        }
    }

    @Test
    public void FunctionTest(){
        Function<Student, String> nameFunction = (Student Student) -> Student.getName();

        List<String> studentNames = new ArrayList<String>();

        for (Student student : listOfStudents) {
            studentNames.add(nameFunction.apply(student));
        }

        studentNames.forEach(System.out::println);
    }

    @Test
    public void Suppliertest(){
        Supplier<Student> studentSupplier = () ->
                new Student(999, "New Student", 92.9, "Java 8");

        listOfStudents.add(studentSupplier.get());
        System.out.println(listOfStudents.get(listOfStudents.size()-1).toString());
    }

}
