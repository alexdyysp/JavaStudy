package com.Study.Stream;

import com.sun.xml.internal.ws.policy.PolicyMapUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//import org.apache.commons.collections.MapUtils;


class Student{
    private String name;
    private int age;
    private Grade grade;
    private Gender gender;

    public Student(String name, int age, Gender gender, Grade grade){
        super();
        this.age = age;
        this.grade = grade;
        this.name = name;
        this.gender = gender;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Grade getGrade() {
        return grade;
    }



    @Override
    public String toString(){
        return "[name=" + name + ",age=" + age + ",grade=" + grade + ",gender=" + gender + "]";
    }

}

enum Gender{
    MALE,FEMALE
}

enum Grade{
    First,Second,Third,Foruth
}

public class Collection {
    public static void main(String[] args){
        List<Student> students = Arrays.asList(
                new Student("xiapoming", 10, Gender.MALE,Grade.First),
                new Student("xiawang", 15, Gender.MALE,Grade.Second),
                new Student("xiaosun", 8, Gender.FEMALE,Grade.Third),
                new Student("xiaoasf", 10, Gender.FEMALE,Grade.Foruth)
        );

        // 得到所有学生年龄列表
        Set<Integer> ages = students.stream().map(s->s.getAge()).collect(Collectors.toSet());
        System.out.println(ages);

        // 统计汇总信息
        IntSummaryStatistics agesStat = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(agesStat);

        // 分块
        Map<Boolean, List<Student>> gen = students.stream().collect(Collectors.partitioningBy(s->s.getGender()==Gender.MALE));
        System.out.println(gen);
        //MapUtils.verbosePrint(gen);

        // 分组
        Map<Grade, List<Student>> grad = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        System.out.println(grad);

        // 得到每个年级学生个数
        Map<Grade, Long> gradeCount = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        System.out.println(gradeCount);
    }
}