package com.Study.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectArrayAnd3dot {

    public static void printObject(Object... source){
        for (int i=0; i<source.length; i++){
            System.out.println(source.toString());
        }
    }

    public static void main(String[] args){
        printObject("fas","as","asf");

        List<String> list = new ArrayList(3);
        list.add("fas");
        list.add("baz");
        list.add("fox");
        printObject(list.toArray());

    }
}
