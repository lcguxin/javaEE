package com.gx.car.controller;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gx.car.model.User;
import com.gx.car.service.UserService;
import com.gx.car.vo.LoginVo;
import com.gx.car.util.MailEngine;

@Controller
@RequestMapping("/login")
public class LoginAction {
	@Resource
	private MailEngine mailEngine;
	@Resource
	private UserService userService;

	/**
	 * 登录（校验验证码、账号、密码）
	 * 
	 * @param response
	 * @param session
	 * @param vo
	 * @throws Exception
	 */
	@RequestMapping("/tologin.shtml")
	public String toLogin() {
		return "commons/login";
	}

	@RequestMapping("/login.shtml")
	public void login(HttpServletResponse response, HttpSession session,
			LoginVo vo) throws Exception {

		String code = (String) session
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (vo.getValidateCode().toUpperCase().equals(code.toUpperCase())) {
			User user = userService.findUserByLoginNameAndPassword(vo);
			if (user == null) {
				response.getWriter().write("2");
			} else {
				session.setAttribute("user", user);
				response.getWriter().write("3");
			}
		} else {
			response.getWriter().write("1");
		}
	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout.shtml")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:tologin.shtml";
	}

	/**
	 * 用户忘记密码，需要通过验证用户名和邮箱正确并且用户为在职状态 后通过发送邮件的方式获取密码
	 * 
	 * @return
	 */
	@RequestMapping("/toGetPassword.shtml")
	public String toGetPassword() {
		return "commons/getPassword";
	}

	@RequestMapping("/getPassword.shtml")
	public void getPassword(HttpServletResponse response, User user)
			throws Exception {
		// 1.先去数据库查询是否有该用户
		User checkUser = userService.findUserByLoginNameAndEmail(user);
		if (checkUser == null) {
			response.getWriter().write("1");
		} else {
			Random random = new Random();
			String password = "";
			// 随机生产成六位数字的密码
			for (int i = 0; i < 6; i++) {
				password += random.nextInt(10);
			}
			// System.out.println(password);
			// 重新设置密码
			checkUser.setPassword(password);
			// 修改数据库的密码
			userService.updateByPrimaryKeySelective(checkUser);

			// 发送邮件
			String[] address = { checkUser.getEmail() };
			String sender = "guxinzxc@sina.com";
			String title = "欢迎您来汽车修配连市场";
			String text = "您的新密码为：" + password + "，请妥善保管！";
			// ClassPathResource res =new ClassPathResource("/image/a.jpg");
			mailEngine.sendMessage(address, sender, text, title, null, null);
			response.getWriter().write("2");
		}
	}

	@RequestMapping("/unauthorized.shtml")
	public String unauthorized() {
		return "commons/unauthorized";
	}
}
