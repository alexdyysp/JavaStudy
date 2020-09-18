package com.stackoverflow.q20200916;

import sun.jvm.hotspot.oops.Instance;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author daiyuanyang
 * @Date 2020/9/16 9:20 下午
 */
public class A {
    private Integer a;
    private String b;

    public static void main(String[] args) {
        A aobject = new A();
        Field[] fields = A.class.getDeclaredFields();
        Arrays.stream(fields).collect(Collectors.toList()).stream().map(Field::getName).forEach(System.out::println);
    }
}
