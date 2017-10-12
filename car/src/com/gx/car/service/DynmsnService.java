package com.gx.car.service;

import java.util.List;

import com.gx.car.base.BaseService;
import com.gx.car.base.Page;
import com.gx.car.model.Dynmsn;

public interface DynmsnService extends BaseService<Dynmsn>{

	List<Dynmsn> findDymsnsPageQueryByTime();



}
