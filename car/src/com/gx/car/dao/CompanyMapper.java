package com.gx.car.dao;

import com.gx.car.base.BaseMapper;
import com.gx.car.model.Company;

public interface CompanyMapper extends BaseMapper<Company>{

	Company findCompanyByName(String companyname);
 
}