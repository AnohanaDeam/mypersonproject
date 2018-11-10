<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
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
	<script src="./mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
	<c:if test="${not empty msg }">
      <script type="text/javascript">alert("${msg }");</script></c:if>
</head>
<body class="mdui-theme-primary-indigo mdui-theme-accent-pink">
  	
	<!--受理业务开始-->
  	<div class="mdui-container doc-container">
  		<h1 class="doc-title mdui-text-color-theme">当前未被受理业务</h1>
  		<div class="mdui-table-fluid mdui-hoverable mdui-typo">
          <table class="mdui-table">
            <thead>
            <tr> 
              <th class="mdui-text-center">业务受理号</th>
              <th class="mdui-text-center">申请人姓名</th>
              <th class="mdui-text-center">身份证号码</th>
              <th class="mdui-text-center">联系电话</th>
              <th class="mdui-text-center">业务类型</th>
              <th class="mdui-text-center"></th>
            </tr>
            </thead>
             <tbody id="tb_noaccept"></tbody>
          </table>
          <div class="mdui-text-center">
	        	<div id="noaccept" class="mdui-btn-group"></div>
	        </div>
        </div>
  	</div>


  	<div class="mdui-container doc-container" style="margin-bottom: 50px;">
  		<h1 class="doc-title mdui-text-color-theme">当前已受理业务</h1>
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
             <tbody id="tb_accept"></tbody>
          </table>
          <div class="mdui-text-center">
	        	<div id="accept" class="mdui-btn-group"></div>
	        </div>
        </div>
  	</div>
	<!--受理业务结束-->
	<!-- 分页ajax请求 -->
	<script type="text/javascript">
	$(document).ready(function(){
		ajaxnoaccept(1);
		ajaxaccept(1);
	});
	function ajaxnoaccept(page){
		$.ajax({
			contentType : "application/json;charset=utf-8",// 发送信息服务器的内容的编码格式
			type : "get",
			url : "Admin/timenull?num="+page,
			//回调函数
			success : function(data) {
				var html = "";
				var html2 = "";
				console.log(page);
				if(page!=1&&false){
					html+='<button type="button" class="mdui-btn">'+
						'<i class="mdui-icon material-icons">chevron_left</i>'+
					  '</button>';
				}
				if(data.count!=0)
					for (var i = 1; i <= data.count; i++) {
						if(i==page){
							html+='<button type="button" class="mdui-btn mdui-btn-active"'+
								'onclick="ajaxnoaccept('+i+')">'+i+'</button>';
						}else{
							html+='<button type="button" class="mdui-btn"'+
								'onclick="ajaxnoaccept('+i+')">'+i+'</button>';
						}
					}
				if(page!=data.count&&data.count!=0&&false){
					html+='<button type="button" class="mdui-btn">'+
						'<i class="mdui-icon material-icons">chevron_right</i>'+
					   '</button>';
				}
				$.each(data.businessVos, function() {
					html2+='<tr>'+
					  '<td style="mdui-text-center">'+this.business_number+'</td>'+
		              '<td style="mdui-text-center">'+this.applicant_name+'</td>'+
		              '<td style="mdui-text-center">'+this.id_number+'</td>'+
		              '<td style="mdui-text-center">'+this.phone+'</td>'+
		              '<td style="mdui-text-center">'+this.serviceVo.service_name+'</td>'+          
		              '<td style="mdui-text-center"><a href="Admin/checkMaterial?number='+this.business_number+'">查看材料</a></td></tr>'
				},'json');
				$('#tb_noaccept').html(html2);
				$('#noaccept').html(html);
			},
			error : function() {
				alert("error");
			}
		});
	}
	function ajaxaccept(page){
		$.ajax({
			contentType : "application/json;charset=utf-8",// 发送信息服务器的内容的编码格式
			type : "get",
			url : "Admin/timenonull?num="+page,
			//回调函数
			success : function(data) {
				var html = "";
				var html2 = "";
				console.log(page);
				if(page!=1&&false){
					html+='<button type="button" class="mdui-btn">'+
						'<i class="mdui-icon material-icons">chevron_left</i>'+
					  '</button>';
				}
				if(data.count!=0)
					for (var i = 1; i <= data.count; i++) {
						if(i==page){
							html+='<button type="button" class="mdui-btn mdui-btn-active"'+
								'onclick="ajaxaccept('+i+')">'+i+'</button>';
						}else{
							html+='<button type="button" class="mdui-btn"'+
								'onclick="ajaxaccept('+i+')">'+i+'</button>';
						}
					}
				if(page!=data.count&&data.count!=0&&false){
					html+='<button type="button" class="mdui-btn">'+
						'<i class="mdui-icon material-icons">chevron_right</i>'+
					   '</button>';
				}
				$.each(data.businessVos, function() {
					html2+='<tr><td style="mdui-text-center">'+this.business_number+'</td>'+
					'<td style="mdui-text-center">'+this.applicant_name+'</td>'+
					'<td style="mdui-text-center">'+this.id_number+'</td>'+
					'<td style="mdui-text-center">'+this.phone+'</td>'+  
					'<td style="mdui-text-center">'+this.serviceVo.service_name+'</td>'+
					'<td style="mdui-text-center">'+this.service_timestr+'</td>'+
					'<td style="mdui-text-center"><a href="Admin/checkMaterial?number='+this.business_number+'">查看材料</a></td></tr>';
				},'json');
				$('#tb_accept').html(html2);
				$('#accept').html(html);
				mdui.mutation();
			},
			error : function() {
				alert("error");
			}
		});
	}
	function AcceptBusiness(){
		var datalist= new Array();
		$ajax({
			contentType : "application/json;charset=utf-8",// 发送信息服务器的内容的编码格式
			type : "get",
			url : "Admin/timenonull?num="+page,
			//回调函数
			success : function(data) {
				
			},
			error : function() {
				alert("error");
			}
		});
	}
	function checked(){
		alert(this.value);
	}
	</script>
</body>

</html>