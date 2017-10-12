package com.gx.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gx.car.base.Page;
import com.gx.car.dao.PartsMapper;
import com.gx.car.model.Parts;
import com.gx.car.service.PartsService;
@Service
public class PartsServiceImpl implements PartsService {
	@Resource
	private PartsMapper partsMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Parts t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Parts t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Parts selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return partsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Parts t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Parts t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Parts> findByPageQuery(Page<Parts> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Parts> page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Parts> findAllParts() {
		// TODO Auto-generated method stub
		return partsMapper.findAllParts();
	}

}
