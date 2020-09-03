package com.Study.Stream.List2Map;

import lombok.Builder;
import lombok.Data;

/**
 * @Author daiyuanyang
 * @Date 2020/9/3 10:05 下午
 */
@Data
@Builder
public class CityProvince {
    Integer provinceId;
    String provinceName;
    Integer cityId;
    String cityName;
}
