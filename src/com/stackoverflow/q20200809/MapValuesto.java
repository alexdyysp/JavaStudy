package com.stackoverflow.q20200809;

import com.stackoverflow.MapObjByStream.Src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapValuesto {

    public static void main(String[] args){
        Map<String, String> mapData= new HashMap<String, String>(){
            @Override
            public String put(String key, String value) {
                if(!this.containsKey(key)){
                    return super.put(key,value);
                }else{
                    return super.put(key, this.get(key)+","+value);
                }
            }
        };
        mapData.put("key1", "val1");
        mapData.put("key1", "val2");
        mapData.put("key2", "val4");
        mapData.put("key2", "val5");

        mapData.entrySet().forEach(System.out::println);

        System.out.println(mapData.get("key1"));
    }
}
