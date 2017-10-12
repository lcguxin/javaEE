package com.gx.car.base;

import java.util.List;

import com.gx.car.base.Page;

public interface BaseMapper<T> {
	int deleteByPrimaryKey(Integer id);

	int insert(T t);

	int insertSelective(T t);

	T selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(T t);

	int updateByPrimaryKey(T t);
	

	List<T> findByPageQuery(Page<T> page);
	int findTotalRowsByPageQuery(Page<T> page);

}
