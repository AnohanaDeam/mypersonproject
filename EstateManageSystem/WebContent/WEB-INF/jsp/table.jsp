	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>房产登记申请书</title>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.min.css" />
    <link rel="stylesheet" href="./css/table.css" />
    <script src="./js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="./mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
   	<style type="text/css">
   		table tr td{
   			line-height: 48px !important;
   			/* padding-right: 5px !important; */
   		}
   		table tr td:HOVER{
   			border: 1px solid #7986CB;
   		}
	   	table tr td .input-text {
			min-height: 48px !important;
			padding-left: 8px;
			outline:none;
			/* width: 97%; */
			width: 66%;
			font-size: 15px;
			float: left;
		}
		table tr td span{
			float: right;
			margin-right: 5px;
		}
		select{
			font-size: 15px;
			text-align: center;
			outline:none;
		}
		select option{
			border-top: 0px;
		}
   		.file-box{
   			width: 29%;
   			/* border: 2px solid #3f51b5; */
   			border: 2px solid #7986CB;
   			padding: 0;
   			margin-bottom: 5px;
   		}
   		.file-name{
   			width: 99% !important;
   			line-height: 45px;
   			text-align: right;
   		}
   		.file-up {
		    position: relative;
		    right: -5px;
		    display: inline-block;
		    padding: 8px 15px;
		    overflow: hidden;
		    color: #1E88C7;
		    text-decoration: none;
		    text-indent: 0;
		    line-height: 31px;
		}
		.file-up input {
		    position: absolute;
		    font-size: 100px;
		    right: 0;
		    top: 0;
		    opacity: 0;
		}
   	</style>
     <script>	
     			var a1=false,a2=false,a3=false,a5=false,a6=false,a7=false,a8=false,a9=false;
				//15或18位身份证
				var isidentity=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
				//var isidentity=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
				//电信，移动，联通目前发行的号码
				var isphone=/^1[3,4,5,7,8]\d{9}$/;
				//2-6位汉字
				var isname=/^[\u4e00-\u9fa5]{2,6}$/;
				//不能为空
				var isnull= /\S/;
				//只能为数字、小数只能为小数点后四位
				var number=/^\d+(?:\.\d{1,4})?$/;
			function name1(){
				//alert("66666");
				var name=document.getElementById("name").value;
				if(!isname.test(name)){
				 	//alert("姓名只能为2-6位汉字");
				 	document.getElementById("text1").innerHTML="姓名只能为2-6位汉字";
				 	a1=false;
				}
				else{
					document.getElementById("text1").innerHTML="";
					a1=true;
				}
			}
			function phone1(){
				var phone=document.getElementById("phone").value;
				if(!isphone.test(phone)){
					//alert("请输入合法的手机号码");
					document.getElementById("text2").innerHTML="请输入合法的手机号码";
					a2=false;
				}
				else{
					document.getElementById("text2").innerHTML="";
					a2=true;
				}
			}
			function identity1(){
				var identity=document.getElementById("identity").value;
				if(!isidentity.test(identity)){
					//alert("请输入合法的18位身份证");
					document.getElementById("text3").innerHTML="请输入合法的18位身份证";
					a3=false;
				}
				else{
					document.getElementById("text3").innerHTML="";
					a3=true;
				}
			}
			/* function address1(){
				var address=document.getElementById("address").value;
				if(!isnull.test(address)){
					//alert("地址不能为空");
					document.getElementById("text4").innerHTML="地址不能为空";
					a4=false;
				}
				else{
					document.getElementById("text4").innerHTML="";
					a4=true;
				}
			} */
			function only1(){
				var only=document.getElementById("only").value;
				
				if(!isname.test(only)){
				 	//alert("买受人只能为2-6位汉字");
				 	document.getElementById("text5").innerHTML="2-6位汉字";
				 	a5=false;
				}
				else{
					document.getElementById("text5").innerHTML="";
					a5=true;
				}
			}
			function build1(){
				var build=document.getElementById("build").value;
				if(!isnull.test(build)){
					//alert("栋号不能为空");
					document.getElementById("text6").innerHTML="不能为空";
					a6=false;
				}else{
					document.getElementById("text6").innerHTML="";
					a6=true;
				}
				
			}
			function room1(){
				var room=document.getElementById("room").value;
				if(!isnull.test(room)){
					//alert("房号不能为空");
					document.getElementById("text7").innerHTML="房号不能为空";
					a7=false;
				}else{
					document.getElementById("text7").innerHTML="";
					a7=true;
				}
			}
			function area1(){
				//alert("面积不可为空、不可为负、只能为数字");
				var area=document.getElementById("area").value;
				if(!isnull.test(area)||!number.test(area)){
					//alert("面积不可为空、不可为负、只能为数字");
					document.getElementById("text8").innerHTML="不合法";
					a8=false;
				}else{
					document.getElementById("text8").innerHTML="";
					a8=true;
				}
				
			}
			function sum1(){
				var sum=document.getElementById("sum").value;
				if(!isnull.test(sum)||!number.test(sum)){
					//alert("总房款不可为空、不可为负、只能为数字");
					document.getElementById("text9").innerHTML="不合法";
					a9=false;
				}
				else{
					document.getElementById("text9").innerHTML="";
					a9=true;
				}
			}
		</script>
    </head>
