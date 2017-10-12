<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/jquery-1.7.1.min.js"></script>
<script src="${ctx}/js/layer/layer.min1.js" type="text/javascript"></script>

</head>

<body style="background:#efeeec;">
	<div class="pagebody6">
		<h2 class="padding1">编辑商品</h2>
			<form action="${ctx}/myItems/editMyItems.shtml"
				enctype="multipart/form-data" method="post">
				<table>
					<input type="hidden" name="id" value="${items.id}" />
					<tr>
						<td>标题</td>
						<td><input type="text" class="xinzeng" name="title"
							value="${items.title}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>配件类别</td>
						<td><select id="partId" class="xinzeng" name="partId">
								<option value="">请选择</option>
								<c:forEach var="cp" items="${partsList}">
									<c:if test="${cp.id!=items.partsId}">
										<option value="${cp.id}">${cp.partsName}</option>
									</c:if>
									<c:if test="${cp.id==items.partsId}">
										<option value="${cp.id}" selected>${cp.partsName}</option>
									</c:if>
								</c:forEach>
						</td>
					</tr>
					<tr>
						<td>图片路径</td>
						<td><input class="sangchuan" type="file" name="file"
						id="button" value="选择上传" /></td>
					</tr>
					<tr>
						<td>货物描述</td>
						<td rowspan="2"><textarea name="content" class="miaoshu">${items.content}</textarea></td>
					</tr>
					<tr></tr>
					<tr></tr>
					<tr>
						<td colspan="2"><input type="submit" class="tianjia" value="保存" /></td>
					</tr>
					
				</table>

			</form>
	</div>
</body>
</html>