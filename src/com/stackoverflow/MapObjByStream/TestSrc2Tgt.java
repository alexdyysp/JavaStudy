package com.stackoverflow.MapObjByStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// https://stackoverflow.com/questions/63085862/how-to-use-java-stream-map-a-listsrc-to-an-object-tgt
public class TestSrc2Tgt {

    public static List<Tgt> listSrc2ListTgt(List<Src> srcList){
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
        /* it is my question and I do not want to use List
            What I want is convert List<Src> to Tgt which is a kind of combine srcList
         */
        List<Tgt> tgtList = new ArrayList<>();
        tgtList.add(tgt);
        return tgtList;
    }

    public static Tgt listSrc2Tgt(List<Src> srcList){
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

    public static void printTgtList(List<Tgt> tgtList){
        tgtList.stream().forEach(t -> {
            System.out.print("id: ");
            System.out.println(t.getId());
            System.out.print("False Count: ");
            System.out.println(t.getFalse_count());
            System.out.print("True Count: ");
            System.out.println(t.getTrue_count());
        });
    }

    // 使用Pair做intermiddle
    public List<Tgt> methodStreamByPair(List<Src> srcList){
        return srcList.stream()
                .collect(Collectors.groupingBy(Src::getId, Collector.of(
                        () -> new interPair<>(0L, 0L),
                        (pair, src) -> {
                            if (src.isFlag())
                                pair.setKey(pair.getKey() + src.getCount());
                            else
                                pair.setValue(pair.getValue() + src.getCount());
                        },
                        (pairA, pairB) -> new interPair<>(pairA.getKey() + pairB.getKey(), pairA.getValue() + pairB.getValue())
                )))
                .entrySet()
                .stream()
                .map(entry -> new Tgt(entry.getKey(), (int) (long) entry.getValue().getKey(), (int) (long) entry.getValue().getValue()))
                .collect(Collectors.toList());
    }

    // 用.entrySet()只能先变成list<Tgt>
    public List<Tgt> methodStreamByList2List(List<Src> srcList){
        Map<Integer, List<Src>> srcMap = srcList.stream()
                .collect(Collectors.groupingBy(Src::getId, Collectors.toList()));

        // 我写的list2list，其实不用.get(0)
        return srcMap.entrySet().stream()
                .map( e -> {return listSrc2ListTgt(e.getValue());})
                .map(item->item.get(0)).collect(Collectors.toList());
    }

    // 用.values()直接转
    public List<Tgt> methodStreamByList2Tgt(List<Src> srcList) {
        Map<Integer, List<Src>> srcMap = srcList.stream()
                .collect(Collectors.groupingBy(Src::getId, Collectors.toList()));

        // .values()方法即可获得list集合
        return srcMap.values().stream()
                .map(TestSrc2Tgt::listSrc2Tgt)
                .collect(Collectors.toList());
    }

    /*
    先转Map,再两层循环遍历
     */
    public List<Tgt> methodStreamByGroupAndCombine(List<Src> srcList) {
        return srcList.stream()
                .collect(Collectors.groupingBy(Src::getId, Collectors.toList()))
                .entrySet().stream()
                .map(e ->
                        new Tgt(e.getKey(),
                                e.getValue().stream().mapToInt(s -> s.isFlag() ? s.getCount() : 0).sum(),
                                e.getValue().stream().mapToInt(s -> !s.isFlag() ? s.getCount() : 0).sum())
                ).collect(Collectors.toList());
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
        srcList.add(new Src(3, true, 40));
        srcList.add(new Src(3, false, 50));
        srcList.add(new Src(3, true, 40));
        srcList.add(new Src(4, true, 40));
        srcList.add(new Src(4, false, 50));
        srcList.add(new Src(4, true, 40));

        Long beginTime = new Date().getTime();
        List<Tgt> tgtList = testSrc2Tgt.methodStreamByList2List(srcList);
        Long opetime =new Date().getTime()-beginTime;
        printTgtList(tgtList);
        System.out.println("methodStreamByList2List Method Using :" + String.valueOf(opetime) + "times...");

        beginTime = new Date().getTime();
        List<Tgt> tgtList1 = testSrc2Tgt.methodStreamByList2Tgt(srcList);
        opetime =new Date().getTime()-beginTime;
        printTgtList(tgtList1);
        System.out.println("methodStreamByList2Tgt  Method Using :" + String.valueOf(opetime) + "times...");

        beginTime = new Date().getTime();
        List<Tgt> tgtList2 = testSrc2Tgt.methodStreamByGroupAndCombine(srcList);
        opetime =new Date().getTime()-beginTime;
        printTgtList(tgtList2);
        System.out.println("methodStreamByGroupAndCombine  Method Using :" + String.valueOf(opetime) + "times...");

        beginTime = new Date().getTime();
        List<Tgt> tgtList3 = testSrc2Tgt.methodStreamByPair(srcList);
        opetime =new Date().getTime()-beginTime;
        printTgtList(tgtList3);
        System.out.println("methodStreamByPair  Method Using :" + String.valueOf(opetime) + "times...");
    }
}
