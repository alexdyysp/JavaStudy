package com.stackoverflow.SortObjectByStream;

import java.util.List;

public class MasterObject {

    private String date;
    private List<SubObject> subObject;

    public MasterObject(String date, List<SubObject> subObject){
        this.date = date;
        this.subObject = subObject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<SubObject> getSubObject() {
        return subObject;
    }

    public void setSubObject(List<SubObject> subObject) {
        this.subObject = subObject;
    }
}
