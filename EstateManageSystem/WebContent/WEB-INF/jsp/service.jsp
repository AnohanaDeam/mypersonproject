<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html xmlns="http://www.w3.org/1999/xhtml">
  <!-- <html lang="en"> -->
  
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>房产管理系统·后台</title>
    <link rel="stylesheet" href="mdui-v0.4.0/css/mdui.min.css" />
    <link rel="stylesheet" href="css/service.css" />
    <link rel="stylesheet" href="css/table.css" />
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
    <c:if test="${not empty msg }">
      <script type="text/javascript">alert("${msg }");</script></c:if>
    <style type="text/css">.pageJump { float: right; margin: 0; padding: 0; overflow: hidden; border: 0px; text-align: center; }</style></head>
  
  <body class="mdui-theme-primary-indigo mdui-theme-accent-pink mdui-drawer-body-left mdui-appbar-with-toolbar">
    <!-- 头部菜单栏 -->
    <header class="mdui-appbar mdui-appbar-fixed">
      <div class="mdui-toolbar mdui-color-theme">
        <a href="javascript:;" class="mdui-btn mdui-btn-icon" mdui-drawer="{target: '#left-drawer'}">
          <i class="mdui-icon material-icons">menu</i></a>
        <span class="mdui-typo-title">房产管理系统·后台</span>
        <div class="mdui-toolbar-spacer"></div>
        <a href="Admin/logout" class="mdui-btn">注销</a></div>
    </header>
    <!-- 左侧折叠菜单 -->
    <div class="mdui-drawer" id="left-drawer">
      <ul class="mdui-list" mdui-collapse="{accordion: true}" style="max-width: 360px;">
        <a target="pageJump" href="goBackend-home">
          <li class="mdui-list-item mdui-ripple">
            <i class="mdui-list-item-icon mdui-icon material-icons">home</i>
            <div class="mdui-list-item-content">首页</div></li>
        </a>
        <a target="pageJump" href="Admin/acceptance">
          <li class="mdui-list-item mdui-ripple">
            <i class="mdui-list-item-icon mdui-icon material-icons">assignment</i>
            <div class="mdui-list-item-content admissible">受理业务</div></li>
        </a>
        <li class="mdui-collapse-item mdui-collapse-item-open">
          <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
            <i class="mdui-list-item-icon mdui-icon material-icons">people</i>
            <div class="mdui-list-item-content">三审情况</div>
            <i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i></div>
          <ul class="mdui-collapse-item-body mdui-list mdui-list-dense">
            <a target="pageJump" href="Admin/sav?yy=1">
              <li class="mdui-list-item mdui-ripple trial">初审情况</li></a>
            <a target="pageJump" href="Admin/2sav?yy=2">
              <li class="mdui-list-item mdui-ripple examine">审核情况</li></a>
            <a target="pageJump" href="Admin/3sav?yy=3">
              <li class="mdui-list-item mdui-ripple approval">审批情况</li></a>
          </ul>
        </li>
        <!--<li class="mdui-list-item mdui-ripple">
        <i class="mdui-list-item-icon mdui-icon material-icons">view_week</i>
        <div class="mdui-list-item-content">登薄情况</div></li>-->
        <a target="pageJump" href="Admin/goCertificate-new">
          <li class="mdui-list-item mdui-ripple">
            <i class="mdui-list-item-icon mdui-icon material-icons">credit_card</i>
            <div class="mdui-list-item-content certificate">缮证情况</div></li>
        </a>
        <a target="pageJump" href="Admin/file">
          <li class="mdui-list-item mdui-ripple">
            <i class="mdui-list-item-icon mdui-icon material-icons">library_books</i>
            <div class="mdui-list-item-content archives">档案馆</div></li>
        </a>
      </ul>
    </div>
    <!-- 页面跳转 -->
    <iframe name="pageJump" class="pageJump" src="http://localhost:8080/EstateManageSystem/goBackend-home" height="95%" width="87%" style="position: absolute; left: 250px"></iframe>
  </body>

</html>