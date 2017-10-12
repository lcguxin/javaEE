package com.gx.car.service;

import java.util.List;

import com.gx.car.base.BaseService;
import com.gx.car.model.City;

public interface CityService extends BaseService<City> {

	List<City> findAllProvinces();

	List<City> findCityByParentId(int id);

}
