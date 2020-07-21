package com.stackoverflow.WildCharInList;

import java.util.ArrayList;
import java.util.List;

public class teststack {



    public static void main(String[] args){
        List<Object> list1 = new ArrayList<>();
        list1.add(1L);
        list1.add("hello");
        System.out.println("List is : " + list1);

        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(10));
        a1.add(new String("string"));

        System.out.println("List is : " + a1);

        List<?> a4 = a1;
        a4.remove(0);
        System.out.println("List is : " + a4);

        System.out.println("List is : " + a4.get(0));

        a4.clear();
        System.out.println("List is : " + a4);


    }
}
