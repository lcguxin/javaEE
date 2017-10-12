package com.gx.car.dao;

import java.util.List;

import com.gx.car.base.BaseMapper;
import com.gx.car.model.City;

public interface CityMapper extends BaseMapper<City>{

	List<City> findAllProvinces();

	List<City> findCityByParentId(int id);
  
}