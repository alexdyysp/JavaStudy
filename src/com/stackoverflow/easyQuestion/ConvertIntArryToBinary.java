package com.stackoverflow.easyQuestion;

import java.util.Arrays;

public class ConvertIntArryToBinary {
    public static void main(String[] args){

        Integer[] arr = {1,2,3,4};
        int n = arr.length;

        String[] bin = new String[n];

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            bin[i] = Integer.toBinaryString(arr[i]);
            maxLen = Math.max(maxLen, bin[i].length());
        }
        Arrays.stream(bin).forEach(System.out::println);

        for (int i = 0; i < n; i++) {
            if (bin[i].length() != maxLen)
                bin[i] = String.format("%" + maxLen + "s", bin[i]).replace(' ', '0');
            System.out.println(bin[i]);
        }
    }
}
