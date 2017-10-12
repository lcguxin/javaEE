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

<body style="background-image: url(${ctx}/images/bg2.jpg)">

	<div style="text-align: center">
		<h2>商品详情</h2>
			<form action="${ctx}/myItems/collection.shtml"
			enctype="multipart/form-data" method="post">
				<table style="margin:0px auto">
					<input type="hidden" name="id" value="${items.id}" />
					
					<tr>
						<td>标题：</td>
						<td><input type="text" name="title" 
							value="${items.title}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>配件类别：</td>
						<td><input type="text" name="partsName" 
						value="${part.partsName }" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>图片：</td>
						<td><img src="${items.url}" style="width:180px"/>
						</td>
					</tr>
					<tr>
						<td>图片路径：</td>
						<td><input type="text" name="file"
						id="button" value="${items.url}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>货物描述：</td>
						<td><input name="content"  readonly="readonly" value="${items.content}"></td>
					</tr>
					<tr>
						<td>创建时间：</td>
						<td><input type="text" name="createTime"
						value="${items.createTime}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>修改时间：</td>
						<td><input type="text" name="editTime"
						value="${items.editTime}" readonly="readonly"/></td>
					</tr>
					<tr>
					<td colspan="2">
					<div style="width:60px;height:22px;border: black 2px solid;">
					<input type="submit" value="收藏"/>
					</div>
					</td>
					</tr>
				</table>

			</form>
	</div>
</body>
</html>