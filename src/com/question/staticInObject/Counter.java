package com.question.staticInObject;

public class Counter {
    // static表明属于类，而不是属于对象
    private static int count = 0;
    public int increment(){
        return count++;
    }
    public int anotherincrement(){
        return ++count;
    }
}
