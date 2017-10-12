<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%-- <meta http-equiv="MSThemeCompatible" content="no" /> --%>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Cache-Control" content="no-cache" />
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    String sLang=request.getLocale().getLanguage();
    String fileName;
    java.util.List supported=new java.util.ArrayList();
    supported.add("zh");
    supported.add("en");
    if(supported.contains(sLang)){
   		fileName="extremecomponents_msg_"+sLang+".js";
    }else{
   		fileName="extremecomponents_msg_zh.js";
    }
    
    
    String themeName="";
    Object themeNameObj=request.getSession().getAttribute("themeName");
    if(themeNameObj!=null){
    	themeName=(String)themeNameObj;		
    }else{
    	themeName="maitian-simple";	
    }
         
    String themePath = path + "/theme/"+themeName;

%>
<c:set var="themeName" value="<%=themeName%>" />
<c:set var="themePath" value="<%=themePath%>" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="contextPath" value="<%=basePath%>" />
<script type="text/javascript"  src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/jBox/i18n/jquery.jBox-zh-CN.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/jsjBox/Skins-maitian/maitian-simple/jbox.css"/>
