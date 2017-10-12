package com.gx.car.dao;

import java.util.List;

import com.gx.car.base.BaseMapper;
import com.gx.car.model.Brand;

public interface BrandMapper extends BaseMapper<Brand>{

	List<Brand> findAllBrand();
   
}