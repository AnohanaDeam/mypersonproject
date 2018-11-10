<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="TeaHead.jsp" %>

	<!--breadcrumbs start-->
              <div id="breadcrumbs-wrapper" class=" grey lighten-3">
                <div class="container">
                  <div class="row">
                    <div class="col s12 m12 l12">
                      <h5 class="breadcrumbs-title">我的课程</h5>
                      <span class="header"><br></span>
                    </div>
                  </div>
                </div>
              </div>
              <!--breadcrumbs end-->
              <!--start container-->
              <div class="container">
                <div class="section">
                  <!--Hoverable Table-->
                  <div class="divider"></div>
                  <div id="hoverable-table">
                    <h4 class="header">我教授的课程</h4>
                    <div class="row">
                      <div class="col s12 m4 l3">
                        <h4>课程</h4>
                        <p></p>
                      </div>
                      <div class="col s12 m8 l9">
                        <table class="hoverable">
                          <thead>
                            <tr>
                              <th data-field="id">课程ID<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">课程名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">课程教材<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price"></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:choose>
                          		<c:when test="${vwCoMaToTeaEntities=='0' }">
                          			<tr>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                            </tr>
                          		</c:when>
                          		<c:otherwise>
                          			<c:forEach items="${vwCoMaToTeaEntities }" varStatus="i" var="item">
                          				<tr>
                          				<td>${item.cou_id }</td>
		                              	<td>${item.cou_name }</td>
		                              	<td>${item.book_name }</td>
		                              	<td>
		                              		<form action="showScores" method="post">
		                              		<button class="btn waves-effect waves-light " name="cou_id" type="submit" value="${item.cou_id }">
		                              			查看该门课程成绩
			                                  <i class="mdi-content-send right"></i>
			                                </button>
		                              		</form>
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


                  <!--Hoverable Table-->
                  <div class="divider"></div>
                  <div id="hoverable-table">
                    <div class="row">
                      <div class="col s6 offset-s6">
                      	
                        <div class="input-field col s2">
                         <h4 class="header" style="margin-top: 8px;">分数段:</h4>
                        </div>
                        <form action="SorceSegment" method="post">
                        <div class="input-field col s8">
							<input name="Segment" id="Segment" value="scores>=0 and scores<=100" class="validate" type="text">
                          	<label for="Segment" class="">输入分数段表达式</label>
                          	<input name="cou_id" value="${Course.cou_id }" type="text" style="display:none">
                        </div>
                        <div class="input-field col s2">
                          <button type="submit" class="btn-floating waves-effect waves-light" style="margin-top: 7px;"><i class="mdi-action-done"></i></button>
                        </div>
                        </form>
                      </div>
                    </div>
                    <div class="row">
                        <div class="col s12 m6 l3">
                            <div class="card">
                                <div class="card-content  green white-text">
                                    <p class="card-stats-title"><i class="mdi-action-trending-up"></i>最高分</p>
                                    <h4 class="card-stats-number">${maxscore }<span>分</span></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col s12 m6 l3">
                            <div class="card">
                                <div class="card-content purple white-text">
                                    <p class="card-stats-title"><i class="mdi-action-trending-neutral"></i>平均分</p>
                                    <h4 class="card-stats-number">${avgscore } <span>分</span></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col s12 m6 l3">
                            <div class="card">
                                <div class="card-content blue-grey white-text">
                                    <p class="card-stats-title"><i class="mdi-action-trending-down"></i>最低分</p>
                                    <h4 class="card-stats-number">${minscore } <span>分</span></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col s12 m6 l3">
                            <div class="card">
                                <div class="card-content deep-purple white-text">
                                    <p class="card-stats-title"><i class="mdi-editor-insert-chart"></i>分数段学生</p>
                                    <h4 class="card-stats-number">${bandscore }<span>人</span></h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                      <div class="col s12 m4 l3">
                        <h4>${Course.cou_name }</h4>
                        <p></p>
                      </div>
                      <div class="col s12 m8 l9">
                        <table class="hoverable">
                          <thead>
                            <tr>
                              <th data-field="id">学号<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">姓名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">班级<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">成绩<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:choose>
                            	<c:when test="${vwTeaToScoreEntities=='0' }">
                            		<tr>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                            </tr>
                            	</c:when>
                            	<c:otherwise>
                                	<c:forEach items="${vwTeaToScoreEntities }" varStatus="i" var="item">
                                  		<tr>
			                              <td>${item.stuid }</td>
			                              <td>${item.stu_name }</td>
			                              <td>${item.sclass }</td>
			                              <td>${item.scores }</td>
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

<%@include file="TeaFoot.jsp" %>