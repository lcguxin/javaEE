package com.gx.car.dao;

import java.util.List;

import com.gx.car.base.BaseMapper;
import com.gx.car.model.Parts;

public interface PartsMapper extends BaseMapper<Parts>{

	List<Parts> findAllParts();
  
}