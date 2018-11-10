<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="TeaHead.jsp" %>
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

                            <span class="card-title activator grey-text text-darken-4"><span>姓名——</span>${teacherEntity.tea_name }</span>
                            <p><i class="mdi-image-tag-faces"></i><span>我的职称——</span>${teacherEntity.post }</p>
                            <p><i class="mdi-action-input"></i><span>我的ID——</span>${teacherEntity.tea_id }</p>
                            <p><i class="mdi-action-translate"></i><span>所属系——</span>${departmentEntity.dep_name }</p>

                          </div>
                          <div class="card-reveal" style="display: none; transform: translateY(0px);">
                            <span class="card-title grey-text text-darken-4">你好—${teacherEntity.tea_name }<i class="mdi-navigation-close right"></i></span>
                            <p>这里可以看到更多信息</p>
                            <p><i class="mdi-action-perm-identity"></i><span>姓名——</span>${teacherEntity.tea_name }</p>
                            <p><i class="mdi-image-tag-faces"></i><span>我的职称——</span>${teacherEntity.post }</p>
                            <p><i class="mdi-action-input"></i><span>我的ID——</span>${teacherEntity.tea_id }</p>
                            <p><i class="mdi-action-translate"></i><span>所属系——</span>${departmentEntity.dep_name }</p>
                            <p><i class="mdi-action-account-balance-wallet"></i><span>所属学院——</span>${academyEntity.aca_name }</p>
                            <p><i class="mdi-image-timer-auto"></i><span>所属学院院长——</span>${academyEntity.aca_dean }</p>
                          </div>
                        </div>

                      </div>
                    </div>
                  </div>

                  <!--Hoverable Table-->
                  <div class="divider"></div>
                  <div id="hoverable-table">
                    <h4 class="header">我教授的课程</h4>
                    <div class="row">
                      <div class="col s12 m4 l3">
                        <h4>课程概况</h4>
                        <p></p>
                      </div>
                      <div class="col s12 m8 l9">
                        <table class="hoverable">
                          <thead>
                            <tr>
                              <th data-field="id">课程ID<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">课程名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">学分<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:choose>
                            	<c:when test="${teaToCouEntities=='0' }">
                            		<tr>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                            </tr>
                            	</c:when>
                            	<c:otherwise>
                                	<c:forEach items="${teaToCouEntities }" varStatus="i" var="item">
                                  		<tr>
			                              <td>${item.cou_id }</td>
			                              <td>${item.cou_name }</td>
			                              <td>${item.credit }</td>
			                            </tr>
                                	</c:forEach>
                           		</c:otherwise>
                            </c:choose>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>

                  <!--Hoverable Table-->
                  <div class="divider"></div>
                  <div id="card-stats">
                        <div class="row">
                            <div class="col s12 m6 l3">
                                <div class="card">
                                    <div class="card-content  green white-text">
                                        <p class="card-stats-title"><i class="mdi-social-group-add"></i>我的学生</p>
                                        <h4 class="card-stats-number">${selMyCouCount }</h4>
                                    </div>
                                    <div class="card-action  green darken-2">
                                        <div id="clients-bar"><canvas style="display: inline-block; width: 220px; height: 25px; vertical-align: top;" width="220" height="25"></canvas></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col s12 m6 l3">
                                <div class="card">
                                    <div class="card-content purple white-text">
                                        <p class="card-stats-title"><i class="mdi-editor-insert-chart"></i>我本月工资</p>
                                        <h4 class="card-stats-number">7000</h4>
                                    </div>
                                    <div class="card-action purple darken-2">
                                        <div id="sales-compositebar"><canvas style="display: inline-block; width: 214px; height: 25px; vertical-align: top;" width="214" height="25"></canvas></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col s12 m6 l3">
                                <div class="card">
                                    <div class="card-content deep-purple white-text">
                                        <p class="card-stats-title"><i class="mdi-editor-insert-drive-file"></i>总授课程</p>
                                        <h4 class="card-stats-number">${MyCouCount }</h4>
                                    </div>
                                    <div class="card-action  deep-purple darken-2">
                                        <div id="invoice-line"><canvas style="display: inline-block; width: 359px; height: 25px; vertical-align: top;" width="359" height="25"></canvas></div>
                                    </div>
                                </div>
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
<%@include file="TeaFoot.jsp" %>



