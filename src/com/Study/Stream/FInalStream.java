package com.Study.Stream;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FInalStream {
    public static void main(String[] args){
        String str = "my name is dyy";

        // 并行流 and foreach
        System.out.println("并行流");
        str.chars().parallel().forEach(i->System.out.print((char) i));
        System.out.println();
        // 保证顺序
        str.chars().parallel().forEachOrdered(i->System.out.print((char) i));
        System.out.println();

        // collect
        List<String> list = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(list);

        // reduce
        Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1+"|"+s2);
        System.out.println(letters.orElse(""));

        String reduce = Stream.of(str.split(" "))
                .reduce("",(s1,s2)->s1+"|"+s2);
        System.out.println(reduce);

        Integer len = Stream.of(str.split(" ")).map(s->s.length())
                .reduce(0, (s1,s2)->s1+s2);
        System.out.println(len);

        Optional<String> maxstr = Stream.of(str.split(" ")).max((s1,s2)->s1.length()-s2.length());
        System.out.println(maxstr.orElse(""));

        // 短路操作
        OptionalInt ff = new Random().ints().findFirst();
        System.out.println(ff.getAsInt());

    }
}
