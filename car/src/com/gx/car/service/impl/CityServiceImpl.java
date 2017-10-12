package com.gx.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gx.car.base.Page;
import com.gx.car.dao.CityMapper;
import com.gx.car.model.City;
import com.gx.car.service.CityService;
@Service
public class CityServiceImpl implements CityService {
	@Resource
	private CityMapper cityMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(City t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(City t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public City selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(City t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(City t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<City> findByPageQuery(Page<City> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<City> page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<City> findAllProvinces() {
		// TODO Auto-generated method stub
		return cityMapper.findAllProvinces();
	}

	@Override
	public List<City> findCityByParentId(int id) {
		// TODO Auto-generated method stub
		return cityMapper.findCityByParentId(id);
	}

}
