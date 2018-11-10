<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
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
<title>房产管理系统-档案馆</title>
<link  rel="stylesheet" href="./css/a.css">
<link href="https://cdn.bootcss.com/mdui/0.4.0/css/mdui.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/mdui/0.4.0/js/mdui.min.js"></script>
<style type="text/css">.pageJumpBox{border-radius: 20px;}</style>
    <c:if test="${not empty msg }">
      <script type="text/javascript">alert("${msg }");</script></c:if>
</head>
<body>
	<div class="mdui-container mdui-valign" style="height:400px;">
    		<div class="mdui-center mdui-typo-display-3 mdui-ripple mdui-text-center mdui-hoverable mdui-p-y-2 mdui-p-l-5 mdui-p-r-5 mdui-color-indigo pageJumpBox">
    			<a target="pageJump" href="Admin/fileIn" class="a">归档</a>
    		</div>
    		<div class="mdui-center mdui-typo-display-3 mdui-ripple mdui-text-center mdui-hoverable mdui-p-y-2 mdui-p-l-5 mdui-p-r-5 mdui-color-indigo pageJumpBox">
    			<a target="pageJump" href="Admin/file-management" class="a">查询</a>
    		</div>
    	<!-- </div> -->
  </div>
</body>
</html>