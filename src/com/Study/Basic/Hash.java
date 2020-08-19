package com.Study.Basic;

import java.util.HashMap;
import java.util.Map;

public class Hash {

    static class Example{
        String Id;
        Long poi_id;

        public String getId() {
            return Id;
        }

        public Long getPoi_id() {
            return poi_id;
        }

        public void setId() {
            Id = poi_id+","+poi_id;
        }

        public void setPoi_id(Long poi_id) {
            this.poi_id = poi_id;
        }
    }

    static Map<Integer, Example> m = new HashMap<>();

    public static void main(String[] args){
        Example e = new Example();
        e.setPoi_id(100L);
        e.setId();
        m.put(1,e);
        System.out.println(m.get(1).getId());
        e.setPoi_id(101L);
        e.setId();
        System.out.println(m.get(1).getId());

    }
}
