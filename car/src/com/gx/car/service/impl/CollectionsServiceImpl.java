package com.gx.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gx.car.base.Page;
import com.gx.car.dao.CollectionsMapper;
import com.gx.car.dao.ItemsMapper;
import com.gx.car.model.Collections;
import com.gx.car.service.CollectionsService;
@Service
public class CollectionsServiceImpl implements CollectionsService {
	@Resource
	private CollectionsMapper collectionsMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return collectionsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Collections t) {
		// TODO Auto-generated method stub
		return collectionsMapper.insert(t);
	}

	@Override
	public int insertSelective(Collections t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collections selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Collections t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Collections t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Collections> findByPageQuery(Page<Collections> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Collections> page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Collections> findMyCollectionById(Integer id) {
		// TODO Auto-generated method stub
		return collectionsMapper.findMyCollectionById(id);
	}

	@Override
	public int findMyCollectionsTotalRows(Integer id) {
		// TODO Auto-generated method stub
		return collectionsMapper.findMyCollectionsTotalRows(id);
	}

	@Override
	public Collections selectIdAndItemId(Collections collections) {
		// TODO Auto-generated method stub
		return collectionsMapper.selectIdAndItemId(collections);
	}

}
