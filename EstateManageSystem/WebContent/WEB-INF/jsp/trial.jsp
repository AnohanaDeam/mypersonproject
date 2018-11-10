<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>房产管理系统·后台</title>
	<link rel="stylesheet" href="../mdui-v0.4.0/css/mdui.min.css"/>
	<link rel="stylesheet" href="../css/service.css" />
	<link rel="stylesheet" href="../css/table.css" />
	<script type="text/javascript" src="../js/jquery-1.11.1.min.js" ></script>
</head>
<body class="mdui-theme-primary-teal mdui-theme-accent-pink mdui-drawer-body-left mdui-appbar-with-toolbar">
  	
  	<!-- 头部菜单栏 -->
	<header class="mdui-appbar mdui-appbar-fixed">
		<div class="mdui-toolbar mdui-color-theme">
		    <a href="javascript:;" class="mdui-btn mdui-btn-icon" mdui-drawer="{target: '#left-drawer'}">
		    	<i class="mdui-icon material-icons">menu</i></a>
		    <span class="mdui-typo-title">房产管理系统·后台</span>
		    <!--<div class="mdui-toolbar-spacer"></div>
		    <a href="javascript:;" class="mdui-btn mdui-btn-icon"><i class="mdui-icon material-icons">search</i></a>
		    <a href="javascript:;" class="mdui-btn mdui-btn-icon"><i class="mdui-icon material-icons">refresh</i></a>
		    <a href="javascript:;" class="mdui-btn mdui-btn-icon"><i class="mdui-icon material-icons">more_vert</i></a>-->
		</div>
	</header>

	<!-- 左侧折叠菜单 -->
	<div class="mdui-drawer" id="left-drawer">
    	<ul class="mdui-list" mdui-collapse="{accordion: true}" style="max-width: 360px;">
		    <li class="mdui-list-item mdui-ripple">
		      <i class="mdui-list-item-icon mdui-icon material-icons">home</i>
		      <div class="mdui-list-item-content">首页</div>
		    </li>
		    <li class="mdui-list-item mdui-ripple">
		      <i class="mdui-list-item-icon mdui-icon material-icons">assignment</i>
		      <div class="mdui-list-item-content">受理业务</div>
		    </li>
		    <li class="mdui-collapse-item mdui-collapse-item-open">
		      <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
		        <i class="mdui-list-item-icon mdui-icon material-icons">people</i>
		        <div class="mdui-list-item-content">三审情况</div>
		        <i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
		      </div>
		      <ul class="mdui-collapse-item-body mdui-list mdui-list-dense">
		        <li class="mdui-list-item mdui-ripple trial"><a href="selectCertificate">初审情况</a></li>
		        <li class="mdui-list-item mdui-ripple examine">审核情况</li>
		        <li class="mdui-list-item mdui-ripple approval">审批情况</li>
		      </ul>
		    </li>
		    <!--<li class="mdui-list-item mdui-ripple">
		      <i class="mdui-list-item-icon mdui-icon material-icons">view_week</i>
		      <div class="mdui-list-item-content">登薄情况</div>
		    </li>-->
		    <li class="mdui-list-item mdui-ripple">
		      <i class="mdui-list-item-icon mdui-icon material-icons">credit_card</i>
		      <div class="mdui-list-item-content">缮证情况</div>
		    </li>
		    <li class="mdui-list-item mdui-ripple">
		      <i class="mdui-list-item-icon mdui-icon material-icons">library_books</i>
		      <div class="mdui-list-item-content">档案馆</div>
		    </li>
		</ul>
  	</div>
  	<!--初审开始-->
  	<div class="mdui-container doc-container">
  		<h1 class="doc-title mdui-text-color-theme">待初审业务</h1>
  		<!--<div class="mdui-table-fluid mdui-hoverable mdui-typo doc-content">
			<table class="mdui-table mdui-table-hoverable" style="margin-bottom: 0px;">-->
  		<div class="mdui-table-fluid mdui-hoverable mdui-typo">
          <table class="mdui-table mdui-table-hoverable">
            <thead>
            <tr>
              <th class="mdui-text-center">申请人姓名</th>
              <th class="mdui-text-center">身份证号码</th>
              <th class="mdui-text-center">联系电话</th>
              <th class="mdui-text-center">业务类型</th>
              <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="temp" items="${businessList}">
            	<tr>
	              <td class="mdui-table-cell-checkbox">
	              	<label class="mdui-checkbox"><input type="checkbox"><i class="mdui-checkbox-icon"></i></label>
	              </td>
	              <td class="mdui-text-center">${temp.applicant_name}</td>
	              <td class="mdui-text-center">${temp.id_number}</td>
	              <td class="mdui-text-center">${temp.phone}</td>
	              <td class="mdui-text-center">${temp.service_name}</td>
	              <td class="mdui-text-center"><a href="goTrialDetails?business_number=${temp.business_number}">业务审核</a></td>
	            </tr>
            </c:forEach>
            <!-- <tr>
              <td class="mdui-text-center">王小明</td>
              <td class="mdui-text-center">110103200001013759</td>
              <td class="mdui-text-center">13012340001</td>
              <td class="mdui-text-center">商品房初始登记</td>
              <td class="mdui-text-center"><a href="trialDetails.html">业务审核</a></td>
            </tr>
            <tr>
              <td class="mdui-text-center">王小明</td>
              <td class="mdui-text-center">110103200001013759</td>
              <td class="mdui-text-center">13012340001</td>
              <td class="mdui-text-center">商品房初始登记</td>
              <td class="mdui-text-center"><a href="trialDetails.html">业务审核</a></td>
            </tr>
            <tr>
              <td class="mdui-text-center">王小明</td>
              <td class="mdui-text-center">110103200001013759</td>
              <td class="mdui-text-center">13012340001</td>
              <td class="mdui-text-center">商品房初始登记</td>
              <td class="mdui-text-center"><a href="trialDetails.html">业务审核</a></td>
            </tr>
            <tr>
              <td class="mdui-text-center">王小明</td>
              <td class="mdui-text-center">110103200001013759</td>
              <td class="mdui-text-center">13012340001</td>
              <td class="mdui-text-center">商品房初始登记</td>
              <td class="mdui-text-center"><a href="trialDetails.html">业务审核</a></td>
            </tr>
            <tr>
              <td class="mdui-text-center">王小明</td>
              <td class="mdui-text-center">110103200001013759</td>
              <td class="mdui-text-center">13012340001</td>
              <td class="mdui-text-center">商品房初始登记</td>
              <td class="mdui-text-center"><a href="trialDetails.html">业务审核</a></td>
            </tr>
            <tr>
              <td class="mdui-text-center">王小明</td>
              <td class="mdui-text-center">110103200001013759</td>
              <td class="mdui-text-center">13012340001</td>
              <td class="mdui-text-center">商品房初始登记</td>
              <td class="mdui-text-center"><a href="trialDetails.html">业务审核</a></td>
            </tr>
            <tr>
              <td class="mdui-text-center">王小明</td>
              <td class="mdui-text-center">110103200001013759</td>
              <td class="mdui-text-center">13012340001</td>
              <td class="mdui-text-center">商品房初始登记</td>
              <td class="mdui-text-center"><a href="trialDetails.html">业务审核</a></td>
            </tr> -->
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
       <!-- <div class="mdui-text-center" style="margin: 20px 0">
        	<button class="mdui-btn mdui-color-theme mdui-ripple">受理选中业务</button>
        </div>-->
  	</div>
  	<!--初审结束-->
	<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="../mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		/*首页*/
		$(document).ready(function(){
		  	$("div.mdui-list-item-content").click(function(){
		  		var t = $(this).text();
		  		switch(t){
		  			case "首页":
		  			self.location='service.html';
		  			break;
		  		}
		  	});
		});
		/*受理业务*/
		$(document).ready(function(){
		  	$("div.mdui-list-item-content").click(function(){
		  		var t = $(this).text();
		  		switch(t){
		  			case "受理业务":
		  			self.location='acceptance.html';
		  			break;
		  		}
		  	});
		});
		/*初审情况*/
		$(document).ready(function(){
		  	$(".trial").click(function(){
		  		var t = $(this).text();
		  		switch(t){
		  			case "初审情况":
		  			self.location='trial.html';
		  			break;
		  		}
		  	});
		});
		/*审核情况*/
		$(document).ready(function(){
		  	$(".examine").click(function(){
		  		var t = $(this).text();
		  		switch(t){
		  			case "审核情况":
		  			self.location='examine.html';
		  			break;
		  		}
		  	});
		});
		/*审批情况*/
		$(document).ready(function(){
		  	$(".approval").click(function(){
		  		var t = $(this).text();
		  		switch(t){
		  			case "审批情况":
		  			self.location='approval.html';
		  			break;
		  		}
		  	});
		});
		/*缮证情况*/
		$(document).ready(function(){
		  	$("div.mdui-list-item-content").click(function(){
		  		var t = $(this).text();
		  		switch(t){
		  			case "缮证情况":
		  			self.location='certificate.html';
		  			break;
		  		}
		  	});
		});
		/*档案馆*/
		$(document).ready(function(){
		  	$("div.mdui-list-item-content").click(function(){
		  		var t = $(this).text();
		  		switch(t){
		  			case "档案馆":
		  			self.location='file-management.html';
		  			break;
		  		}
		  	});
		});
	</script>
	<!--缮证确认领取按钮的js 开始-->
	<script>
		$(function(){
			var tdList = $(".certificate-table tr").children(".licensing");
			/*alert(tdList.length);*/
			for (var i=0;i<tdList.length;i++) {
				var value = tdList.eq(i).text();
				var receive = tdList.eq(i).next().find(".receive");
				if(value == "否"){
					receive.removeAttr("disabled");
				}else{
					receive.attr("disabled","true");
				}
			}
		})
	</script>
	<!--缮证确认领取按钮的js 结束-->
</body>
</html>