<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>查看材料</title>
	<link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.min.css"/>
	<link rel="stylesheet" href="./css/table.css" />
	<!--图片预览-->
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<style type="text/css">
		.top-title{
			color: #009688 !important;
			font-weight: 900;
			/*margin-top: 90px;*/
		}
		.photo-box{
			width: 1200px;
			margin: 30px auto;
			background: gold;
		}
		.photo{
			width: 582px;
			height: 250px;
			float: left;
			margin-bottom: 30px;
		}
		.photo1{
			margin-right: 30px;
		}
		.photo-description{
			color: #009688 !important;
		}
		.photo img{
			width: 100%;
			height: 80%;
			margin-top: 25px;
			cursor: pointer;
		}
	</style>
</head>
<body>
	<div id="main">
		<div class="title top-title">
			材料详情
			<hr style="border: 1px solid #e0e0e0" />
		</div>
		<div id="imgbox" class="mdui-container"></div>
		<div id="content">
				<table border="1" cellspacing="0" cellpadding="0" class="table mdui-table">
					<tr>
						<th style="text-align: center;padding: 0;">申请人</th>
						<th style="text-align: center;padding: 0;">姓名</th>
						<td style="text-align: center;">${businessVo.applicant_name}</td>
						<th>联系电话</th>
						<td colspan="2" style="text-align: center;">${businessVo.phone}</td>
						<th style="text-align: center;padding: 0;">身份证号码</th>
						<td colspan="2" style="text-align: center;">${businessVo.id_number}</td>
					</tr>
					<tr>
						<th rowspan="6" style="text-align: center;padding: 0;">房<br>屋<br>情<br>况</th>
						<th style="text-align: center;padding: 0;">房产地址</th>
						<td colspan="7" style="text-align: center;">${housingProjectVo.address }</td>
					</tr>
					<tr>
						<th style="text-align: center;padding: 0;">买受人</th>
						<th style="text-align: center;padding: 0;">栋号</th>
						<th style="text-align: center;padding: 0;">房号</th>
						<th style="text-align: center;padding: 0;">面积</th>
						<th style="text-align: center;padding: 0;">签约时间</th>
						<th style="text-align: center;padding: 0;">总房款</th>
						<th style="text-align: center;padding: 0;">付款方式</th>
						<th style="text-align: center;padding: 0;">按揭银行</th>
					</tr>
					<tr>
						<td style="text-align: center;padding: 0;">${roomrecordVo.buyer}</td>
						<td style="text-align: center;">${roomrecordVo.movie_theater}</td>
						<td style="text-align: center;">${roomrecordVo.room_number}</td>
						<td style="text-align: center;">${roomrecordVo.area}</td>
						<td style="text-align: center;">
							<fmt:formatDate value="${roomrecordVo.signing_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td style="text-align: center;">${roomrecordVo.total_price}</td>
						<td style="text-align: center;">${roomrecordVo.payment_method}</td>
						<td style="text-align: center;">${roomrecordVo.mortgage_bank}</td>
					</tr>
				</table>
				<c:if test="${empty businessVo.service_time }">
					<div class="additional mdui-text-center">
						<a href="Admin/AcceptBusiness?number=${businessVo.business_number }" class="submit mdui-btn mdui-btn-raised mdui-ripple mdui-color-teal-500" style="border-radius: 8px">受理</a>			
					</div>
				</c:if>
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			contentType : "application/json",
			type : "get",
			url : "getImages?business_number=${businessVo.business_number }",
			async : true,
			success : function(data) {
				var html = "";
				$.each(data, function() {
					html += '<div class="mdui-col-sm-4"><div class="mdui-grid-tile mdui-hoverable mdui-ripple">'+
				        '<a href=<%=basePath%>upfile/'+this.file_name+'><img src="upfile/'+this.file_name+'"/></a><div class="mdui-grid-tile-actions mdui-grid-tile-actions-top">'+
				        '<div class="mdui-grid-tile-text"><div class="mdui-grid-tile-title">'+this.file_type+'</div></div></div></div></div>'
				},'json');
				$('#imgbox').html(html);
			},
			error : function() {
				alert(1);
			}
		});
	});
</script>
</body>
</html>
