package com.Study.Json;

public class Test {
    public static void main(String[] args){
        String json = "{“ID”:\"1\",\"Code\":\"22\",\"QuoteTime\":\"2013-12-12\",\"Last\":\"22\"}";
        System.out.println(json);

        String pattern = "(?<=\\\"Code\\\":\\\")[^\\\",]*";
        json = json.replaceAll(pattern, "88");
        System.out.println(json);
    }
}
