package com.gx.car.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gx.car.base.Page;
import com.gx.car.base.Pager;
import com.gx.car.model.User;
import com.gx.car.service.UserService;

@Controller
@RequestMapping("/staffManage")
public class StaffManageAction {
	@Resource
	private UserService userService;
	@RequestMapping("/staffList.shtml")
     public String staffList(Page page,User user,HttpSession session,HttpServletRequest request){
		 if(page.getPager()==null){
			 Pager pager=new Pager();
			 page.setPager(pager);
		 }
		 User sessionUser=(User)session.getAttribute("user");
		 user.setCompanyId(sessionUser.getCompanyId());
		 page.setT(user);
		 
		
		 List<User> userList=userService.findByPageQuery(page);
		 int totalRows=userService.findTotalRowsByPageQuery(page);
		 page.setList(userList);
		 page.setTotalRows(totalRows);
		 request.setAttribute("page", page);
    	 return "staffManage/staffList";
     }
}
