<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%
 String ctx=request.getContextPath();
pageContext.setAttribute("ctx", ctx);

%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>修配连汽配市场</title>
<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function goToDynamicmessageList() {

	window.location.href = "${ctx}/index/dynmsn.shtml";
}

function goToPublicmessageList() {

	window.location.href = "${ctx}/index/notice.shtml";
}

function goToNewsList() {

	window.location.href = "${ctx}/index/news.shtml";
}
</script>
</head>

<body>
	<div class="bg_color1 border_end">
		<!--main颜色-->
		<div class="demo11 pagebody3 wid">
			<!--中间内容-->
			<ul class="tab_menu pagebody3_all">
				<li onclick="goToDynamicmessageList()" style="cursor:pointer">动态消息</li>
				<li class="current" onclick="goToPublicmessageList()"
					style="cursor:pointer">公告</li>
				<li onclick="goToNewsList()" style="cursor:pointer">新闻</li>
			</ul>
			<div class="clear"></div>
			<div class="tab_box ">
				<!--滚动信息开始-->
				<div class="pagebody3_news" id="xiaoxi" style="height:500px;">

					<ul>
						<c:forEach var="notice" items="${page.list}"
							varStatus="status">
							<li><a href="javascript:;">${notice.title}</a><span><fmt:formatDate
										value="${notice.createTime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></span></li>
						</c:forEach>
					</ul>




                 <!-- pager-lib的标签用法，需要告诉分页组件：总条数、每页多少条、当前第几页
                          	它的底层会循环自动生成页数，当用户点击具体页数的时候，它会
                          	发起超链接将偏移量初入后台（url）
                 
                  -->
					<ul class="page">
						<pg:pager url="${ctx}/index/notice.shtml" items="${page.totalRows}"
							export="currentPageNumber=pageNumber" maxPageItems="10">

							<pg:pages>
								<c:choose>
									<c:when test="${currentPageNumber eq pageNumber }">
										<a href="#"
											style="background: #C30D23 none repeat scroll 0% 0%;color:#ffffff;">${pageNumber}</a>
									</c:when>
									<c:otherwise>
										<a href="${pageUrl}">${pageNumber}</a>
									</c:otherwise>
								</c:choose>
							</pg:pages>
						</pg:pager>
					</ul>
					<div class="clear"></div>
				</div>

			</div>
			<!--滚动信息结束-->
		</div>
		<!--中间内容-->
	</div>
	<!--main颜色-->
	<div class="footer wid">Copyright © 2014-2024 www.xiupeilian.com
		All Rights Reserved. 修配连 版权所有</div>
	<!--end底部-->
</body>
</html>
