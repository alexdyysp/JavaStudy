package com.stackoverflow.SortObjectByStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestImprovedata {

    public static void main(String[] args){
        SubObject sub1 = new SubObject("typeA", "red");
        SubObject sub2 = new SubObject("typeA", "blue");
        SubObject sub3 = new SubObject("typeB", "green");
        SubObject sub4 = new SubObject("typeB", "green");
        SubObject sub5 = new SubObject("typeC", "red");
        SubObject sub6 = new SubObject("typeC", "blue");

        List<MasterObject> masterObjList = new ArrayList<>();

        masterObjList.add(new MasterObject("01/01/2020", Arrays.asList(sub1, sub2, sub3)));
        masterObjList.add(new MasterObject("02/01/2020", Arrays.asList(sub4, sub5, sub6)));

        masterObjList.stream().forEach(o -> {
            System.out.println(o.getDate());
            o.getSubObject().stream().forEach(e->{
                System.out.println(e.getColor() + " " + e.getType());
            });
        });

        System.out.println();

        Map<String, Map<String, Map<String, MasterObject>>> result = masterObjList
                .stream()
                .flatMap(o -> o.getSubObject()
                                .stream()
                                .map(s -> new CustomObject(o.getDate(), s.getType(), s.getColor(), o)))
                .collect(
                        Collectors.groupingBy(
                                CustomObject::getDate,
                                Collectors.groupingBy(
                                        CustomObject::getType,
                                        Collectors.toMap(CustomObject::getColor, CustomObject::getMasterObj))));

        result.entrySet().
                stream().
                forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().entrySet()
                            .stream().
                            forEach(e1 -> {
                                System.out.println("\t" + e1.getKey());
                                e1.getValue().entrySet()
                                        .stream().forEach(e2 -> {
                                            System.out.println("\t\t" + e2.getKey());
                });
            });
        });
    }
}
