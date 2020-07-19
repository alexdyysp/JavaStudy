package com.Study.lambda;

@FunctionalInterface
interface interface1{
    int doubleNum(int i);

    default int add(int a, int b){
        return a+b;
    }
}


public class LambdaDemo1 {
    public static void main(String[] args) {
        interface1 i1 = (i) -> i*2;
        System.out.println(i1.add(4,5));
        System.out.println(i1.doubleNum(40));
    }
}
