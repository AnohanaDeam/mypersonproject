<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" href="./dist/aos.css" />
<link rel="stylesheet" type="text/css" href="./login_files/normalize.css">
<link rel="stylesheet" type="text/css" href="./login_files/demo.css">
<link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.min.css"/>
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="./login_files/component.css">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
<style type="text/css">
	.logo_box{
		background: rgba(0,0,0,0.6);
		/* opacity:0.6; */
	}
	.input_outer{
		border:rgba(255,255,255,0.5) 2px solid !important;
	}
</style>
</head>
<body class="mdui-color-theme-light-indigo mdui-theme-accent-indigo">
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header" style="height: 925px;">
				<canvas id="demo-canvas" width="1920" height="925"></canvas>
				<div class="logo_box">
					<h3>欢迎你登陆·尊敬的管理员</h3>
						<div class="mdui-textfield mdui-textfield-floating-label">
						  <label class="mdui-textfield-label mdui-text-color-white">用户名</label>
						  <input onblur="login1()" name="username" id="username" class="mdui-textfield-input mdui-text-color-white" type="text" required/>
						  <div id="user" class="mdui-textfield-error mdui-text-color-red-100"></div>
						</div>
						<div class="mdui-textfield mdui-textfield-floating-label">
						  <label class="mdui-textfield-label mdui-text-color-white">密码</label>
						  <input onblur="login2()" name="password" id="password" class="mdui-textfield-input mdui-text-color-white" type="password" required/>
						  <div id="pass" class="mdui-textfield-error mdui-text-color-red-100"></div>
						</div>
						<div class="mdui-row">
						  <div class="mdui-col-xs-12 mdui-col-sm-8">
						  	<div class="mdui-textfield mdui-textfield-floating-label">
							  <label class="mdui-textfield-label mdui-text-color-white">验证码</label>
							  <input id="validateCode" onkeyup="this.value=this.value.toUpperCase()" name="validateCode" onblur="checkImg(this.value)" type="text" class="mdui-textfield-input mdui-text-color-white" type="text" required/>
							  <div id="text1" class="mdui-textfield-error mdui-text-color-red-100"></div>
							</div>
						  </div>
						  <div class="mdui-col-xs-6 mdui-col-sm-4">
								<img class="mdui-img-rounded mdui-m-t-5" id="codeValidateImg" style="color: #FFFFFF !important;" onClick="javascript:flushValidateCode();"/>
							</div>
						</div>
						<div class="mdui-row">
						  <div class="mdui-col-xs-8 mdui-text-right">
								<button onclick="loginAajx()" class="mdui-btn-block mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">登录</button>
							</div>
						  <div class="mdui-col-xs-4 mdui-text-right">
						  		<button class="mdui-btn mdui-color-theme-accent mdui-ripple" onclick="flushValidateCode()"><i class="mdui-icon material-icons">cached</i>换一张</button>
						  </div>
						</div>
				</div>
			</div>
		</div>
	</div><!-- /container -->
	<script src="./login_files/TweenLite.min.js"></script>
	<script src="./login_files/EasePack.min.js"></script>
	<script src="./login_files/rAF.js"></script>
	<script src="./login_files/demo-1.js"></script>
	<script type="text/javascript">
			var next;
			//alert(next);
			
			function loginAajx() {
				if(next=="true"){
				//alert(next);
				/* var user_name = $("input[name='user_name']").val();
				var user_pass = $("input[name='user_pass']").val(); */
				var user_name=document.getElementById("username").value;
				var user_pass=document.getElementById("password").value;
				//alert(user_name);
				$.ajax({
					//dataType : "json",//返回的数据类型
					contentType : "application/json",// 发送信息服务器的内容的编码格式
					type : "post",
					url : "logincheck?user_name="+user_name+"&user_pass="+user_pass,
					async : true,// 是否使用异步
					//回调函数
					success : function(data) {
						if(data.state == "登录成功"){
							top.location.href = "Admin/service?user_name="+user_name;
						}else{
							alert(data.state);
						}
					},
					error : function() {
						//数据发送或接受失败的方法
						alert(1);
					}
				});
			}
			else{
			alert("验证码错误");
			}
			}
			
			 $(document).ready(function() {
			 //alert(6666);
		     flushValidateCode();//进入页面就刷新生成验证码
		   });
		
		/* 刷新生成验证码 */
		function flushValidateCode(){
		//alert(6666);
		var validateImgObject = document.getElementById("codeValidateImg");
		validateImgObject.src = "getSysManageLoginCode?time=" + new Date();
		//alert(6666);
		}
		/*校验验证码输入是否正确*/
		function checkImg(code){
			//alert(666);
		    var url = "checkimagecode";
		    $.get(url,{"validateCode":code},function(data){
		        if(data=="ok"){
		        	document.getElementById("text1").innerHTML="验证码正确";
		        	next="true";
		        	//alert(next);
		        }else{
		         	document.getElementById("text1").innerHTML="验证码错误";
		            flushValidateCode();
		            next="false";
		            //alert(next);
		            
		        }
		    });
		} 
		</script>
		<script>
    	function login1(){
    		var username=document.getElementById("username").value;
    		var isnull= /\S/;
    		if(!isnull.test(username)){
    			
    				document.getElementById("user").innerHTML="用户名不能为空";
    			}
    		else{
    			document.getElementById("user").innerHTML="";
    		}
    	}
    	function login2(){
    		var password=document.getElementById("password").value;
    		var isnull= /\S/;
    		if(!isnull.test(password)){
    			
    				document.getElementById("pass").innerHTML="密码不能为空";
    			}
    		else{
    			document.getElementById("pass").innerHTML="";
    		}
    	}
    </script>
</body>
</html>