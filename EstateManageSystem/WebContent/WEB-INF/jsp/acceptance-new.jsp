<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
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
	<!--受理业务开始-->
  	<div class="mdui-container doc-container">
  		<h1 class="doc-title mdui-text-color-theme mdui-text-color-teal-500">当前未被受理业务</h1>
  		<div class="mdui-table-fluid mdui-hoverable mdui-typo">
          <table class="mdui-table mdui-table-selectable">
            <thead>
            <tr> 
              <th class="mdui-table-cell-checkbox"><label class="mdui-checkbox"><input type="checkbox"><i class="mdui-checkbox-icon"></i></label></th>
              <th class="mdui-text-center">业务受理号</th>
              <th class="mdui-text-center">申请人姓名</th>
              <th class="mdui-text-center">身份证号码</th>
              <th class="mdui-text-center">联系电话</th>
              <th class="mdui-text-center">业务类型</th>
              <th class="mdui-text-center"></th>
            </tr>
            </thead>
             <tbody>
             <c:forEach items= "${businesses}" var="item">
             <c:if test="${empty item.service_time }">
            <tr class="">
            <td class="mdui-table-cell-checkbox"><label class="mdui-checkbox"><input type="checkbox"><i class="mdui-checkbox-icon"></i></label></td>
              <td style="mdui-text-center">${item.business_number}</td>
              <td style="mdui-text-center">${item.applicant_name}</td>
              <td style="mdui-text-center">${item.id_number}</td>
              <td style="mdui-text-center">${item.phone}</td>  
              <td style="mdui-text-center">${item.serviceVo.service_name}</td>          
              <td style="mdui-text-center"><a href="select?xx=${item.business_number}">查看材料</a></td>
            </tr>   
            </c:if>
            </c:forEach>       
            </tbody>
          </table>
          <div class="mdui-text-center">
	        	<div class="mdui-btn-group">
	        		<button type="button" class="mdui-btn mdui-hidden">
						<i class="mdui-icon material-icons">chevron_left</i>
				    </button>
				    <button type="button" class="mdui-btn mdui-btn-active">1</button>
				    <button type="button" class="mdui-btn">2</button>
				    <button type="button" class="mdui-btn">3</button>
				    <button type="button" class="mdui-btn">4</button>
				    <button type="button" class="mdui-btn">...</button>
				    <button type="button" class="mdui-btn">
						<i class="mdui-icon material-icons">chevron_right</i>
				    </button>
				</div>
	        </div>
        </div>
        <div class="mdui-text-center" style="margin: 20px 0">
        	<button class="mdui-btn mdui-color-theme mdui-ripple">受理选中业务</button>
        </div>
  	</div>


  	<div class="mdui-container doc-container" style="margin-bottom: 50px;">
  		<h1 class="doc-title mdui-text-color-theme mdui-text-color-teal-500">当前已受理业务</h1>
  		<div class="mdui-table-fluid mdui-hoverable mdui-typo">
          <table class="mdui-table">
            <thead>
            <tr> 
              <th class="mdui-text-center">业务受理号</th>
              <th class="mdui-text-center">申请人姓名</th>
              <th class="mdui-text-center">身份证号码</th>
              <th class="mdui-text-center">联系电话</th>
              <th class="mdui-text-center">业务类型</th>
              <th class="mdui-text-center">业务受理时间</th>
              <th class="mdui-text-center"></th>
            </tr>
            </thead>
             <tbody>
             <c:forEach items= "${businesses}" var="item">
             <c:if test="${not empty item.service_time }">
            <tr>         
              <td class="mdui-text-center">${item.business_number}</td>
              <td class="mdui-text-center">${item.applicant_name}</td>
              <td class="mdui-text-center">${item.id_number}</td>
              <td class="mdui-text-center">${item.phone}</td>  
              <td class="mdui-text-center">${item.serviceVo.service_name}</td> 
              <td class="mdui-text-center">
              	<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${item.service_time}"/>
              </td>             
              <td class="mdui-text-center"><a href="select?xx=${item.business_number}">查看材料</a></td>
            </tr>  
            </c:if> 
            </c:forEach>       
            </tbody>
          </table>
          <div class="mdui-text-center">
	        	<div class="mdui-btn-group">
	        		<button type="button" class="mdui-btn mdui-hidden">
						<i class="mdui-icon material-icons">chevron_left</i>
				    </button>
				    <button type="button" class="mdui-btn mdui-btn-active">1</button>
				    <button type="button" class="mdui-btn">2</button>
				    <button type="button" class="mdui-btn">3</button>
				    <button type="button" class="mdui-btn">4</button>
				    <button type="button" class="mdui-btn">...</button>
				    <button type="button" class="mdui-btn">
						<i class="mdui-icon material-icons">chevron_right</i>
				    </button>
				</div>
	        </div>
        </div>
  	</div>
	<!--受理业务结束-->
</body>
</html>