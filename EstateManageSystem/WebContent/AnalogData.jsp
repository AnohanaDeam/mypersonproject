<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>随机数据添加</title>
  <link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.min.css"/>
</head>
<body>

<div class="mdui-container">
	<div class="mdui-row mdui-row-gapless mdui-m-t-3">
	    <div class="mdui-col-xs-3">
	    	<div class="mdui-typo-title">添加随机业务</div>
	    	<div><button class="mdui-btn mdui-ripple mdui-btn-raised" onclick="addBusiness()">添加数据</button>
	    	<span class="mdui-m-t-2 mdui-m-l-1">添加个数
	    	<span id="num"></span>
	    	</span></div>
		  	<label class="mdui-slider mdui-slider-discrete">
		    	<input id="size" type="range" step="1" min="0" max="100" value="5"/>
		  	</label>
		</div>
	    <div class="mdui-col-xs-3"></div>
	    <div class="mdui-col-xs-3"></div>
	    <div class="mdui-col-xs-3"></div>
	  </div>
	
</div>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="./mdui-v0.4.0/js/mdui.min.js"></script>
  	<script type="text/javascript">
  		$(document).ready(function(){
  			setval();
  			$('#size').on('input propertychange',function(){
             setval();
            });
        });
  		function addBusiness(){
  			var num = $('#size').val();
  			$.ajax({
				//dataType : "json",//返回的数据类型
				contentType : "application/json",// 发送信息服务器的内容的编码格式
				type : "get",
				url : "addBusiness?addNum="+num,
				async : true,// 是否使用异步
				//回调函数
				success : function(data) {
					alert(data.msg);
				},
				error : function() {
					alert('添加失败');
				}
			});
  		}
  		function setval(){
  			$('#num').html($('#size').val());
  		}
  	</script>
</body>
</html>