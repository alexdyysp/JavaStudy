package com.stackoverflow.MapObjByStream;

public class SourceBean {
    private Integer poNum;
    private String vendor;
    private String indicator;
    private Integer count;

    public SourceBean(Integer poNum, String vendor, String indicator, Integer count) {
        this.poNum = poNum;
        this.vendor = vendor;
        this.indicator = indicator;
        this.count = count;
    }

    public Integer getPoNum() {
        return poNum;
    }

    public void setPoNum(Integer poNum) {
        this.poNum = poNum;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
