package com.gx.car.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gx.car.base.Page;
import com.gx.car.constant.SysConstant;
import com.gx.car.dao.CompanyMapper;
import com.gx.car.dao.UserMapper;
import com.gx.car.model.Company;
import com.gx.car.model.User;
import com.gx.car.service.UserService;
import com.gx.car.util.DateUtil;
import com.gx.car.vo.LoginVo;
import com.gx.car.vo.RegisterVo;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Resource
	private CompanyMapper companyMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 通过查找修改用户信息
	 */
	@Override
	public int updateByPrimaryKeySelective(User t) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUserByLoginNameAndPassword(LoginVo vo) {
		// TODO Auto-generated method stub
		return userMapper.findUserByLoginNameAndPassword(vo);
	}

	@Override
	public List<User> findByPageQuery(Page<User> page) {
		// TODO Auto-generated method stub
		return userMapper.findByPageQuery(page);
	}

	@Override
	public int findTotalRowsByPageQuery(Page<User> page) {
		// TODO Auto-generated method stub
		return userMapper.findTotalRowsByPageQuery(page);
	}

	@Override
	public User findUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.findUserByLoginName(loginName) ;
	}

	@Override
	public User findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return userMapper.findUserByPhone(phone);
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userMapper.findUserByEmail( email);
	}

	
	public void addRegister(RegisterVo vo) {
		Company company=new Company();
		company.setAddress(vo.getAddress());
		company.setBoss(vo.getUsername());
		company.setCompanyCode(UUID.randomUUID().toString());
		company.setCompanyName(vo.getCompanyname());
		company.setCreateTime(DateUtil.now());
		company.setManageStyle(Integer.parseInt(vo.getManageStyle()));
		company.setManageDetail(vo.getManageDetail());
		company.setPhone(vo.getTelnum());
		company.setQq(vo.getQq());
		company.setStatus(SysConstant.COMPANY_STATUS_NORMAL);
		company.setTel1(vo.getTel1());
		company.setTel2(vo.getTel2());
		company.setZone1(vo.getZone1());
		company.setZone2(vo.getZone2());
		companyMapper.insertSelective(company);

		User user=new User();
		user.setCompanyId(company.getId());
		user.setCreateTime(DateUtil.now());
		user.setEmail(vo.getEmail());
		user.setLevel(SysConstant.USER_LEVEL_BOSS);
		user.setLoginName(vo.getLoginName());
		user.setPassword(vo.getPassword());
		user.setPhone(vo.getTelnum());
		user.setQq(vo.getQq());
		user.setRoleId(SysConstant.USER_ROLE_BOSS);
		user.setStatus(SysConstant.USER_STATUS_NORMAL);
		user.setUsername(vo.getUsername());
		userMapper.insertSelective(user);
		
	}
	/**
	 * 找回密码的 功能
	 */
	@Override
	public User findUserByLoginNameAndEmail(User user) {
		// TODO Auto-generated method stub
		return userMapper.findUserByLoginNameAndEmail(user);
	}

}
