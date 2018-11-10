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
<!--success弹窗-->
    <link rel="stylesheet" href="./css/iosOverlay.css">
    <script src="./js/jquery.min.js"></script>
    <script src="./js/iosOverlay.js"></script>
    <script src="./js/custom.js"></script>
    <!--//////////-->
    <link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.min.css"/>
	<link rel="stylesheet" href="./css/table.css" />
	<link rel="stylesheet" href="./css/service.css" />
	<!-- <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script> -->
	<style type="text/css">
		.prompt-box{
			border: 2px solid rgb(170, 170, 170);
			width: 284px;
			height: auto;
			z-index: 50;
			position: relative;
			left: 959px;
			top: -280px; 
			border-radius: 8px;
			background: #ffffff;
			padding: 8px 8px 0 8px;
			display: none;
		}
		.searchList{
			list-style: none;
			width: 90%;
			margin-bottom: 6px;
			font-size: 16px;
		}
	</style>
</head>
<body>
  	<!--缮证开始-->
  	<div class="mdui-container doc-container">
  		<!-- style="font-size: 30px;font-weight: 800"  style="margin-top: 50px;"-->
  		<div class="doc-top">
  			<h1 class="doc-title mdui-text-color-theme head-title mdui-text-color-indigo">缮证情况</h1>
  			<form method="get"> 
		  		<div class="search mdui-hoverable" style="border: 3px solid #3F51B5">
		  			<input type="text" name="searchInput" oninput="select111()" class="search-input" value="" style="outline:none;" />
		  			<!-- <button class="search-button">
		  				<i class="mdui-icon material-icons search-ico">&#xe8b6;</i>
		  			</button> -->
		  			<input type="submit" value="&#xe8b6;" class="search-button mdui-icon material-icons"/>
		  		</div>
		  		<div class="select-box">
	  				<span>搜索类型：</span>
	  				<select class="mdui-select" id="selected"  mdui-select="{position: 'bottom'}" style="text-align: center" name="searchSelect">
	  					<option value="1">证件号</option>
					    <option value="2">类型</option>
					    <option value="3">业务号</option>
					    <option value="4">证件所有人</option>
	  				</select>
	  			</div>
  			</form>
  		</div>
  		<div class="mdui-table-fluid mdui-hoverable doc-content">
          <table class="mdui-table certificate-table">
            <thead>
            <tr>
              <th class="mdui-text-center">证件号</th>
              <th class="mdui-text-center">业务类型</th>
              <th class="mdui-text-center">业务受理号</th>
              <th class="mdui-text-center">证件所有人</th>
              <th class="mdui-text-center">是否领证</th>
              <th class="mdui-text-center"></th>
            </tr>
            </thead>
            <tbody id="tb">
            <c:forEach var="cl" items="${certificateList}">
            	<form action="Admin/updateCertificate" method="post">
	            	<tr>
		              <td class="mdui-text-center">${cl.certificate_id}</td>
		              <td class="mdui-text-center">${cl.business_types}</td>
		              <td class="mdui-text-center">
		              	<input type="text" style="border: 0px" readonly="readonly" name="business_number" value="${cl.business_number}">
		              </td>
		              <td class="mdui-text-center">${cl.owner}</td>
		              <td class="licensing mdui-text-center">${cl.receive}</td>
		              <td style="text-align: center !important">
		              	<%-- <a href="Admin/updateCertificate?business_number=${cl.business_number}" id="checkMark" class="receive mdui-color-indigo mdui-btn mdui-btn-raised">确认领取</a> --%>
		              	<input type="submit" value="确认领取" id="checkMark" class="receive mdui-color-indigo mdui-btn mdui-btn-raised">
		              </td>
		            </tr>
	            </form>
            </c:forEach>
            </tbody>
          </table>
        </div>
  	</div>
</body>
  	<!--缮证结束-->
	<script src="./js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="./mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
	<script>
		/* 确认领取按钮的控制 开始 */
		$(function isReceive(){
			var tdList = $(".certificate-table tr").children(".licensing");
			/*alert(tdList.length);*/
			for (var i=0;i<tdList.length;i++) {
				var value = tdList.eq(i).text();
				var receive = tdList.eq(i).next().find(".receive");
				if(value == "否"){
					receive.removeAttr("disabled");
				}else{
					receive.removeAttr("id");
					receive.attr("disabled","true");
				}
			}
		});
		/*确认按钮的控制 结束*/
		/*模糊查询 开始*/
		function select111(){
			var selectVal = $("#selected").val();
			var search = $(".search-input");
			var promptData = "";
				$.ajax({
					type: "GET",
					url: "Admin/prompt",
					dataType: "json",
		            data: { "searchVal": search.val(),"selectVal": selectVal },	
					async: true,
					success: function(result){
					promptData+="<form action='Admin/updateCertificate' method='post'>";
						$.each(result,function(){
							console.log("yayayayayayayaya-->"+this);
							promptData += "<tr><td class='mdui-text-center' >"
							+ this.certificate_id + "</td><td class='mdui-text-center' >"
							+ this.business_types + "</td><td class='mdui-text-center' ><input type='text' readonly='readonly' style='border: 0px;' value="
							+ this.business_number+ "></td><td class='mdui-text-center' >"
							+ this.owner+ "</td><td class='mdui-text-center' >"
							+ this.receive+ "</td>";
							
							if(this.receive == "否"){
									promptData +="<td style='text-align: center !important'><input type='submit' value='确认领取' id='checkMark' class='receive mdui-color-indigo mdui-btn mdui-btn-raised'></td>"
							+"</tr>";
							}else{
									promptData +="<td style='text-align: center !important'><input type='submit' value='确认领取' id='checkMark' class='receive mdui-color-indigo mdui-btn mdui-btn-raised' disabled='disabled'></td>"
							+"</tr>";
							}
							var tdList = $(".certificate-table tr").children(".licensing");
						});//each
						
						promptData+="</form>";
						
						/* alert(promptData); */
						$("#tb").html(promptData);
						}
				});//ajax
			};
		/*模糊查询 结束*/
	</script>
</html>