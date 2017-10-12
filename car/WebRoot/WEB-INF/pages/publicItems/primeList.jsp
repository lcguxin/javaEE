<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/pages/commons/taglibs.jsp" %>
<%@ include file="/pages/commons/head.jsp" %>
<%@ taglib prefix="pg"  uri="http://jsptags.com/tags/navigation/pager" %>
<html>
<head>
    <title>新增货架</title>
    <meta name="decorator" content="default"/>
    <link href="${ctx}/static/parts/css/index.css" rel="stylesheet" type="text/css" />
   
    
    <script type="text/javascript">
    $('.hnavmore li a').click(function(e){
        var val = $(this).text();
        var data_val = $(this).attr('data-value');
        $(this).parents('.hnavmore').find('input').val(data_val);
        $(this).parents('.hnavmore').find('.cur-span').text(val);
    });
    
	function productgroupedit(id) {
			$.jBox("iframe:${ctx}/salecommodityAction.do?method=toArticle&id="+id+"&division=public", {
			title : "商品详情",
			attach: $('#idett'),
			width : 1020,
			height : 700,
			buttons : { /*'关闭': true*/}
		});
	}
</script>



</head>
<body>
	
    <div class="bg_color1" id="idett" ><!--公共货架-->
    <div class="pagebody1" style="height:700px">
    

      
      
    	<div class="wid">
   <ul class="ht1">
                    <li class="big4" style="display:inline;"><a href="${ctx}/salecommodityAction.do?method=publicList">配件市场</a></li>
                    <li class="big3" style="display:inline;"><a href="${ctx}/salecommodityAction.do?method=primeList">精品市场</a></li>
                </ul>
                <div>
                </div>
                <div class="pagebody1_right">
                	<form id="searchPublicForm" name="searchPublicForm"
                          action="${ctx}/salecommodityAction.do?method=primeList"
                          method="post">
                        <input name="title" type="text"  class="input4" placeholder="标题"  value="${vo.title}"/>
                        <input name="content" type="text" class="input4" placeholder="描述"  value="${vo.content}"/> 
                        <select class="input1" id="primeId" name="primeId"  >
                        <option value="">请选择</option>
                        <c:forEach var="cp" items="${primeList}">
                         <c:if test="${cp.id!=vo.partId}">
                         <option value="${cp.id}">${cp.name}</option>
                          </c:if>
							    <c:if test="${cp.id==vo.partId}">
                         <option value="${cp.id}"  selected>${cp.name}</option>
                          </c:if>
                                
                        </c:forEach>
                </select>
                        <input name="" onclick="searchList();" type="submit" value="搜&nbsp;&nbsp;索" class="pagebody1_btn" />
                    </form>
                                        
                </div>

                <div class="clear"></div>
        </div>
        <div class="pagebody2 mr1 wid">
        	<div class="wid2">
            <c:forEach var="sale" items="${salecommodityList_up}" >
                <ul class='<c:if test="${sale.enterpriseflag==4}">qps</c:if><c:if test="${sale.enterpriseflag==2}">qxc</c:if>'>
                   <a href="#" onclick="productgroupedit('${sale.id}');" class="fban">
                       <div class="goods">
                            <img src="${ctx}${sale.picurl}" />
                            <div class="goods1">
                                <h3><span title="${sale.title}" style="cursor:pointer;">
                                            
                                            <c:set var="title" value="${sale.title}" />
                                            
                                            <c:choose>

													<c:when test="${fn:length(title) > 10}">

														<c:out value="${fn:substring(title, 0, 10)}......" />

													</c:when>

													<c:otherwise>

														<c:out value="${title}" />

													</c:otherwise>
												</c:choose></span></h3>
                                <p><span title="${sale.content}" style="cursor:pointer;">
                                            
                                            <c:set var="content" value="${sale.content}" />
                                            
                                            <c:choose>

													<c:when test="${fn:length(content) > 10}">

														<c:out value="${fn:substring(content, 0, 10)}......" />

													</c:when>

													<c:otherwise>

														<c:out value="${content}" />

													</c:otherwise>
												</c:choose></span></p>
                                <p><fmt:formatDate value="${sale.operatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                            </div>
                       </div>
                   </a>
               </ul>
            </c:forEach>
           <div class="clear"></div>
           </div>
           </div>
           <div class="pagebody2 wid">
               <div class="wid2">
                <c:forEach var="sale" items="${salecommodityList_down}" >
                    <ul class='<c:if test="${sale.enterpriseflag==4}">qps</c:if><c:if test="${sale.enterpriseflag==2}">qxc</c:if>'>
                        <a href="#" onclick="productgroupedit('${sale.id}');" class="fban">
                            <div class="goods">
                                <img src="${ctx}${sale.picurl}" />
                                <div class="goods1">
                                     <h3><span title="${sale.title}" style="cursor:pointer;">
                                            
                                            <c:set var="title" value="${sale.title}" />
                                            
                                            <c:choose>

													<c:when test="${fn:length(title) > 10}">

														<c:out value="${fn:substring(title, 0, 10)}......" />

													</c:when>

													<c:otherwise>

														<c:out value="${title}" />

													</c:otherwise>
												</c:choose></span></h3>
                                     <p><span title="${sale.content}" style="cursor:pointer;">
                                            
                                            <c:set var="content" value="${sale.content}" />
                                            
                                            <c:choose>

													<c:when test="${fn:length(content) > 10}">

														<c:out value="${fn:substring(content, 0, 10)}......" />

													</c:when>

													<c:otherwise>

														<c:out value="${content}" />

													</c:otherwise>
												</c:choose></span></p>
                                  <p><fmt:formatDate value="${sale.operatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                                </div>
                            </div>
                        </a>
                    </ul>
                </c:forEach>
                   <div class="clear"></div>
              </div>
        </div>
        <div class="clear"></div>

            <!--翻页按钮-->
            <ul class="page">
                <pg:pager url="${ctx}/salecommodityAction.do"
                          items="${totalRows}" export="currentPageNumber=pageNumber" maxPageItems="8">
                    <pg:param name="method" value="primeList" />
                    <pg:param name="title" value="${vo.title}" />
                    <pg:param name="content" value="${vo.content}" />
                    <pg:param name="primeId" value="${vo.partId}" />
                    <pg:pages>
                        <c:choose>
                            <c:when test="${currentPageNumber eq pageNumber }">
                                <a href="#"  style="background: #C30D23 none repeat scroll 0% 0%;color:#ffffff;">${pageNumber }</a>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageUrl }">${pageNumber }</a>
                            </c:otherwise>
                        </c:choose>
                    </pg:pages>
                </pg:pager>
            </ul>
            <div class="clear"></div>
        </div>
        <!--翻页按钮-->

        <div class="clear"></div>
    </div>
    <div class="bg_color2">
    	<div class="footer wid">Copyright © 2014-2024 www.xiupeilian.com  All Rights Reserved. 修配连 版权所有</div>
    </div>

</body>
</html>
