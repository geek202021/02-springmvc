package com.jun.service;

import com.jun.bean.City;
import com.jun.bean.Province;

import java.util.List;

/**
 * @author HuangJun7
 * @date 2021-11-13 17:46
 */
public interface ProvinceCityService {
    List<Province> queryAllProvince();

    int addCity(City city);

    List<City> queryCityByProvinceId(Integer provinceId);
}
