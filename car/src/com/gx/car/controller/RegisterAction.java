package com.gx.car.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gx.car.model.Brand;
import com.gx.car.model.City;
import com.gx.car.model.Company;
import com.gx.car.model.Parts;
import com.gx.car.model.Prime;
import com.gx.car.model.User;
import com.gx.car.service.BrandService;
import com.gx.car.service.CityService;
import com.gx.car.service.CompanyService;
import com.gx.car.service.PartsService;
import com.gx.car.service.PrimeService;
import com.gx.car.service.UserService;
import com.gx.car.util.JsonUtils;
import com.gx.car.vo.RegisterVo;

@Controller
@RequestMapping("/register")
public class RegisterAction {
	@Resource
	private UserService userService;
	@Resource
	private CompanyService companyService;
	@Resource
	private CityService cityService;
	@Resource
	private BrandService brandService;
	@Resource
	private PartsService partsService;
	@Resource
	private PrimeService primeService;
	
   @RequestMapping("/toRegister.shtml")
   public String toRegister(HttpServletRequest request){
	   List<Brand> brandList=brandService.findAllBrand();
	   List<Parts> partsList=partsService.findAllParts();
	   List<Prime> primeList=primeService.findAllPrime();
	   request.setAttribute("brandList", brandList);
	   request.setAttribute("partsList", partsList);
	   request.setAttribute("primeList", primeList);
	   return "commons/register";
   }
    @RequestMapping("/checkLoginName.shtml")
    public void checkLoginName(String loginName,HttpServletResponse response) throws Exception{
    	User user=userService.findUserByLoginName(loginName);
    	if(user==null){
    		response.getWriter().write("1");
    	}else{
    		response.getWriter().write("0");
    	}
    }
    
   @RequestMapping("/checkPhone.shtml")
   public void checkPhone(String telnum,HttpServletResponse response) throws Exception{
   	User user=userService.findUserByPhone(telnum);
   	if(user==null){
   		response.getWriter().write("1");
   	}else{
   		response.getWriter().write("0");
   	}
   }
   
   
  @RequestMapping("/checkEmail.shtml")
  public void checkEmail(String email,HttpServletResponse response) throws Exception{
  	User user=userService.findUserByEmail(email);
  	if(user==null){
  		response.getWriter().write("1");
  	}else{
  		response.getWriter().write("0");
  	}
  }
  
  
  @RequestMapping("/checkCompanyname.shtml")
  public void checkCompanyname(String companyname,HttpServletResponse response) throws Exception{
  	Company company=companyService.findCompanyByName(companyname);
  	if(company==null){
  		response.getWriter().write("1");
  	}else{
  		response.getWriter().write("0");
  	}
  	
  }
  
  @RequestMapping("/getProvince.shtml")
  public void getProvince(HttpServletResponse response) throws Exception{
	  response.setCharacterEncoding("utf-8");
	  List<City> list=cityService.findAllProvinces();
	  String json=JsonUtils.List2Json(list);
	  response.getWriter().write(json);
	  
  }
  
  
  @RequestMapping("/getCity.shtml")
  public void getCity(int id,HttpServletResponse response) throws Exception{
	  response.setCharacterEncoding("utf-8");
	  List<City> list=cityService.findCityByParentId(id);
	  String json=JsonUtils.List2Json(list);
	  response.getWriter().write(json);
	  
  }
  @RequestMapping("/register.shtml")
  public void register(RegisterVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
	  userService.addRegister(vo);
	  response.sendRedirect(request.getContextPath()+"/login/tologin.shtml");
  }
  
}
