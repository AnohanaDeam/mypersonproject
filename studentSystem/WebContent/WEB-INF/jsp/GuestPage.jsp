<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<!--================================================================================
	Item Name: Materialize - Material Design Admin Template
	Version: 1.0
	Author: GeeksLabs
	
================================================================================ -->

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="msapplication-tap-highlight" content="no">
  <meta name="description" content="Materialize is a Material Design Admin Template,It's modern, responsive and based on Material Design by Google. ">
  <meta name="keywords" content="materialize, admin template, dashboard template, flat admin template, responsive admin template,">
  <title>学校基本信息</title>

  <!-- Favicons-->
  <link rel="icon" href="images/favicon/favicon-32x32.png" sizes="32x32">
  <!-- Favicons-->
  <link rel="apple-touch-icon-precomposed" href="images/favicon/apple-touch-icon-152x152.png">
  <!-- For iPhone -->
  <meta name="msapplication-TileColor" content="#00bcd4">
  <meta name="msapplication-TileImage" content="images/favicon/mstile-144x144.png">
  <!-- For Windows Phone -->


  <!-- CORE CSS-->
  
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="css/page-center.css" type="text/css" rel="stylesheet" media="screen,projection">


  <!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
  <link href="css/prism.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="js/plugins/perfect-scrollbar/perfect-scrollbar.css" type="text/css" rel="stylesheet" media="screen,projection">
  <style type="text/css">
        #site-layout-example-right {
        background-color: #ffffff;
        height: auto;
      }
  </style>
</head>

<body class="cyan">
 


  <!-- Start Page Loading 
  <div id="loader-wrapper">
      <div id="loader"></div>        
      <div class="loader-section section-left"></div>
      <div class="loader-section section-right"></div>
  </div>
   End Page Loading -->



  <div id="error-page">

    <div class="row">
      <div class="col s12">
        <div class="browser-window">
          <div class="top-bar">
            <div class="circles">
              <div id="close-circle" class="circle"></div>
              <div id="minimize-circle" class="circle"></div>
              <div id="maximize-circle" class="circle"></div>
            </div>
          </div>
          <div class="content">
            <div class="row">
              <div id="site-layout-example-top" class="col s12">
                <p class="flat-text-logo center white-text caption-uppercase">学校总教师数</p>
              </div>
              <div id="site-layout-example-right" class="col s12 m12 l12">
                <div class="row center">
                  <h1 class="text-long-shadow col s12">${Tea_num }</h1>
                  <h1 class="text-long-shadow">- - - - - -</h1>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  
  
  
  <div id="error-page">

    <div class="row">
      <div class="col s12">
        <div class="browser-window">
          <div class="top-bar">
            <div class="circles">
              <div id="close-circle" class="circle"></div>
              <div id="minimize-circle" class="circle"></div>
              <div id="maximize-circle" class="circle"></div>
            </div>
          </div>
          <div class="content">
            <div class="row">
              <div id="site-layout-example-top" class="col s12">
                <p class="flat-text-logo center white-text caption-uppercase">学校总学生数</p>
              </div>
              <div id="site-layout-example-right" class="col s12 m12 l12">
                <div class="row center">
                  <h1 class="text-long-shadow col s12">${Stu_num }</h1>
                  <h1 class="text-long-shadow">- - - - - -</h1>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  
  
  
  
  
  <div id="error-page">
	<div class="row">
      <div class="col s12">
        <div class="browser-window">
          <div class="top-bar">
            <div class="circles">
              <div id="close-circle" class="circle"></div>
              <div id="minimize-circle" class="circle"></div>
              <div id="maximize-circle" class="circle"></div>
            </div>
          </div>
          <div class="content">
            <div class="row">
              <div id="site-layout-example-top" class="col s12">
                <p class="flat-text-logo center white-text caption-uppercase">学院信息</p>
              </div>
              <div id="site-layout-example-right" class="col s12 m12 l12">
                <div class="row center">
                  <table class="hoverable">
                    <thead>
                      <tr>
                        <th data-field="id">学院名</th>
                        <th data-field="name">院长</th>
                        <th data-field="price">共设系</th>
                        <th data-field="price">老师数</th>
                        <th data-field="price">学生数</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                    	<c:choose>
                    	<c:when test="${academyDateEntities=='0' }">
	                    <tr>
	                    	<td>无数据</td>
	                        <td>无数据</td>
	                        <td>无数据</td>
	                        <td>无数据</td>
	                        <td>无数据</td>
	                        <td>无数据</td>
	                    </tr>
                    	</c:when>
                    	<c:otherwise>
                    	<c:forEach items="${academyDateEntities }" varStatus="i" var="item">
                    	<tr>
                    		<td>${item.aca_name }</td>
	                        <td>${item.aca_dean }</td>
	                        <td>${item.depNum }</td>
	                        <td>${item.stuNum }</td>
	                        <td>${item.teaNum }</td>
	                        <td>
	                        <a href="javascript:
	                        location.href='getDepartMentDate?academy='+encodeURI('${item.aca_name }');" 
	                        class="btn waves-effect waves-light">
		                              	查看该学院信息
			                      <i class="mdi-content-send right"></i>
			                </a>
							</td>
						</tr>
                    	</c:forEach>
                    	</c:otherwise>
                    	</c:choose>
                     
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  
  
  <div id="error-page">
	<div class="row">
      <div class="col s12">
        <div class="browser-window">
          <div class="top-bar">
            <div class="circles">
              <div id="close-circle" class="circle"></div>
              <div id="minimize-circle" class="circle"></div>
              <div id="maximize-circle" class="circle"></div>
            </div>
          </div>
          <div class="content">
            <div class="row">
              <div id="site-layout-example-top" class="col s12">
                <p class="flat-text-logo center white-text caption-uppercase">学院信息</p>
              </div>
              <div id="site-layout-example-right" class="col s12 m12 l12">
                <div class="row center">
                  <table class="hoverable">
                    <thead>
                      <tr>
                        <th data-field="id">系名</th>
                        <th data-field="name">系电话</th>
                        <th data-field="price">系学生数</th>
                        <th data-field="price">系老师数</th>
                      </tr>
                    </thead>
                    <tbody>
                    	<c:choose>
                    	<c:when test="${departmentDateEntities=='0' }">
                    	<tr>
	                    	<td>无数据</td>
	                        <td>无数据</td>
	                        <td>无数据</td>
	                        <td>无数据</td>
	                    </tr>
                    	</c:when>
                    	<c:otherwise>
                    	<c:forEach items="${departmentDateEntities }" varStatus="i" var="item">
                    	<tr>
                    		<td>${item.dep_name }</td>
	                        <td>${item.dep_phone }</td>
	                        <td>${item.stuNum }</td>
	                        <td>${item.teaNum }</td>
	                    </tr>
                    	</c:forEach>
                    	</c:otherwise>
                    	</c:choose>
                     
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>


  <!-- ================================================
    Scripts
    ================================================ -->

  <!-- jQuery Library -->
  <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
  <!--materialize js-->
  <script type="text/javascript" src="js/materialize.js"></script>
  <!--prism-->
  <script type="text/javascript" src="js/prism.js"></script>
  <!--scrollbar-->
  <script type="text/javascript" src="js/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>

  <!--plugins.js - Some Specific JS codes for Plugin Settings-->
  <script type="text/javascript" src="js/plugins.js"></script>
  
  <script type="text/javascript">
    function goBack() {
      window.history.back();
    }
  </script>
</body>

</html>
