package com.gx.car.base;

import java.util.List;

public interface BaseService<T> {
	int deleteByPrimaryKey(Integer id);

	int insert(T t);

	int insertSelective(T t);

	T selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(T t);

	int updateByPrimaryKey(T t);
	
	List<T> findByPageQuery(Page<T> page);
	int findTotalRowsByPageQuery(Page<T> page);

}
