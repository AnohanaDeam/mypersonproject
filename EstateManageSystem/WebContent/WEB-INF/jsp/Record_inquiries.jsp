<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>房产管理系统·后台</title>
	<link rel="stylesheet" href="../mdui-v0.4.0/css/mdui.min.css"/>
</head>
<body class="mdui-theme-primary-teal mdui-theme-accent-pink mdui-drawer-body-left mdui-appbar-with-toolbar">
  	<!-- 头部菜单栏 -->
	<header class="mdui-appbar mdui-appbar-fixed">
		<div class="mdui-toolbar mdui-color-theme">
	    <a href="javascript:;" class="mdui-btn mdui-btn-icon" mdui-drawer="{target: '#left-drawer'}">
	    	<i class="mdui-icon material-icons">menu</i></a>
	    <span class="mdui-typo-title">房产管理系统·后台</span>
	    <div class="mdui-toolbar-spacer"></div>
	    <a href="javascript:;" class="mdui-btn mdui-btn-icon"><i class="mdui-icon material-icons">search</i></a>
	    <a href="javascript:;" class="mdui-btn mdui-btn-icon"><i class="mdui-icon material-icons">refresh</i></a>
	    <a href="javascript:;" class="mdui-btn mdui-btn-icon"><i class="mdui-icon material-icons">more_vert</i></a>
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
		        <li class="mdui-list-item mdui-ripple">初审情况</li>
		        <li class="mdui-list-item mdui-ripple">审核情况</li>
		        <li class="mdui-list-item mdui-ripple">审批情况</li>
		      </ul>
		    </li>
		    <li class="mdui-list-item mdui-ripple">
		      <i class="mdui-list-item-icon mdui-icon material-icons">view_week</i>
		      <div class="mdui-list-item-content">登薄情况</div>
		    </li>
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

	<div class="mdui-container doc-container">
		<h1 class="doc-title mdui-text-color-theme">备案查询</h1>
		<div class="mdui-row mdui-row-gapless mdui-text-center">
			搜索类型:
			<select class="mdui-select" mdui-select="options">
			    <option value="1">买受人</option>
			    <option value="2">业务受理号</option>
			    <option value="3">面积</option>
			</select>
			<input type="text" name="searchType">
			<input class="mdui-btn" type="submit" value="搜索">
		</div>
		<div class="mdui-panel" mdui-panel>
			<div class="mdui-panel-item">
		      <div class="mdui-panel-item-header">
		        <div class="mdui-panel-item-title">业务受理号:<span>DM20180312151756</span></div>
		        <div class="mdui-panel-item-title">买受人:<span>王小明</span></div>
		        <div class="mdui-panel-item-title">签约时间:<span>2018.3.12-20:17:56</span></div>
		        <i class="mdui-panel-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
		      </div>
		      <div class="mdui-panel-item-body">
		        <p>备案表表格..........</p>
		      </div>
		    </div>
		</div>
		<div class="mdui-panel" mdui-panel>
			<div class="mdui-panel-item">
		      <div class="mdui-panel-item-header">
		        <div class="mdui-panel-item-title">业务受理号:<span>DM20180312151756</span></div>
		        <div class="mdui-panel-item-title">买受人:<span>王小明</span></div>
		        <div class="mdui-panel-item-title">签约时间:<span>2018.3.12-20:17:56</span></div>
		        <i class="mdui-panel-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
		      </div>
		      <div class="mdui-panel-item-body">
		        <p>备案表表格..........</p>
		      </div>
		    </div>
		</div>
		<div class="mdui-panel" mdui-panel>
			<div class="mdui-panel-item">
		      <div class="mdui-panel-item-header">
		        <div class="mdui-panel-item-title">业务受理号:<span>DM20180312151756</span></div>
		        <div class="mdui-panel-item-title">买受人:<span>王小明</span></div>
		        <div class="mdui-panel-item-title">签约时间:<span>2018.3.12-20:17:56</span></div>
		        <i class="mdui-panel-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
		      </div>
		      <div class="mdui-panel-item-body">
		        <p>备案表表格..........</p>
		      </div>
		    </div>
		</div>
		<div class="mdui-panel" mdui-panel>
			<div class="mdui-panel-item">
		      <div class="mdui-panel-item-header">
		        <div class="mdui-panel-item-title">业务受理号:<span>DM20180312151756</span></div>
		        <div class="mdui-panel-item-title">买受人:<span>王小明</span></div>
		        <div class="mdui-panel-item-title">签约时间:<span>2018.3.12-20:17:56</span></div>
		        <i class="mdui-panel-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
		      </div>
		      <div class="mdui-panel-item-body">
		        <p>备案表表格..........</p>
		      </div>
		    </div>
		</div>
	</div>

  	<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="../mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
  	<script src="https://cdn.bootcss.com/holder/2.9.4/holder.min.js"></script>
  	<script type="text/javascript">
	$(document).ready(function(){
	    $("div.mdui-list-item-content").click(function(){
		      var t = $(this).text();
		      switch(t){
		        case "受理业务":
		        self.location='service.html';
		        break;
		     	}
	   		});
	    });
  		</script>
	</body>	
</html>