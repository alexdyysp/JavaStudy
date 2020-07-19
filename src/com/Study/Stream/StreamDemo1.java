package com.Study.Stream;

import java.util.stream.IntStream;

public class StreamDemo1 {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        // 外部迭代
        int sum=0;
        for(int i:nums){
            sum += i;
        }
        System.out.println("outer result: " + sum);

        // 内部迭代
        int sum2 = IntStream.of(nums).map(i->i*2).sum();
        System.out.println("inter result: " + sum2);

        int sum3 = IntStream.of(nums).map(StreamDemo1::doublenum).sum();
        System.out.println("lazy result: " + sum3);
        IntStream.of(nums).map(StreamDemo1::doublenum);
    }

    public static int doublenum(int i){
        System.out.println("*2");
        return i*2;
    }
}
