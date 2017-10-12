package com.gx.car.dao;

import java.util.List;

import com.gx.car.base.BaseMapper;
import com.gx.car.model.Dynmsn;

public interface DynmsnMapper extends BaseMapper<Dynmsn>{

	List<Dynmsn> findDymsnsPageQueryByTime();
  
}