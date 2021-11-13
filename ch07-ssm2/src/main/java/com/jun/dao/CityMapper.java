package com.jun.dao;

import com.jun.bean.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HuangJun7
 * @date 2021-11-13 17:08
 */
public interface CityMapper {
    int insertCity(City city);

    List<City> selectCityByProvinceId(@Param("pid")Integer provinceId);
}
