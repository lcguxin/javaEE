package com.gx.car.base;

import java.util.List;

import com.gx.car.base.Pager;

/**
 * 
 * 使用泛型来定义分页的对象，Page<Publicmessage>
 * Page<News>
 * 分页对象中包含了泛型对象
 * 分页工具对象，
 * 查询的结果集，
 * 总条数.
 */
public class Page<T> {
	//封装搜索条件
	private T t;
	//封装分页条件(偏移量、每页多少条)
    private Pager pager;
    //查询结果记录
	private List<T> list;
	//满足条件的总条数
	private int totalRows;
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}

}
