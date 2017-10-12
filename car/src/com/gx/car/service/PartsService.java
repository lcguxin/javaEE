package com.gx.car.service;

import java.util.List;

import com.gx.car.base.BaseService;
import com.gx.car.model.Parts;

public interface PartsService extends BaseService<Parts> {

	List<Parts> findAllParts();

}
