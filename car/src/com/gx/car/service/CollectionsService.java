package com.gx.car.service;

import java.util.List;

import com.gx.car.base.BaseService;
import com.gx.car.model.Collections;

public interface CollectionsService extends BaseService<Collections> {

	List<Collections> findMyCollectionById(Integer id);

	int findMyCollectionsTotalRows(Integer id);

	Collections selectIdAndItemId(Collections collections);

}
