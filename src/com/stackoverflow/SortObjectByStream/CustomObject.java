package com.stackoverflow.SortObjectByStream;

public class CustomObject {
    private String date;
    private String type;
    private String color;
    private MasterObject masterObj;

    // constructor, getters, setters


    public CustomObject(String date, String type, String color, MasterObject masterObj) {
        this.date = date;
        this.type = type;
        this.color = color;
        this.masterObj = masterObj;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public MasterObject getMasterObj() {
        return masterObj;
    }

    public void setMasterObj(MasterObject masterObj) {
        this.masterObj = masterObj;
    }
}
