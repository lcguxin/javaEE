package com.gx.car.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.gx.car.base.Page;
import com.gx.car.base.Pager;
import com.gx.car.constant.SysConstant;
import com.gx.car.model.Brand;
import com.gx.car.model.Collections;
import com.gx.car.model.Items;
import com.gx.car.model.Parts;
import com.gx.car.model.User;
import com.gx.car.service.BrandService;
import com.gx.car.service.CollectionsService;
import com.gx.car.service.ItemsService;
import com.gx.car.service.PartsService;

@Controller
@RequestMapping("/myItems")
public class MyItemsAction {
	@Resource
	private ItemsService itemsService;
	@Resource
	private BrandService brandService;
	@Resource
	private PartsService partsService;
	@Resource
	private CollectionsService collectionsService;

	@RequestMapping("/myItemsList.shtml")
	public String myItems(HttpServletRequest request, Page page, Items items,
			String brandName, User user, HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		List<Items> itemsList = itemsService.findMyItems(sessionUser
				.getCompanyId());
		int count = itemsList.size();
		if (itemsList.size() < 8) {
			for (int i = 0; i < 8 - count; i++) {
				itemsList.add(new Items());
			}
		}
		List<Items> upList = itemsList.subList(0, 4);
		List<Items> downList = itemsList.subList(4, 8);
		request.setAttribute("uplist", upList);
		request.setAttribute("downlist", downList);
		// 查找本公司的商品的总条数
		int totalRows = itemsService.findMyItemsTotalRows(sessionUser
				.getCompanyId());
		request.setAttribute("totalRows", totalRows);

		return "myItems/myItems";
	}

	/**
	 * 添加商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/myItems.shtml")
	public String toAddItems(HttpServletRequest request) {
		List<Parts> partsList = partsService.findAllParts();
		request.setAttribute("partsList", partsList);
		//System.out.println("partsList="+partsList);
		return "myItems/addItems";

	}

	@RequestMapping("/addItems.shtml")
	public String addItems(MultipartFile file, Items items, Page page,
			HttpServletRequest request) throws Exception {

		String oldname = file.getOriginalFilename();
		String suffix = oldname.substring(oldname.lastIndexOf("."));
		long priffix = new Date().getTime();
		String newName = priffix + suffix;
		String realPath = SysConstant.REAL_PATH + newName;
		file.transferTo(new File(realPath));
		String path = SysConstant.UPLOAD_PATH + newName;
		// 设置图片路径
		items.setUrl(path);
		User user = (User) request.getSession().getAttribute("user");
		// 将用户的id设置到items表中用户id
		items.setUserId(user.getId());
		// 公司id
		items.setCompanyId(user.getCompanyId());
		// 状态
		items.setStatus(0);

		// 配件类别
		String partId = request.getParameter("partId");
		// 将获取到的String类型转换为int
		int partid = Integer.parseInt(partId);
		items.setPartsId(partid);
		// 新增商品的时间
		Date now = new Date();
		items.setEditTime(now);
		items.setCreateTime(now);
		itemsService.insertSelective(items);
		return "commons/close";
	}

	/**
	 * 删除商品
	 * @throws Exception 
	 */
	@RequestMapping("/doDelete.shtml")
	public String doDelete(int id) throws Exception {
		Items items = itemsService.selectByPrimaryKey(id);
		items.setStatus(1);
		itemsService.updateByPrimaryKey(items);
		return "doDelete";
	}

	/**
	 * 编辑商品
	 */
	@RequestMapping("/toEditMyItems.shtml")
	public String toEditItem(HttpServletRequest request, int id) {
		List<Parts> partsList = partsService.findAllParts();
		request.setAttribute("partsList", partsList);
		Items items = itemsService.selectByPrimaryKey(id);
		request.setAttribute("items", items);
		return "myItems/editMyItems";
	}

	@RequestMapping("/editMyItems.shtml")
	public String editMyItems(HttpServletRequest request, MultipartFile file,
			Items items, Page page) throws Exception {
		String oldname = file.getOriginalFilename();
		String suffix = oldname.substring(oldname.lastIndexOf("."));
		long priffix = new Date().getTime();
		String newName = priffix + suffix;
		String realPath = SysConstant.REAL_PATH + newName;
		file.transferTo(new File(realPath));
		String path = SysConstant.UPLOAD_PATH + newName;
		// 设置图片路径
		items.setUrl(path);
		User user = (User) request.getSession().getAttribute("user");
		String userId = request.getParameter("id");
		int userid = Integer.parseInt(userId);
		items.setUserId(userid);
		// 配件类别
		String partId = request.getParameter("partId");
		// 将获取到的String类型转换为int
		int partid = Integer.parseInt(partId);
		items.setPartsId(partid);
		// 新增商品的时间
		Date now = new Date();
		items.setEditTime(now);
		items.setCreateTime(now);
		itemsService.updateByPrimaryKeySelective(items);
		return "commons/close";
	}

	/**
	 * 查看某个商品详情
	 */
	@RequestMapping("myItemDetails.shtml")
	public String toMyItemDetail(HttpServletRequest request, int id) {
		Items items = itemsService.selectByPrimaryKey(id);
		request.setAttribute("items", items);
		// 通过item表中的配件种类去parts表中查名字
		Parts part = partsService.selectByPrimaryKey(items.getPartsId());
		request.setAttribute("part", part);
		return "myItems/myItemDetails";
	}

	/**
	 * 我的收藏
	 */
	@RequestMapping("/myCollection.shtml")
	public String myCollection(HttpServletRequest request, Page page,
			Items items, HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		List<Items> collectionsList = itemsService.findMyCollectionById(sessionUser.getId());
		request.getSession().setAttribute("collectionsList", collectionsList);

		int count = collectionsList.size();
		if (collectionsList.size() < 8) {
			for (int i = 0; i < 8 - count; i++) {
				collectionsList.add(new Items());
			}
		}
		List<Items> upList = collectionsList.subList(0, 4);
		List<Items> downList = collectionsList.subList(4,
				collectionsList.size());
		request.setAttribute("uplist", upList);
		request.setAttribute("downlist", downList);
		// 查找收藏的商品的总条数
		int totalRows = collectionsService
				.findMyCollectionsTotalRows(sessionUser.getId());
		request.setAttribute("totalRows", totalRows);

		return "myItems/myCollection";
	}
	/**
	 * 添加藏品
	 * @param session 
	 */
	@RequestMapping("/collection.shtml")
	public String collection(int id,Collections collections, HttpSession session){
		User sessionUser = (User) session.getAttribute("user");
		collections.setCollectorId(sessionUser.getId());
		collections.setItemsId(id);
		collectionsService.insert(collections);
		return "myItems/myCollection";
	}
	/**
	 * 删除藏品
	 * 
	 * @param collectionsList
	 */
	@RequestMapping("/doDeleteCollection.shtml")
	public String doDeleteCollection(int id) {
		collectionsService.deleteByPrimaryKey(id);
		return "myItems/myCollection";
	}
	/**
	 * 跳转公共货架
	 * @throws Exception 
	 */
	@RequestMapping("/publicList.shtml")
	public void publicList(HttpServletResponse response) throws Exception{
		response.getWriter().write("1");
	}
	@RequestMapping("/publicList2.shtml")
	public String publicList2(){
		return "publicItems/publicList";
	}

}
