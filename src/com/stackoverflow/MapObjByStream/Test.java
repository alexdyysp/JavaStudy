package com.stackoverflow.MapObjByStream;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public List<TargetBean> List2Bean(List<SourceBean> sourceBeanList){
        TargetBean tgtBean = new TargetBean();
        for(SourceBean srcBean : sourceBeanList) {
            tgtBean.setPoNum(srcBean.getPoNum());
            tgtBean.setVendor(srcBean.getVendor());
            if(srcBean.getIndicator().equals("N")) {
                tgtBean.setRegCount(String.valueOf(srcBean.getCount()));
            }
            else if(srcBean.getIndicator().equals("Y")) {
                tgtBean.setOtherCount(String.valueOf(srcBean.getCount()));
            }
        }
        List<TargetBean> targetBeanList = new ArrayList<>();
        targetBeanList.add(tgtBean);
        return targetBeanList;
    }


    public static void main(String[] args){

        Test test = new Test();

        List<SourceBean> srcBeanList = new ArrayList<>();
        srcBeanList.add(new SourceBean(2490, "Vend A", "Y", 15));
        srcBeanList.add(new SourceBean(2490, "Vend A", "N", 400));

        Map<Integer, List<SourceBean>> srcMap = srcBeanList.stream()
                .collect(Collectors.groupingBy(SourceBean::getPoNum, Collectors.toList()));


        //List<TargetBean> targetBeanList = (List<TargetBean>)
        List<TargetBean> tgtMaplist =
                srcMap.entrySet().stream().map( e -> {return test.List2Bean(e.getValue());})
                        .map(item->item.get(0)).collect(Collectors.toList());

        tgtMaplist.stream().forEach(t -> {
            System.out.println(t.getPoNum() + " " + t.getVendor() + " " + t.getRegCount() + " " + t.getOtherCount() );
        });
    }
}
