package com.gx.car.service;

import java.util.List;

import com.gx.car.base.BaseService;
import com.gx.car.model.Brand;

public interface BrandService extends BaseService<Brand> {

	List<Brand> findAllBrand();

}
