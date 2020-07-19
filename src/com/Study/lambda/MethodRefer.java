package com.Study.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

class Dog{

    public String name = "xiaotian";
    public Integer food = 100;

    public static void bark(Dog dog){
        System.out.println(dog + " Bark and Bark");
    }

    public int eat(int food){
        System.out.println("eat "+food+" food");
        this.food -= food;
        return this.food;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
public class MethodRefer {
    public static void main(String[] args){
        // 方法引用
        Consumer<String> con = System.out::println;
        con.accept("accept data");

        // 静态方法引用
        Consumer<Dog> d = Dog::bark;
        Dog dog = new Dog();
        d.accept(dog);

        // 非静态对象，使用实例引用
        UnaryOperator<Integer> fun = dog::eat;
        System.out.println("The rest is " + fun.apply(20));
    }
}
