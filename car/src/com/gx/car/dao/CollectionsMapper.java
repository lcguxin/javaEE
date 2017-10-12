package com.gx.car.dao;

import java.util.List;

import com.gx.car.base.BaseMapper;
import com.gx.car.model.Collections;

public interface CollectionsMapper extends BaseMapper<Collections> {

	List<Collections> findMyCollectionById(Integer id);

	int findMyCollectionsTotalRows(Integer id);

	Collections selectIdAndItemId(Collections collections);
   
}