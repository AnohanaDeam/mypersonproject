<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>修改文件信息</title>
<link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.css" />
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
</head>
<body>
<div class="mdui-container">
    <div class="mdui-row">
	    <div class="mdui-col-md-6 mdui-col-offset-md-3 mdui-hoverable mdui-shadow-24 mdui-m-t-5 mdui-p-b-2">
	    	<form action="Admin/updateFile" method="post">
					<div class="mdui-textfield">
						<label class="mdui-textfield-label">业务受理号</label>
					  <input class="mdui-textfield-input" placeholder="" type="text" name="business_number" value="${fileVo.business_number}"/>
					</div>
			
					<div class="mdui-textfield">
					<label class="mdui-textfield-label">业务类型</label>
					  <input class="mdui-textfield-input" placeholder="" type="text" name="business_types" value="${fileVo.business_types}"/>
					</div>

					<div class="mdui-textfield">
					<label class="mdui-textfield-label">产权人</label>
					  <input class="mdui-textfield-input" placeholder="" type="text" name="property_owner"  value="${fileVo.property_owner}"/>
					</div>

					<div class="mdui-textfield">
					<label class="mdui-textfield-label">档案存放位置</label>
					  <input class="mdui-textfield-input" placeholder="" type="text" name="file_location" value="${fileVo.file_location}"/>
					</div>

					<div class="mdui-textfield">
					<label class="mdui-textfield-label">密级</label>
					  <input class="mdui-textfield-input" placeholder="" type="text" name="security" value="${fileVo.security}"/>
					</div>

					<div class="mdui-textfield">
					<label class="mdui-textfield-label">房产地址</label>
					  <input class="mdui-textfield-input" placeholder="" type="text" name="address" value="${fileVo.address}"/>
					</div>

					<div class="mdui-textfield">
					<label class="mdui-textfield-label">归档日期</label>
					  <input class="mdui-textfield-input" placeholder="" type="text" name="filing_date" value="${fileVo.filing_date}"
					    readonly="readonly"/>
					</div>
					<input class="mdui-btn mdui-btn-block mdui-color-theme-accent mdui-ripple" type="submit" value="修改"> 
	    </form>
	   </div>
	 </div>
</div>
</body>
</html>