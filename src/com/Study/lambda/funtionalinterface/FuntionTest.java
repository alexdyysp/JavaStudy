package com.Study.lambda.funtionalinterface;

import java.util.function.Function;

/**
 * @Author daiyuanyang
 * @Date 2020/9/10 10:22 上午
 */
public class FuntionTest {
    public static void main(String[] args) {
        // 根据上面的解释想一下执行结果
        Function<Integer, Integer> name = e -> e * 2;
        Function<Integer, Integer> square = e -> e * e;
        int value = name.andThen(square).apply(3);
        System.out.println(value);
        int value2 = name.compose(square).apply(3);
        System.out.println(value2);

        //返回一个执行了apply()方法之后只会返回输入参数的函数对象
        Object identity = Function.identity().apply("Test");
        System.out.println(identity);
    }
}