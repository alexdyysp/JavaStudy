package com.Study.Stream;

import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println("skip:");
        numbers.stream().skip(2).forEach(System.out::println);

        System.out.println("limit:");
        numbers.stream().limit(2).forEach(System.out::println);

        System.out.println("limit and skip");
        numbers.stream().skip(2).limit(2).forEach(System.out::println);
    }
}
