package com.gx.car.service;

import java.util.List;

import com.gx.car.base.BaseService;
import com.gx.car.model.Prime;

public interface PrimeService extends BaseService<Prime> {

	List<Prime> findAllPrime();

}
