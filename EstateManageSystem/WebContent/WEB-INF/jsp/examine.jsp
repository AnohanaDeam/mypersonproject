<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.min.css"/>
	<link rel="stylesheet" href="./css/service.css" />
	<link rel="stylesheet" href="./css/table.css" />
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="../mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
</head>
<body>
  	<!--初审开始-->
  	<div class="mdui-container doc-container">
  		<h1 class="doc-title mdui-text-color-theme mdui-text-color-indigo">待初审业务</h1>
  		<div class="mdui-table-fluid mdui-hoverable mdui-typo">
          <table class="mdui-table mdui-table-hoverable">
            <thead>
            <tr> 
              <th class="mdui-text-center">申请人姓名</th>
              <th class="mdui-text-center">身份证号码</th>
              <th class="mdui-text-center">联系电话</th>
              <th class="mdui-text-center">业务类型</th>
              <th class="mdui-text-center"></th>
            </tr>
            </thead>
           <tbody>
             <c:forEach items= "${business}" var="b">
            <tr class="">  <td style="text-align: center !important;padding: 0">${b.applicant_name}</td></td>
              <td style="text-align: center !important;padding: 0">${b.business_number}</td>
              <td style="text-align: center !important;padding: 0">${b.id_number}</td>
              <td style="text-align: center !important;padding: 0">${b.phone}</td>
               <td style="text-align: center !important;padding: 0">${b.service_name}</td>           
              <td style="text-align: center !important;padding: 0"><a href="Admin/sav1?xx=${b.business_number}">查看详情</a></td>
            </tr>   
            </c:forEach>       
             </tbody>
         </table>
        </div>
        <!--<div class="mdui-text-center" style="margin: 20px 0">
        	<button class="mdui-btn mdui-color-theme mdui-ripple">受理选中业务</button>
        </div>-->
  	</div>
  	<!--复审结束-->
</body>
</html>
