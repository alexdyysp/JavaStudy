package com.Study.lambda.funtionalinterface.Student;

/**
 * @Author daiyuanyang
 * @Date 2020/9/12 8:37 下午
 */
public class Student {
    int id;
    String name;
    double percentage;
    String specialization;

    public Student(int id, String name, double percentage, String specialization)
    {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.specialization = specialization;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPercentage() {
        return percentage;
    }
    public String getSpecialization() {
        return specialization;
    }
    @Override
    public String toString()
    {
        return id+"-"+name+"-"+percentage+"-"+specialization;
    }
}
