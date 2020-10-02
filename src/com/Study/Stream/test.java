package com.Study.Stream;

import com.google.common.base.Strings;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class test {

    @Test
    public void splitString(){
        Stream.of("22,19".split(","))
                .distinct()
                .forEach(System.out::println);
    }

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
