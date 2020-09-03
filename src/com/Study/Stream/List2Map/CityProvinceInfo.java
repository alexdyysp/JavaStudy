package com.Study.Stream.List2Map;

import lombok.Data;

import java.util.List;

/**
 * @Author daiyuanyang
 * @Date 2020/9/3 9:30 下午
 */
@Data
public class CityProvinceInfo {
    Integer provinceId;
    String provinceName;
    List<CityInfo> cityInfoList;
}
