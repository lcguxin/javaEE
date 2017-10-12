package com.gx.car.service;

import java.util.List;

import com.gx.car.base.BaseService;
import com.gx.car.model.Collections;
import com.gx.car.model.Items;

public interface ItemsService extends BaseService<Items> {

	List<Items> findMyItems(Integer companyId);

	int findMyItemsTotalRows(Integer companyId);

	List<Items> findMyCollectionById(Integer id);

}
