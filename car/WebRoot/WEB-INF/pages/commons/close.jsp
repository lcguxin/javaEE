<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
  <head>
    <title>关闭</title>
     <script src="${ctx}/js/jquery.min.js" type="text/javascript"></script>   
 <script src="${ctx}/static/parts/js/layer/layer.min.js" type="text/javascript"></script>
  </head>
  <body>
</body>
<script>
closeLayer();
function closeLayer(){
	//刷新
	var forwardUrl = '${ctx}'+'${forwardUrl}';
	var oWinRight = window.top.document.getElementById('body');
	if('${forwardUrl}'==null || '${forwardUrl}'==''){
		oWinRight.src = oWinRight.getAttribute('src');
	}else{
		forwardUrl = encodeURI(forwardUrl);
		forwardUrl = encodeURI(forwardUrl);
		oWinRight.src = forwardUrl;
	}
var index = parent.layer.getFrameIndex(window.name);
 parent.layer.close(index);
}
</script>
</html>