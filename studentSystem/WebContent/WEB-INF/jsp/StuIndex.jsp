<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="StuHead.jsp" %>
			

              <!--breadcrumbs start-->
              <div id="breadcrumbs-wrapper" class=" grey lighten-3">
                <div class="container">
                  <div class="row">
                    <div class="col s12 m12 l12">
                      <h5 class="breadcrumbs-title">我的概况</h5>
                      <span class="header"><br></span>
                    </div>
                  </div>
                </div>
              </div>
              <!--breadcrumbs end-->


        	<!--start container-->
              <div class="container">
                <div class="section">
                
                
                <!-- 教师的基本信息 -->
                  <div class="divider"></div>
                  <div id="accordion-options">

                    <div class="row">
                      <div class="col s12 m4 l3">
                        <h4 class="header"> 我的基本信息</h4>
                        <p><br></p>
                      </div>
                      <div class="col s12 m8 l9">

                        <div id="profile-card" class="card">
                          <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="images/user-bg.jpg" alt="user bg">
                          </div>
                          <div class="card-content">
                            <img src="images/avatar.jpg" alt="" class="circle responsive-img activator card-profile-image">
                            <a class="btn-floating activator btn-move-up waves-effect waves-light darken-2 right">
                              <i class="mdi-editor-mode-edit"></i>
                            </a>

                            <span class="card-title activator grey-text text-darken-4"><span>姓名——</span>${studentEntity.stu_name }</span>
                            <p><i class="mdi-image-tag-faces"></i><span>我的班级——</span>${studentEntity.classM }</p>
                            <p><i class="mdi-action-input"></i><span>我的ID——</span>${studentEntity.stuid }</p>
                            <p><i class="mdi-action-translate"></i><span>所属系——</span>${departmentEntity.dep_name }</p>

                          </div>
                          <div class="card-reveal" style="display: none; transform: translateY(0px);">
                            <span class="card-title grey-text text-darken-4">你好—${studentEntity.stu_name }<i class="mdi-navigation-close right"></i></span>
                            <p>这里可以看到更多信息</p>
                            <p><i class="mdi-action-perm-identity"></i><span>姓名——</span>${studentEntity.stu_name }</p>
                            <p><i class="mdi-image-tag-faces"></i><span>我的班级——</span>${studentEntity.classM }</p>
                            <p><i class="mdi-action-input"></i><span>我的ID——</span>${studentEntity.stuid }</p>
                            <p><i class="mdi-action-translate"></i><span>所属系——</span>${departmentEntity.dep_name }</p>
                            <p><i class="mdi-action-account-balance-wallet"></i><span>所属学院——</span>${studentEntity.academy }</p>
                            <p><i class="mdi-image-timer-auto"></i><span>总学分——</span>${studentEntity.totalcredits }</p>
                            <p><i class="mdi-image-timer-auto"></i><span>绩点——</span>${studentEntity.gpa }</p>
                          </div>
                        </div>

                      </div>
                    </div>
                  </div>
                
                
                
                  <!--Hoverable Table-->
                  <div class="divider"></div>
                  <div id="hoverable-table">
                    <h4 class="header">我的同班同学</h4>
                    <div class="row">
                      <div class="col s12 m4 l3">
                        <h4>你属于</h4>
                        <p>${studentEntity.classM }</p>
                      </div>
                      <div class="col s12 m8 l9">
                        <table class="hoverable">
                          <thead>
                          
                            <tr>
                              <th data-field="id">学号<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">姓名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">性别<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                            </tr>
                          </thead>
                          <tbody>
                          <c:choose>
                          		<c:when test="${studentEntities=='0' }">
                          			<tr>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                            </tr>
                          		</c:when>
                          		<c:otherwise>
                          			<c:forEach items="${studentEntities }" varStatus="i" var="item">
                          				<tr>
                          				<td>${item.stuid }</td>
		                              	<td>${item.stu_name }</td>
		                              	<td>${item.sex }</td>
		                              	</tr>
                          			</c:forEach>
                          		</c:otherwise>
                          	</c:choose>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>

					

                    <div class="divider"></div>
                    <div class="fixed-action-btn">
                        <a class="btn-floating btn-large red">
                          <i class="large mdi-editor-mode-edit"></i>
                        </a>
                        <ul>
                          <li><a class="btn-floating red" style="transform: scaleY(0.4) scaleX(0.4) translateY(40px); opacity: 0;"><i class="large mdi-editor-insert-chart"></i></a>
                          </li>
                          <li><a class="btn-floating yellow darken-1" style="transform: scaleY(0.4) scaleX(0.4) translateY(40px); opacity: 0;"><i class="large mdi-editor-format-quote"></i></a>
                          </li>
                          <li><a class="btn-floating green" style="transform: scaleY(0.4) scaleX(0.4) translateY(40px); opacity: 0;"><i class="large mdi-editor-publish"></i></a>
                          </li>
                          <li><a class="btn-floating blue" style="transform: scaleY(0.4) scaleX(0.4) translateY(40px); opacity: 0;"><i class="large mdi-editor-attach-file"></i></a>
                          </li>
                        </ul>
                    </div>
              </div>
              <!--end container-->
            <%@include file="StuFoot.jsp" %>
            
            
            
            
            
            
            
            