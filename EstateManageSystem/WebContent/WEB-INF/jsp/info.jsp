<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>房产管理系统·后台</title>
<link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.min.css" />
<link rel="stylesheet" href="./css/service.css" />
<link rel="stylesheet" href="./css/table.css" />
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="../mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
</head>
<body>
	<script type="text/javascript">
		alert('${msg}');
		top.location.href = "loginPage";
	</script>

</body>
</html>