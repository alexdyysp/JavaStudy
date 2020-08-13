package com.stackoverflow.easyQuestion;

import java.util.*;
import java.util.stream.Collectors;

public class reducing {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,4,6);
        nums.stream()
                .filter((p) -> p <= 8)
                .map(Collections::singleton)
                .reduce(new Set<Integer>, (s1, s2) -> {
                    int sumS1 = s1.stream().reduce(0, (n1, n2) -> n1 + n2);
                    if (sumS1 == 8 ) return s1;
                    int sumS2 = s1.stream().reduce(0, (n1, n2) -> n1 + n2);
                    if (sumS1 + sumS2 <= 8 ) {
                        s1.addAll(s2);
                        return s1;
                    }
                    return s1;
                })
                .collect(Collectors.toList());
    }
}