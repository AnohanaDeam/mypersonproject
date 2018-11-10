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
		                              		<a href="potiutui?cou_id=${item.cou_id }" class="btn waves-effect waves-light">
		                              			查看该门课程成绩
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


                  <!--Hoverable Table-->
                  <div class="divider"></div>
                  <div id="hoverable-table">
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
                              <th data-field="price">操作<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                            </tr>
                          </thead>
                          
                          <tbody>
                          	<c:choose>
                            	<c:when test="${vwTeaToScoreEntities=='0' }">
                            		<tr>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td></td>
		                            </tr>
                            	</c:when>
                            	<c:otherwise>
                                	<c:forEach items="${vwTeaToScoreEntities }" varStatus="i" var="item">
                                	<tr>
				                   		<td>${item.stuid }</td>
				                      	<td>${item.stu_name }</td>
				                       	<td>${item.sclass }</td>
				                   		<td>
						                   	<form action="addScoToStu" method="post">
							     				<input name="stu_id" style="display:none" value="${item.stuid }">
							              		<input name="cou_id" style="display:none" value="${item.cou_id }">
							                    <input name="scores" style="width:auto" value="${item.scores }" id="last_name" type="text" class="validate">
				                                <label for="last_name">分</label>
				                                <button type="Submit" class="btn waves-effect waves-light">
						                              	提交成绩
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
                        </form>
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