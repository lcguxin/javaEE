package com.gx.car.dao;

import java.util.List;

import com.gx.car.base.BaseMapper;
import com.gx.car.model.Prime;

public interface PrimeMapper extends BaseMapper<Prime>{

	List<Prime> findAllPrime();

}