<body>
  <div id="main">
  	<!-- 头部菜单栏 -->
	<header class="mdui-appbar mdui-appbar-fixed mdui-color-indigo">
		<div class="mdui-toolbar mdui-color-theme">
			<a href="goHome" class="mdui-btn mdui-btn-icon" mdui-drawer="{target: '#left-drawer'}">
			   <i class="mdui-icon material-icons">&#xe88a;</i>
			</a>
			<span class="mdui-typo-title">房产管理系统·后台 </span>
		</div>
	</header>
    <div class="title">${businessVo.service_name }申请书</div>
    <div id="content">
        <table border="1" cellspacing="0" cellpadding="0" class="table mdui-table">
        <form:form id="businessform" modelAttribute="businessVo">
          <tr>
            <th rowspan="2" style="text-align: center;padding: 0;">申
              <br>请
              <br>人</th>
            <th style="text-align: center;padding: 0;">姓名</th>
            <td colspan="2" class="mdui-p-a-0">
              	<input type="text" name="applicant_name" Class="input-text" id="name"  onblur="name1()" maxlength="6" />
              	<span id="text1" style="color: red"></span>
            </td>
            <th>联系电话</th>
            <td colspan="2" class="mdui-p-a-0">
              <input type="text" name="phone" Class="input-text" id="phone"  onblur="phone1()" maxlength="18"/>
              <span id="text2" style="color: red"></span>
            </td>
          </tr>
          <tr>
            <th style="text-align: center;padding: 0;">身份证号码</th>
           <td colspan="5" class="mdui-p-a-0">
              <input type="text" name="id_number" Class="input-text" id="identity"  onblur="identity1()" maxlength="18" /><!--  style="width: 99.3%" -->
              <span id="text3" style="color: red"></span>
           </td>
          </tr>
          <tr class="mdui-hidden">
          	<td><input type="text" name="business_number" value="${businessVo.business_number }"/></td>
          	<td><input type="text" name="f_service" value="${businessVo.f_service }"/></td>
          	<td><input type="text" name="service_number" value="${businessVo.service_number }"/></td>
          </tr>
          </form:form>
          <form:form id="roomrecordform" modelAttribute="roomrecordVo">
          <tr>
            <th rowspan="7" style="text-align: center;padding: 0;">
            	房<br>屋<br>情<br>况
            </th>
          </tr>
          <tr>
          <!-- colspan="2"  -->
          	<th style="text-align: center;padding: 0;">房产项目</th>
          	<th style="text-align: center;padding: 0;">房产地址</th>
            <th style="text-align: center;padding: 0;" colspan="2">栋号</th>
            <th style="text-align: center;padding: 0;">房号</th>
            <th style="text-align: center;padding: 0;">面积</th></tr>
         <tr>
         	<td class="mdui-p-a-0" style="padding: 0">
              <select id="housingitem" name="item_no">
              	<option value="">无</option>
                <c:forEach items="${housingProjectVos }" var="item">
                  <option value="${item.item_no }">${item.project_name }</option></c:forEach>
              </select>
            </td>
         	<td class="mdui-p-a-0">
              <input type="text" readonly="readonly" name="address" Class="input-text" maxlength="40" value="请先选择房产项目"/></td>
            <td class="mdui-p-a-0" colspan="2">
              <input type="text" name="movie_theater" Class="input-text" id="build"  onblur="build1()" maxlength="10"/><span id="text6" style="color: red;"></span></td>
            <td class="mdui-p-a-0">
              <input type="text" name="room_number" Class="input-text" id="room"  onblur="room1()" maxlength="10"/><span id="text7" style="color: red;"></span></td>
            <td class="mdui-p-a-0">
              <input type="text" name="area" Class="input-text" id="area"  onblur="area1()" maxlength="10"/><span id="text8" style="color: red;"></span></td>
          </tr>
          <tr>
            <th style="text-align: center;padding: 0;" colspan="2">合同号</th>
            
            <th style="text-align: center;padding: 0;" colspan="2">买受人</th>
            
            <th style="text-align: center;padding: 0;" colspan="2">签约时间</th>
            
          </tr>
          <tr>
          	<td class="mdui-p-a-0" colspan="2">
              <input type="text" readonly="readonly" name="business_number" Class="input-text" value="${businessVo.business_number }" />
            </td>
            <td class="mdui-p-a-0" colspan="2" style="text-align: center;padding:24px;">
              <input type="text" name="buyer" Class="input-text" id="only"  onblur="only1()" maxlength="6" /><span id="text5" style="color: red;"></span>
            </td>
            <td class="mdui-p-a-0" colspan="2">
              <input type="date" name="signing_time" Class="input-text" style="width: 98%" />
            </td>
          </tr>
          <tr>
            <th style="text-align: center;padding: 0;">总房款（万元）</th>
           <td class="mdui-p-a-0">
              <input type="text" name="total_price" Class="input-text" id="sum"  onblur="sum1()" maxlength="10"/><span id="text9" style="color: red;"></span></td>
            <th style="text-align: center;padding: 0;">付款方式</th>
            <td class="mdui-p-a-0" style="padding: 0">
              <select name="payment_method">
                <option value="全额付款">全额付款</option>
                <option value="分期付款">分期付款</option></select>
            </td>
            <th style="text-align: center;padding: 0;">按揭银行</th>
            <td class="mdui-p-a-0" style="padding: 0">
              <select name="mortgage_bank">
              	<option value="">无</option>
                <c:forEach items="${banks }" var="item">
                  <option value="${item }">${item }</option></c:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <th style="text-align: center;padding: 0;">预售备案</th>
            <td colspan="2" class="mdui-p-a-0">
              <input type="text" name="booking_record" Class="input-text" style="width: 98.3%" maxlength="50" /></td>
            <th style="text-align: center;padding: 0;">按揭备案</th>
            <td colspan="2" class="mdui-p-a-0" style="padding: 0">
              <input type="text" name="mortgage_reg" Class="input-text" style="width: 98.5%" maxlength="50" /></td>
           <%--  <th style="text-align: center;padding: 0;">房产项目</th>
            <td colspan="2" class="mdui-hoverable mdui-p-a-0" style="padding: 0">
              <select id="housingitem" name="item_no">
              	<option value="">无</option>
                <c:forEach items="${housingProjectVos }" var="item">
                  <option value="${item.item_no }">${item.project_name }</option></c:forEach>
              </select>
            </td> --%>
          </tr>
          </form:form>
        </table>
      
        <div class="additional mdui-text-center" style="width: 50%">
        <form action="upfile1" method="post" id="fileform" enctype="multipart/form-data">
        	<!-- 文件上传 -->
          <%-- <table style="width: 53%">
         <% int i =0; %> 
            <c:forEach items="${bAndMVos }" var="item">
             <%  i++; %> 
              <tr>
                <td class="" style="width: 60px">
                  <label for="ch">文件上传</label></td>
                <td class="mdui-text-left" style="width: 250px">
                  <label for="ch">必要与否?(<span id="whether<%=i%>" style="color:red">${item.whether }</span>)${item.mtypeVo.material_name }:</label></td>
                <td class="mdui-text-left">
                  <input type="file" name="materials" class="material" /></td>
              </tr>
            </c:forEach>
          </table> --%>
          	<p class="fileUpWarn" style="color: red;width: 280px"></p>
          	<div class="mdui-row">
          	<%int i = 0; %>
          	<c:forEach items="${bAndMVos }" var="item">
          		
			  <div class="mdui-col-xs-6 mdui-col-sm-4 file-box" style="width:300px">
			  	<p class="file-name" >
			  		
			  		<%i++; %>
			  		<span>上传文件：${item.mtypeVo.material_name }</span>
			  		<a class="file-up mdui-icon material-icons mdui-color-indigo-300 mdui-hoverable mdui-ripple">
		          		&#xe2c6;
		          		<input type="file" name="materials" class="material" onchange="fileUp(this)" value="12123"/>
		         	</a>
			  	</p>
			  </div>
			  </c:forEach>
			</div>
			<br>
          <p style="color: red;margin:0 auto">只能上传大小在10M以内的jpg或png格式的图片，请确认后再提交</p>
          
          <div class="mdui-hidden">
          	<input type="text" name="business_number" value="${businessVo.business_number }"/>
          	<input type="text" name="f_service" value="${businessVo.f_service }"/>
          	<input type="text" name="service_number" value="${businessVo.service_number }"/>	
          </div>
          </form>
          <br>
          <input type="radio" name="agree" class="agree" />
          <span>申请人承诺所提交的登记申请材料、申请信息真实、合法、有效，如有不实，由申请人承担一切法律责任。</span>
          <br />
          	<input id="submit" disabled="disabled" type="button" value="提交" class="submit mdui-btn mdui-btn-raised mdui-ripple mdui-color-indigo" style="border-radius:8px;" />
    </div>
  </div>
  <script>
  
  $(function() {
      $('.agree').on('click',function() {
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
	    });
	    
	    //提交按钮点击事件，先提交business表单，再提交Roomrecord
	    $('#submit').on('click',function(){
	    var name=$('#name').val();
	    var phone=document.getElementById("phone").value;
	    var id=document.getElementById("identity").value;
	    var only=document.getElementById("only").value;
	    var build=document.getElementById("build").value;
	    var room=document.getElementById("room").value;
	    var area=document.getElementById("area").value;
	    var sum=document.getElementById("sum").value; 
	    var filenonull = true;
	    var inputs = $("#fileform input[type='file']");
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].value==''
					&&$('#whether'+i).html()=='是') {
				filenonull = false;
				break;
			}
		}
		//alert(filenonull);
	    //if(text1==""&&text2==""&&text3==""&&text5==""&&text6==""&&text7==""&&text8==""&&text9==""){
	    if(a1&&a2&&a3&&a8&&a5&&a6&&a7&&a9&&filenonull){
	    //if(name!=""&&phone!=""&&id!=""&&only!=""&&build!=""&&room!=""&&area!=""&&sum!=""&&filenonull){
	    	//if(name!=null||phone!=null||id!=null||only!=null||build!=null||room!=null||area!=null||sum!=null){
	    	//alert(name);
	    	var jsonData = $("#businessform").serializeObject();  //json对象
	    	
			console.log(jsonData);
			
			//console.log($("input[name='businessVo.applicant_name']").val());
			//一个表单拆两个异步提交两个表单
			$.ajax({
				//dataType : "json",//返回的数据类型
				contentType : "application/json;charset=utf-8",// 发送信息服务器的内容的编码格式
				type : "post",
				url : "ApplyBusiness",
				data:JSON.stringify(jsonData),
				//回调函数
				success : function(data) {
					if(data.msg=='提交成功!'){
						ajaxRoomrecordform();
					}else{
						alert("1error:"+data.msg);
					}
				},
				error : function() {
					//数据发送或接受失败的方法
					alert("o（＾∀＾）o你太逗了");
				}
			});
			}
			else{
				alert("\\(ー_ー\\)!!有东西填错或没填");
			}
	    });
	    
	    //异步提交Roomrecord表单
	    function ajaxRoomrecordform(){
	    	var jsonData = $("#roomrecordform").serializeObject();  //json对象
			console.log(jsonData);
			
			//console.log($("input[name='businessVo.applicant_name']").val());
			//一个表单拆两个异步提交两个表单
			$.ajax({
				//dataType : "json",//返回的数据类型
				contentType : "application/json;charset=utf-8",// 发送信息服务器的内容的编码格式
				type : "post",
				url : "ApplyRoomrecord",
				data:JSON.stringify(jsonData),
				//回调函数
				success : function(data) {
					
					if(data.msg=='提交成功!'){
						$("#fileform").submit();
					}else{
						alert("2error:"+data.msg);
					}
				},
				error : function() {
					//数据发送或接受失败的方法
					alert("o（＾∀＾）o你太逗了");
				}
			});
	    }
	    
	    //序列化JSON
	    $.fn.serializeObject = function(){
		    var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name] !== undefined) {
		            if (!o[this.name].push) {
		                o[this.name] = [o[this.name]];
		            }
		            o[this.name].push(this.value || '');
		        } else {
		            o[this.name] = this.value || '';
		        }
		    });
		    return o;
		};
		
		//当选择的房产项目改变时..
	    $('#housingitem').on("change",function(){
	    	$.ajax({
	    		contentType : "application/json",// 发送信息服务器的内容的编码格式
				type : "get",
				url : "housingitemchange?item_no="+$('#housingitem').val(),
				async : true,// 是否使用异步
				//回调函数
				success : function(data) {
					$("input[name='address']").val(data.address);
				},
				error : function() {
					//数据发送或接受失败的方法
					alert("o（＾∀＾）o你太逗了");
				}
	    	});
	    });
	    //上传文件提示
	    function fileUp(me){
	    	var a = $(me).parent();
	    	var b = $(a).prev();
	    	b.html($(me).val());
	    }
	    
    </script>
  </body>
</html>