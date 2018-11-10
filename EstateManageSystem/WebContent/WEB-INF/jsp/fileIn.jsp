<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>房产管理系统·后台</title>
	<link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.min.css"/>
	<link rel="stylesheet" type="text/css" href="./css/service.css"/>
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</head>
<body class="mdui-theme-primary-indigo mdui-theme-accent-pink">
	<div class="mdui-container doc-container">
		
		<div class="doc-top">
  			<h1 class="doc-title mdui-text-color-theme head-title">档案归档</h1>
  		</div>
		<div class="mdui-table-fluid mdui-hoverable mdui-typo doc-content" style="margin-top: 50px;">
		
			<table class="mdui-table mdui-table-hoverable" style="margin-bottom: 0px;">
				<thead>
				<tr>
					<th class="mdui-text-center">业务受理号</th>
					<th class="mdui-text-center">业务类型</th>
					<th class="mdui-text-center">产权人</th>
					<th class="mdui-text-center">档案存放位置</th>
					<th class="mdui-text-center">密级</th>
					<th class="mdui-text-center">房产地址</th>
					<th class="mdui-text-center">归档日期</th>
				</tr>
				</thead>
      			<tbody>
             <c:forEach items= "${files}" var="item">
             <c:if test="${empty item.file_location }">
            <tr class="">
            <form action="Admin/updatefileIn" method="post">
              <td style="mdui-text-center">${item.business_number}</td>
              <td style="mdui-text-center">${item.business_types}</td>
              <td style="mdui-text-center">${item.property_owner}</td>
              <td style="mdui-text-center"><input type="text" name="file_location"/></td>  
              <td style="mdui-text-center">
              <select name="security" class="mdui-select" mdui-select>
                 <option value="A">A</option>
                 <option value="B">B</option>
                 <option value="C">C</option>
              </select>  
              </td>
              <td style="mdui-text-center">${item.address}</td> 
              <td style="mdui-text-center">${item.filing_date}</td>   
              <input type="text" class="mdui-hidden" name="business_number" value="${item.business_number}"></input>
              	<input type="text" class="mdui-hidden" name="business_types" value="${item.business_types}"></input>
              	<input type="text" class="mdui-hidden" name="property_owner" value="${item.property_owner}"></input>
              	<input type="text" class="mdui-hidden" name="address" value="${item.address}"></input>
              <td style="mdui-text-center">
                <input type="submit" id="checkMark" value="归档" class="receive mdui-color-indigo-500 mdui-btn mdui-btn-raised"/></td>    
            </form>
            </tr>   
            </c:if>
            </c:forEach>       
            </tbody>
			</table>
			
		</div>
		
	</div>

  	<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="../mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
  	<script src="https://cdn.bootcss.com/holder/2.9.4/holder.min.js"></script>
  	
</body>	
</html>