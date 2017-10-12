package com.gx.car.service;

import com.gx.car.base.BaseService;
import com.gx.car.model.User;
import com.gx.car.vo.LoginVo;
import com.gx.car.vo.RegisterVo;

public interface UserService extends BaseService<User> {

	User findUserByLoginNameAndPassword(LoginVo vo);

	void addRegister(RegisterVo vo);

	User findUserByEmail(String email);

	User findUserByLoginName(String loginName);

	User findUserByPhone(String telnum);

	User findUserByLoginNameAndEmail(User user);

}
