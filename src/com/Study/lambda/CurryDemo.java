package com.Study.lambda;

import java.util.function.Function;

public class CurryDemo {
    public static void main(String[] args){

        Function<Integer, Function<Integer, Function<Integer, Integer>>> fun2 = x -> y -> z -> x + y + z;


        int[] nums = {2,3,4};
        Function f = fun2;

        for(int i=0; i<nums.length; i++){
            if(f instanceof Function){
                Object obj = f.apply(nums[i]);
                if(obj instanceof Function) {
                    f = (Function) obj;
                } else
                    System.out.println("apply end: " + obj);
            }
        }
    }
}
