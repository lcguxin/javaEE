package com.gx.car.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gx.car.base.Page;
import com.gx.car.base.Pager;
import com.gx.car.model.Brand;
import com.gx.car.model.Items;
import com.gx.car.model.Parts;
import com.gx.car.service.BrandService;
import com.gx.car.service.ItemsService;
import com.gx.car.service.PartsService;

@Controller
@RequestMapping("/public")
public class PublicAction {
	@Resource
	private BrandService brandService;
	@Resource
	private PartsService partsService;
	@Resource
	private ItemsService itemsService;
	
	@RequestMapping("/publicList.shtml")
	public String publicList(Page page,Items items,String brandName,HttpServletRequest request){
		//需要品牌的数据
		List<Brand> brandList = brandService.findAllBrand();
		request.setAttribute("brandList",brandList);
		//需要单项配件种类的数据
		List<Parts> partsList = partsService.findAllParts();
		request.setAttribute("partsList",partsList);
		//分页查询而去有可能搜索的条件
		if (page.getPager()==null) {
			Pager pager = new Pager();
			page.setPager(pager);
		}
		//每页8条数据展示
		page.getPager().setPageSize(8);
		page.setT(items);
		List<Items> itemsList = itemsService.findByPageQuery(page);
		//需要满足条件的总条数
		int totalRows= itemsService.findTotalRowsByPageQuery(page);
		
		page.setList(itemsList);
		page.setTotalRows(totalRows);
		request.setAttribute("brandName", brandName);
		request.setAttribute("page", page);
		return "publicItems/publicList";
	}
	@RequestMapping("/ItemDetails.shtml")
	public String ItemDetails(HttpServletRequest request, int id){
		Items items = itemsService.selectByPrimaryKey(id);
		request.setAttribute("items", items);
		// 通过item表中的配件种类去parts表中查名字
		Parts part = partsService.selectByPrimaryKey(items.getPartsId());
		request.setAttribute("part", part);
		return "publicItems/ItemDetails";
	}
}
