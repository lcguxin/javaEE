package com.gx.car.dao;

import java.util.List;

import com.gx.car.base.BaseMapper;
import com.gx.car.model.Collections;
import com.gx.car.model.Items;

public interface ItemsMapper extends BaseMapper<Items>{

	List<Items> findMyItems(Integer companyId);

	int findMyItemsTotalRows(Integer companyId);

	List<Items> findMyCollectionById(Integer id);
  
}