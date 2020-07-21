package com.stackoverflow;

import java.util.Arrays;
import java.util.Comparator;

public class lambdaFor2DArrays {
    public static void main(String[] args){

        int[][] matrix = {{1,2}, {3,20}, {40,5}, {3,2}};
        // Sort By Comparator
        /*
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });
        */

        // Sort By Lambda
        Arrays.sort(matrix, (int[] o1, int[] o2)->{
            return (o1[0] - o1[1]) - (o2[0] - o2[1]);
        });

        //Arrays.sort(matrix, Comparator.comparingInt((o)->(o[0]-o[1])));

        // Print Result

        Arrays.asList(matrix).forEach(x -> System.out.println(x[0]+" "+x[1]));

        /*
        for (int[] arr : matrix) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        */
    }
}

