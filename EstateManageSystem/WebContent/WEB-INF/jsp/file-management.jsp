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
  			<h1 class="doc-title mdui-text-color-theme head-title">档案查询</h1>
	  		<div class="search mdui-hoverable" style="border: 3px solid #3F51B5">
	  			<input type="text" name="search-input" id="input" class="search-input" style="outline:none;" oninput="on()"/>
	  		</div>
	  		<div class="select-box">
  				<span>搜索类型：</span>
  				<select id="sel" class="mdui-select" mdui-select="{position: 'bottom'}" style="text-align: center">
  					<option value="holder">产权人</option>
				    <option value="adNum">业务受理号</option>
				    <option value="busNum">业务类型</option>
  				</select>
  			</div>
  		</div>
		<div class="mdui-table-fluid mdui-hoverable mdui-typo doc-content">
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
					<th class="mdui-text-center">操作</th>
				</tr>
				</thead>
      			<tbody id="pu">
             <c:forEach items= "${files}" var="item">
             <c:if test="${not empty item.file_location }">
            <tr class="">
              <td style="mdui-text-center">${item.business_number}</td>
              <td style="mdui-text-center">${item.business_types}</td>
              <td style="mdui-text-center">${item.property_owner}</td>
              <td style="mdui-text-center">${item.file_location}</td>  
              <td style="mdui-text-center">${item.security}</td>  
              <td style="mdui-text-center">${item.address}</td> 
              <td style="mdui-text-center">${item.filing_date}</td>   
               <td style="mdui-text-center"><a href="Admin/updateFile?business_number=${item.business_number }">修改</a> 
                <a href="Admin/deleteFile?business_number=${item.business_number }">删除</a> </td>         
            </tr>   
            </c:if>
            </c:forEach>       
            </tbody>
			</table>
		</div>
  	<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="../mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
  	<script src="https://cdn.bootcss.com/holder/2.9.4/holder.min.js"></script>	
	<script type="text/javascript">
		function on(){
			switch ($('#sel').val()) {
			case 'holder':
				testAjax();
				break;
			case 'adNum':
				testAjax2();
				break;
			case 'busNum':
				testAjax3();
				break;
			default:
				break;
			}
		}
		function testAjax() {
			$.ajax({
				//发送数据的请求方式 
				type : "GET",
				url : "Admin/FgetInfoLike?property_owner="+$("#input").val(),
				//是否使用异步 
				async : true,
				//回调函数   data = User   data.userName = use.userName
				//		 List<User> = data , this.userName
				success : function(data) {
					//定义变量
					var shuju = "";
					//循环json数组 
					$.each(data, function() {
						shuju+='<tr class="">'+
			              '<td style="mdui-text-center">'+this.business_number+'</td>'+
			              '<td style="mdui-text-center">'+this.business_types+'</td>'+
			              '<td style="mdui-text-center">'+this.property_owner+'</td>'+
			              '<td style="mdui-text-center">'+this.file_location+'</td>'+ 
			              '<td style="mdui-text-center">'+this.security+'</td>'+  
			              '<td style="mdui-text-center">'+this.address+'</td>'+ 
			              '<td style="mdui-text-center">'+this.filing_date+'</td>'+   
			              '<td style="mdui-text-center"><a href="Admin/updateFile?business_number='+this.business_number+'">修改</a></td>'+  
			              '<td style="mdui-text-center"><a href="Admin/deleteFile?business_number='+this.business_number+'">删除</a></td>'+        
			              '</tr>';
						
						/* shuju += "<span>" + this.id + "</span>" + "<span>"
								+ this.name + "<span>"+ "<span>" + this.Signing_time +"</span><br/>" */
					});
					console.log(shuju)
					//获得标签元素   并且往标签添加 数据 
					$("#pu").html(shuju);
				}
			});
		}
		
		function testAjax2() {
			$.ajax({
				//发送数据的请求方式 
				type : "GET",
				url : "Admin/FgetInfonumber?business_number="+$("#input").val(),
				//是否使用异步 
				async : true,
				//回调函数   data = User   data.userName = use.userName
				//		 List<User> = data , this.userName
				success : function(data) {
					//定义变量
					var shuju = "";
					//循环json数组 
					$.each(data, function() {
						shuju+='<tr class="">'+
			              '<td style="mdui-text-center">'+this.business_number+'</td>'+
			              '<td style="mdui-text-center">'+this.business_types+'</td>'+
			              '<td style="mdui-text-center">'+this.property_owner+'</td>'+
			              '<td style="mdui-text-center">'+this.file_location+'</td>'+ 
			              '<td style="mdui-text-center">'+this.security+'</td>'+  
			              '<td style="mdui-text-center">'+this.address+'</td>'+ 
			              '<td style="mdui-text-center">'+this.filing_date+'</td>'+   
			              '<td style="mdui-text-center"><a href="Admin/updateFile?business_number='+this.business_number+'">修改</a></td>'+  
			              '<td style="mdui-text-center"><a href="Admin/deleteFile?business_number='+this.business_number+'">删除</a></td>'+        
			              '</tr>';
						
						/* shuju += "<span>" + this.id + "</span>" + "<span>"
								+ this.name + "<span>"+ "<span>" + this.Signing_time +"</span><br/>" */
					});
					console.log(shuju)
					//获得标签元素   并且往标签添加 数据 
					$("#pu").html(shuju);
				}
			});
		}
		
		function testAjax3() {
			$.ajax({
				//发送数据的请求方式 
				type : "GET",
				url : "Admin/FgetInfotype?business_types="+$("#input").val(),
				//是否使用异步 
				async : true,
				//回调函数   data = User   data.userName = use.userName
				//		 List<User> = data , this.userName
				success : function(data) {
					//定义变量
					var shuju = "";
					//循环json数组 
					$.each(data, function() {
						shuju+='<tr class="">'+
			              '<td style="mdui-text-center">'+this.business_number+'</td>'+
			              '<td style="mdui-text-center">'+this.business_types+'</td>'+
			              '<td style="mdui-text-center">'+this.property_owner+'</td>'+
			              '<td style="mdui-text-center">'+this.file_location+'</td>'+ 
			              '<td style="mdui-text-center">'+this.security+'</td>'+  
			              '<td style="mdui-text-center">'+this.address+'</td>'+ 
			              '<td style="mdui-text-center">'+this.filing_date+'</td>'+   
			              '<td style="mdui-text-center"><a href="Admin/updateFile?business_number='+this.business_number+'">修改</a></td>'+  
			              '<td style="mdui-text-center"><a href="Admin/deleteFile?business_number='+this.business_number+'">删除</a></td>'+        
			              '</tr>';
						
						/* shuju += "<span>" + this.id + "</span>" + "<span>"
								+ this.name + "<span>"+ "<span>" + this.Signing_time +"</span><br/>" */
					});
					console.log(shuju)
					//获得标签元素   并且往标签添加 数据 
					$("#pu").html(shuju);
				}
			});
		}
	</script>
</body>	
</html>