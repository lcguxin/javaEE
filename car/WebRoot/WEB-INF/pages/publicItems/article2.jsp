<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
a:hover { color: red; }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修配连汽配市场</title>
<link href="${ctx}/static/parts/css/index.css" rel="stylesheet" type="text/css" />
<script language="javascript">
 function change(id){
     var url = "${ctx}/salecommodityAction.do?method=toCollect&id="+id;
        $.ajax({
            url:url,    //请求的url地址
            async:true,//请求是否异步，默认为异步，这也是ajax重要特性
            type:"post",   //请求方式
            success:function(data){
            	document.getElementById("count").innerHTML=data;
                document.getElementById("cl").style.background="#c0beb1";
                document.getElementById("cl").value="您已收藏成功！";
            }
        }); 
        
 }
</script>

</head>

<body class="bg_color3 wid" onload="initial();">
	<div class="pagebody8">
        <strong>标题:${salecommodity.title}</strong>
        <c:if test="${salecommodity.status==1}">
                                                <span style="color:red">【该商品已经下架】</span>
         </c:if>
        <span>发布者：<a href="${ctx}/salecommodityAction.do?method=getSellerList&userId=${user.id}">${user.loginName}</a></span>
        <span class="fr">已有<i id="count"><c:if test="${empty  salecommodity.collectcount}"> 0</c:if> <c:if test="${not empty  salecommodity.collectcount}"> ${salecommodity.collectcount}</c:if></i>人收藏
        <c:if test="${empty  collection}">
        <c:if test="${ flag!=1}">
        <input name="" style="cursor: pointer;" class="collect" id="cl" onclick="change('${salecommodity.id}')" type="button" value="我要收藏"/>
        </c:if>
        
        </c:if>
        
           <c:if test="${not empty  collection}">
        <input type="button" class="collect" id="cl" name="" value="您已收藏成功！"  style="background: rgb(192, 190, 177);">
        </c:if>
        <c:if test="${division eq 'seller'}">
        <input type="button" value="返回" style="background: #C30D23 none repeat scroll 0% 0%;cursor: pointer;font-size: 16px;color: #FFF;width:60px;height:30px"   onclick="javascript:window.location.href='${ctx}/salecommodityAction.do?method=getSellerList&userId=${user.id}'"/>
        </c:if>
        
        </span>
        <p id="id">所属品牌:${carmodel.name}</p>
        <p>配件类别:${accessoriescategory.name}</p>
    <div  id="biankuang" ><img src="${ctx}${salecommodity.picurl}"  id="myImage"  name="myImage" style="width:360px;height:280px"/></div>
    <p><input type="button" value="放大图片" onclick="zoomIn()" style="cursor: pointer;background: #C30D23 none repeat scroll 0% 0%;color: #FFF;"> 
<input type="button" value="缩小图片" onclick="zoomOut()" style="cursor: pointer;background: #C30D23 none repeat scroll 0% 0%;color: #FFF;"> 
<input type="button" value="重置图片" onclick="resetImage()" style="cursor: pointer;background: #C30D23 none repeat scroll 0% 0%;color: #FFF;">
</p>
    <p>描述:${salecommodity.content}</p>
    </div>
</body>
<script>
var currentWidth = 0;
var currentHeight = 0;
var originalWidth = 0;
var originalHeight = 0;
function initial(){
    currentWidth = document.getElementById ("myImage").width;
    currentHeight = document.getElementById ("myImage").height;
    originalWidth = currentWidth;
    originalHeight = currentHeight;
    update();
}
function zoomIn(){
	if(currentHeight<480){
    document.getElementById ("myImage").style.width = currentWidth*1.2+"px";
    document.getElementById ("myImage").style.height= currentHeight*1.2+"px";
    update();
	}else{
		alert("您已无法再放大!");
	}
}
function zoomOut(){
	if(currentHeight>100){
	document.getElementById ("myImage").style.width = currentWidth/1.2+"px";
    document.getElementById ("myImage").style.height = currentHeight/1.2+"px";
    update();
	}else{
		alert("您已无法再缩小!")
	}
}
function resetImage(){
	document.getElementById ("myImage").style.width = originalWidth+"px";
    document.getElementById ("myImage").style.height = originalHeight+"px";
    update();
}
function update(){
    currentWidth = document.getElementById ("myImage").width;
    currentHeight = document.getElementById ("myImage").height;
} 
</script>
</html>