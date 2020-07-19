package com.Study.lambda;

import java.util.function.Consumer;
import java.util.function.IntPredicate;

public class FuncInt {
    public static void main(String[] args){
        // assert
        IntPredicate predicate = i -> i>0;
        System.out.println(predicate.test(-10));

        // consumer
        Consumer<String> con = s -> System.out.println(s);
        con.accept("this is consumer");
    }
}
