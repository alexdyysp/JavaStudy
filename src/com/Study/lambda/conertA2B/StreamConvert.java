package com.Study.lambda.conertA2B;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class StreamConvert {

    public List<A> setA(){
        List<A> listA= new ArrayList<>();
        for(int i=0; i<5; i++){
            listA.add(new A(i, String.valueOf(i)));
        }
        return listA;
    }


    public static void main(String[] args){
        StreamConvert streamConvert = new StreamConvert();

        List<A> listA = streamConvert.setA();
        listA.stream().forEach((A a)->{
            System.out.println(a.getA() + a.getB());
        });

        List<B> listB = listA.stream()
                .map((A a)->{
                    return new B(a.getA()*2, a.getB());
                })
                .collect(Collectors.toList());

        listB.stream().forEach((B)->{
            System.out.println(B.getA() + B.getB());
        });    }
}

