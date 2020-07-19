package com.Study.Extend;

public class A extends person{
    int age = 30;
    public void methodPer(){
        System.out.println(super.age);
    }
    public void methodA(){
        System.out.println(this.age);
    }

}