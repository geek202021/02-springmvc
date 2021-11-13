package com.jun.service.impl;

import com.jun.bean.City;
import com.jun.bean.Province;
import com.jun.dao.CityMapper;
import com.jun.dao.ProvinceMapper;
import com.jun.service.ProvinceCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HuangJun7
 * @date 2021-11-13 17:48
 */
@Service
public class ProvinceCityServiceImpl implements ProvinceCityService {
    @Resource
    private ProvinceMapper pdao;
    @Resource
    private CityMapper cdao;

    @Override
    public List<Province> queryAllProvince() {
        return pdao.selectProvinceList();
    }

    @Override
    public int addCity(City city) {
        int rows = cdao.insertCity(city);
        return rows;
    }

    @Override
    public List<City> queryCityByProvinceId(Integer provinceId) {
        return cdao.selectCityByProvinceId(provinceId);
    }

}
