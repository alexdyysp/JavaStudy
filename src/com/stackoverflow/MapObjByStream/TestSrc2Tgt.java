package com.stackoverflow.MapObjByStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestSrc2Tgt {

    public List<Tgt> ListSrc2ListTgt(List<Src> srcList){
        Tgt tgt = new Tgt();
        for(Src src : srcList) {
            tgt.setId(src.getId());
            if(src.isFlag()) {
                tgt.setTrue_count(src.getCount());
            }
            else {
                tgt.setFalse_count(src.getCount());
            }
        }
        /* it is my question and I do not want to use List
            What I want is convert List<Src> to Tgt which is a kind of combine srcList
         */
        List<Tgt> tgtList = new ArrayList<>();
        tgtList.add(tgt);
        return tgtList;
    }

    public Tgt ListSrc2Tgt(List<Src> srcList){
        Tgt tgt = new Tgt();
        for(Src src : srcList) {
            tgt.setId(src.getId());
            if(src.isFlag()) {
                tgt.setTrue_count(tgt.getTrue_count() + src.getCount());
            }
            else {
                tgt.setFalse_count(tgt.getFalse_count() + src.getCount());
            }
        }
        return tgt;
    }

    public static void main(String[] args){

        TestSrc2Tgt testSrc2Tgt = new TestSrc2Tgt();

        List<Src> srcList = new ArrayList<>();
        srcList.add(new Src(1, true, 15));
        srcList.add(new Src(1, false, 20));
        srcList.add(new Src(1, false, 110));
        srcList.add(new Src(2, true, 40));
        srcList.add(new Src(2, false, 250));
        srcList.add(new Src(2, true, 420));

        Map<Integer, List<Src>> srcMap = srcList.stream()
                .collect(Collectors.groupingBy(Src::getId, Collectors.toList()));

//        List<Tgt> tgtMaplist =
//                srcMap.entrySet().stream().map( e -> {return testSrc2Tgt.ListSrc2ListTgt(e.getValue());})
//                        .map(item->item.get(0)).collect(Collectors.toList());

        List<Tgt> tgtMaplist2 = srcMap.values().stream()
                .map(testSrc2Tgt::ListSrc2Tgt)
                .collect(Collectors.toList());


        tgtMaplist2.stream().forEach(t -> {
            System.out.println(t.getId());
            System.out.println(t.getFalse_count());
            System.out.println(t.getTrue_count());
        });

//        tgtMaplist.stream().forEach(t -> {
//            System.out.println(t.getId());
//            System.out.println(t.getFalse_count());
//            System.out.println(t.getTrue_count());
//        });
    }
}
