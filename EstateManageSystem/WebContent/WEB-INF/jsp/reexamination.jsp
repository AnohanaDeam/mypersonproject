<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>业务复审</title>
		<link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.min.css"/>
		<link rel="stylesheet" href="./css/table.css" />
		<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
		<script src="./mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
		<!--图片预览-->
		<style type="text/css">
			.top-title{
				color: #3F51B5 !important;
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
			textarea{
				padding: 5px;
				width: 99% !important;
				outline: none;
				resize: none;
				font-size: 15px;
			}
		</style>
	</head>
	<body>
		<div id="main">
			<div class="title top-title">
				业务详情
				<hr style="border: 1px solid #e0e0e0" />
			</div>
			<div  id="phone" class="photo-box">

			</div>
		<div id="content">
			<form action="Admin/sav3?" method="post">
				<table border="1" cellspacing="0" cellpadding="0"
					class="table mdui-table">
					<!--
							跨行：rowspan="3"
							跨列：colspan="2"
						-->
					<tr>
						<th style="text-align: center; padding: 0;">申请人</th>
						<th style="text-align: center; padding: 0;">姓名</th>
						<td>${business1.applicant_name}</td>
						<th>联系电话</th>
						<td colspan="2">${business1.phone}</td>
						<th style="text-align: center; padding: 0;">身份证号码</th>
						<td colspan="2">${business1.id_number}</td>
					</tr>
					<tr>
						<th rowspan="6" style="text-align: center; padding: 0;">房<br>屋<br>情<br>况
						</th>
						<th style="text-align: center; padding: 0;">房产地址</th>
						<td colspan="7">${roomrecord.getAddress()}</td>
					</tr>
					<tr>
						<th style="text-align: center; padding: 0;">买受人</th>
						<th style="text-align: center; padding: 0;">栋号</th>
						<th style="text-align: center; padding: 0;">房号</th>
						<th style="text-align: center; padding: 0;">面积</th>
						<th style="text-align: center; padding: 0;">签约时间</th>
						<th style="text-align: center; padding: 0;">总房款</th>
						<th style="text-align: center; padding: 0;">付款方式</th>
						<th style="text-align: center; padding: 0;">按揭银行</th>
					</tr>
					<tr>
						<td style="text-align: center; padding: 0;">
							${roomrecord.getBuyer()}</td>
						<td>${roomrecord.getMovie_theater()}</td>
						<td>${roomrecord.getRoom_number()}</td>
						<td>${roomrecord.getArea()}</td>
						<td>${roomrecord.getSigning_time()}</td>
						<td>${roomrecord.getTotal_price()}</td>
						<td style="text-align: center;">
							${roomrecord.getPayment_method()}</td>
						<td style="text-align: center;">
							${roomrecord.getMortgage_bank()}</td>
					</tr>
					<tr>
						<th style="text-align: center; padding: 0;">初审意见</th>
						<td class="td-text" colspan="7">${check1.getOne_opinion()}</td>
					</tr>
					<tr>
						<th style="text-align: center; padding: 0;">实地考察情况</th>
						<td class="td-text" colspan="7">${check1.one_realcheck}</td>
					</tr>
					<tr>
						<th style="text-align: center; padding: 0;" colspan="2">是否打印登记事项的公告</th>
						<td class="td-radio" colspan="2">是</td>
						<th style="text-align: center; padding: 0;" colspan="2">是否通过初审</th>
						<td class="td-radio" colspan="2">
							${check1.getFirst_trial_case()}</td>
					</tr>
					<tr>
						<th rowspan="2" style="text-align: center; padding: 0;">复审情况</th>
						<th style="text-align: center; padding: 0;">复审意见</th>
						<td class="mdui-hoverable td-text" colspan="7"><textarea
								rows="5" cols="20" class="input-text textarea"
								name="two_opinion"></textarea></td>
					</tr>
					<tr>
						<th colspan="2" style="text-align: center; padding: 0;">复审是否通过</th>
						<td class="mdui-hoverable td-radio" colspan="6"><input
							type="radio" name="second_case" value="是" class="input-radio"
							checked="checked" />是 <input type="radio" name="second_case"
							value="否" class="input-radio" />否</td>
					</tr>
				</table>
				<div class="additional mdui-text-center">
					<input type="submit" value="提交" 
						class="submit mdui-btn mdui-btn-raised mdui-ripple mdui-color-indigo"
						style="border-radius: 8px" />
				</div>
			</form>
		</div>
	</div>
	<script>
		$(function() {
			$('.agree').on('click', function() {
				var ischecked = $(this).data('checked');
				if (!ischecked && this.checked) {
					$(this).data('checked', true);
					$(".submit").removeAttr("disabled");
				} else {
					$(this).prop('checked', false);
					$(this).data('checked', false);
					$(".submit").attr("disabled", "true");
				}
				console.log($(this).data('checked'))
			}).data('checked', $('.agree').get(0).checked);
		})
			$(document).ready(function(){
		$.ajax({
			contentType : "application/json",
			type : "get",
			url : "getImages?business_number=${business1.business_number }",
			async : true,
			success : function(data) {
				var html = "";
				$.each(data, function() {
					html += '<div class="mdui-col-sm-4"><div class="mdui-grid-tile">'+
				        '<img src="upfile/'+this.file_name+'"/><div class="mdui-grid-tile-actions mdui-grid-tile-actions-top">'+
				        '<div class="mdui-grid-tile-text"><div class="mdui-grid-tile-title">'+this.file_type+'</div></div></div></div></div>'
				},'json');
				$('#phone').html(html);
			},
			error : function() {
				alert(1);
			}
		});
	});
	</script>
		<c:if test="${not empty msg1 }">
	<script type="text/javascript">	
		alert("${msg1}");		
	</script>
</c:if>
</body>
</html>