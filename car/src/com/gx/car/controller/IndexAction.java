package com.gx.car.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gx.car.base.Page;
import com.gx.car.base.Pager;
import com.gx.car.model.Dynmsn;
import com.gx.car.model.News;
import com.gx.car.model.Notice;
import com.gx.car.service.DynmsnService;
import com.gx.car.service.NewsService;
import com.gx.car.service.NoticeService;
import com.gx.car.util.DateUtil;

@Controller
@RequestMapping("/index")
public class IndexAction {
	//resource 先根据对象 的名称去容器中查找，如果没找到，会根据类型去查找
	@Resource
	private NoticeService noticeService;
	@Resource
	private DynmsnService dynmsnService;
	@Resource
	private NewsService newsService;
	
	@RequestMapping("/index.shtml")
	public String index(){
		return "index/index";
	}
	
	@RequestMapping("/top.shtml")
	public String top(HttpServletRequest request){
		String now=DateUtil.dateToStr(new Date());
		request.setAttribute("now", now);
		return "index/top";
	}
	
	@RequestMapping("/navigation.shtml")
	public String navigation(){
		return "index/navigation";
	}
	/**
	 * 动态消息
	 * @param request
	 * @return
	 */
	@RequestMapping("/dynmsn.shtml")
	public String dynmsn(HttpServletRequest request){
	
		List<Dynmsn> list=dynmsnService.findDymsnsPageQueryByTime();
		request.setAttribute("list", list);
		return "index/dynmsn";
	}
	/**
	 *公告 
	 */
	@RequestMapping("/notice.shtml")
	public String notice(Page<Notice> page,HttpServletRequest request){
		
		if(page.getPager()==null){
			Pager pager=new Pager();
			page.setPager(pager);
		}
		List<Notice> list=noticeService.findByPageQuery(page);

		int totalRows=noticeService.findTotalRowsByPageQuery(page);
		page.setList(list);
		page.setTotalRows(totalRows);
		request.setAttribute("page", page);
		return "index/notice";
	}
	
	/**
	 *新闻 
	 */
	@RequestMapping("/news.shtml")
	public String news(Page<News> page,HttpServletRequest request){
		if(page.getPager()==null){
			Pager pager=new Pager();
			page.setPager(pager);
		}
		List<News> list=newsService.findByPageQuery(page);
		int totalRows=newsService.findTotalRowsByPageQuery(page);
		page.setList(list);
		page.setTotalRows(totalRows);
		request.setAttribute("page", page);
		return "index/news";
	}

}
