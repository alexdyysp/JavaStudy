package com.Study.Stream.List2Map;

import com.google.common.collect.Lists;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author daiyuanyang
 * @Date 2020/9/3 9:31 下午
 */
public class StreamList2Map {
    public Map<Integer, List<CityInfo>> list2Map(List<CityProvince> cityProvinceList){
        if(cityProvinceList.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<Integer, List<CityProvince>> tmpMap = cityProvinceList.stream()
                .collect(Collectors.groupingBy(CityProvince::getProvinceId, Collectors.toList()));

        Map<Integer, List<CityInfo>> resMap = new HashMap<>();

        tmpMap.entrySet().forEach(e -> resMap.put(e.getKey(),
                e.getValue().stream()
                        .map(s->new CityInfo(s.getCityId(), s.getCityName())).collect(Collectors.toList())));

        return resMap;
    }

    public static void main(String[] args) throws IOException {

        StreamList2Map streamList2Map = new StreamList2Map();

        List<CityProvince> cityProvinceInfoList = Lists.newArrayList(
                new CityProvince(1, "江苏", 101,"南京"),
                new CityProvince(1, "江苏", 102,"扬州"),
                new CityProvince(2, "浙江", 201,"杭州"),
                new CityProvince(2, "浙江", 202,"金华"));

        Map<Integer, List<CityInfo>> integerListMap = streamList2Map.list2Map(cityProvinceInfoList);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(integerListMap));

    }
}
