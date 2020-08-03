package com.stackoverflow.StringFormat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringFormat {

    public static String format(String input, Map<String, String> map) {
        // foreach map,用value替换掉key
        for (Map.Entry<String, String> entry : map.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue());
        }
        return input;
    }

    public static void main(String[] args) {

        // your code
        Map<Character, Character> map = new HashMap<Character, Character>();

        map.put('I', 'a');
        map.put('V', 'b');
        map.put('X', 'c');
        map.put('L', 'd');
        map.put('C', 'e');
        map.put('D', 'f');
        map.put('M', 'g');

        String s = "MCMXCIV";


    }
}