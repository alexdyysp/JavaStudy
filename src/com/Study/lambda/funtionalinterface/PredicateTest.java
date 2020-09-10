package com.Study.lambda.funtionalinterface;

import java.util.function.Predicate;

/**
 * @Author daiyuanyang
 * @Date 2020/9/10 10:33 上午
 */
public class PredicateTest {
    public static void main(String[] args) {
        String name = "hello";
        Predicate<String> predicate = x -> x.equals("hello");
        System.out.println(predicate.test(name));
        Predicate<String> predicate2 = x -> x.length() < 2;
        // and 多个Predicate条件并的关系判断，第一个为false就不往下走了，满足短路原则
        System.out.println(predicate.and(predicate2).test(name));
        // or 多个Predicate条件或的关系判断，同样满足短路原则
        System.out.println(predicate.or(predicate2).test(name));
        // negate 取反的意思，就是否的条件判断
        System.out.println(predicate.and(predicate2.negate()).test(name));
       // isEqual 静态方法，判断是否相等
        System.out.println(Predicate.isEqual(name).test(name));
    }
}
