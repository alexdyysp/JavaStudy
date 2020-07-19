package com.Study.Stream;

import java.util.Random;
import java.util.stream.Stream;

public class MiddelStream {
    public static void main(String[] args){
        String str = "my name is dyy";

        // 每个单词长度
        System.out.println("split");
        Stream.of(str.split(" ")).map(s->s.length())
                .forEach(System.out::println);
        System.out.println("filter");
        Stream.of(str.split(" ")).filter(s->s.length()>2).map(s->s.length())
                .forEach(System.out::println);

        // FlatMap
        System.out.println("---FlatMap---");
        Stream.of(str.split(" ")).flatMap(s->s.chars().boxed())
                .forEach(i->System.out.println((char) i.intValue()));

        // peek
        System.out.println("---peek---");
        Stream.of(str.split(" ")).peek(System.out::println)
                .forEach(System.out::println);

        // limit
        new Random().ints().filter(i->i>100 && i<1000).limit(10)
                .forEach(System.out::println);
    }
}
