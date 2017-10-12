package com.gx.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gx.car.base.Page;
import com.gx.car.dao.BrandMapper;
import com.gx.car.model.Brand;
import com.gx.car.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	@Resource
	private BrandMapper brandMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Brand t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Brand t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Brand selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Brand t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Brand t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Brand> findByPageQuery(Page<Brand> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Brand> page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Brand> findAllBrand() {
		// TODO Auto-generated method stub
		return brandMapper.findAllBrand();
	}

}
