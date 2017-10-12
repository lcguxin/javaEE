package com.gx.car.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gx.car.base.Page;
import com.gx.car.model.Role;
import com.gx.car.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Role t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Role t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Role selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Role t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Role t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> findByPageQuery(Page<Role> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Role> page) {
		// TODO Auto-generated method stub
		return 0;
	}

}
