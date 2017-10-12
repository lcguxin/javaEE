package com.gx.car.service;

import com.gx.car.base.BaseService;
import com.gx.car.model.City;
import com.gx.car.model.Company;

public interface CompanyService extends BaseService<Company> {

	Company findCompanyByName(String companyname);

}
