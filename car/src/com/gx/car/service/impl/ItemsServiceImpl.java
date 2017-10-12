package com.gx.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gx.car.base.Page;
import com.gx.car.dao.ItemsMapper;
import com.gx.car.dao.UserMapper;
import com.gx.car.model.Collections;
import com.gx.car.model.Items;
import com.gx.car.service.ItemsService;
@Service
public class ItemsServiceImpl implements ItemsService {
	@Resource
	private ItemsMapper itemsMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return itemsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Items t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Items t) {
		// TODO Auto-generated method stub
		return itemsMapper.insertSelective(t);
	}

	@Override
	public Items selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Items t) {
		// TODO Auto-generated method stub
		return itemsMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(Items t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Items> findByPageQuery(Page<Items> page) {
		// TODO Auto-generated method stub
		return itemsMapper.findByPageQuery(page);
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Items> page) {
		// TODO Auto-generated method stub
		return itemsMapper.findTotalRowsByPageQuery(page);
	}

	@Override
	public List<Items> findMyItems(Integer companyId) {
		// TODO Auto-generated method stub
		return itemsMapper.findMyItems(companyId);
	}

	@Override
	public int findMyItemsTotalRows(Integer companyId) {
		// TODO Auto-generated method stub
		return itemsMapper.findMyItemsTotalRows(companyId);
	}

	@Override
	public List<Items> findMyCollectionById(Integer id) {
		// TODO Auto-generated method stub
		return itemsMapper.findMyCollectionById(id);
	}

}
