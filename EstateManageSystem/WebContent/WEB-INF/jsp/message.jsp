<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/mdui/0.4.0/css/mdui.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/mdui/0.4.0/js/mdui.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</head>
<c:if test="${msg=='有不支持的格式图片,请重新添加(png,jpg)' }">
	<script type="text/javascript">
		alert('有不支持的格式图片,请重新添加(png,jpg),三秒后返回重新选择');
		setTimeout(function(){
			javascript:top.history.back();
		}, 3000);
	</script>
</c:if>
<body>
	<div class="mdui-container">
	  <div class="mdui-row mdui-m-t-5">
	    <div class="mdui-col-xs-12 mdui-text-center">
	    	<c:if test="${msg=='添加业务成功' }">
		  		<img style="width: 100px" src="img/gou.png">
		  	</c:if>
	    </div>
	  </div>
	  <div class="mdui-row">
	    <div class="mdui-col-xs-12 mdui-text-center"><div class="mdui-center mdui-typo-display-3">${msg }</div></div>
	  </div>
	  <div class="mdui-row">
	    <div class="mdui-col-xs-12 mdui-text-center">
	    	<button class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-indigo" onclick="javascript:top.history.back();">返回上一页</button>
	    	<button class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-indigo" onclick="javascript:top.location.href = 'loginPage';">返回首页</button>
	    </div>
	  </div>
	</div>
</body>
</html>