package com.question.staticInObject;

import com.question.staticInObject.Counter;

public class Spike {
    public static void main(String[] args){
        Counter a = new Counter();
        System.out.println(a.increment());
        System.out.println(a.anotherincrement());

        // 新建对象，不影响static修饰的变量
        Counter b = new Counter();
        System.out.println(b.increment());
    }
}

