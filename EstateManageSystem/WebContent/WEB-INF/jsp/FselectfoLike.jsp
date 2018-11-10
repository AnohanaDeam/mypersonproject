<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>房产管理系统</title>
<!--网页地址栏title旁边小图标-->
<link rel="shortcut icon" href="./img/logo.ico" type="image/x-icon" />
<link rel="stylesheet" href="./dist/aos.css" />
<link rel="stylesheet" href="./css/home.css" />
<link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.css" />
<!--弹窗-->
<link rel="stylesheet" type="text/css" media="all"
	href="./css/login.css">
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script
	src="https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="./js/jquery.leanModal.min.js"></script>
<style>/*body{ background-color: #1A1A1A; }*/
.html { /*background: #F0E68C;*/ /*background: #E6E6FA;*/
	background: #BDB76B;
}

.html a {
	color: #FFFFFF;
}

.blackboard {
	border-radius: 30px;
}
</style>
</head>
<body class="mdui-color-teal-700">
	<script type="text/javascript">
		function testAjax() {

			$.ajax({
				//发送数据的请求方式 
				type : "GET",
				url : "FselectfoLike?property_owner=" + $("#input").val(),
				//是否使用异步 
				async : true,
				//回调函数   
				success : function(data) {
					//定义变量
					var shuju = "";
					//循环json数组 
					$.each(data, function() {

						shuju += "<span>" + this.business_number + "</span>" 
							+ "<span>"+ this.Business_types + "</span>"
							+ "<span>" + this.property_owner +"</span>"
							+ "<span>" + this.File_location +"</span>"
							+ "<span>" + this.security +"</span>"
							+ "<span>" + this.address +"</span>"
							+ "<span>"+ this.Filing_date + "</span>"<br/>"
					});

					//获得标签元素   并且往标签添加 数据 
					$(".div").html(shuju);
				}
			});
		}
	</script>
	
	<input type="text" id="input" oninput="testAjax()" value="" />
	
	<div class="div">
	
	</div>
</body>

</html>