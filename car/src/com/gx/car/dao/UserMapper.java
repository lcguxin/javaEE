package com.gx.car.dao;

import com.gx.car.base.BaseMapper;
import com.gx.car.model.User;
import com.gx.car.vo.LoginVo;

public interface UserMapper extends BaseMapper<User> {

	User findUserByLoginNameAndPassword(LoginVo vo);

	User findUserByLoginName(String loginName);

	User findUserByPhone(String phone);

	User findUserByEmail(String email);

	User findUserByLoginNameAndEmail(User user);

	int findUserByLoginNameAndPassword(User t);
  
}