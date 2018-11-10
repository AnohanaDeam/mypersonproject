<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="StuHead.jsp" %>
<!--breadcrumbs start-->
              <div id="breadcrumbs-wrapper" class=" grey lighten-3">
                <div class="container">
                  <div class="row">
                    <div class="col s12 m12 l12">
                      <h5 class="breadcrumbs-title">我的成绩</h5>
                      <span class="header"><br></span>
                    </div>
                  </div>
                </div>
              </div>
              <!--breadcrumbs end-->


        <!--start container-->
              <div class="container">
                <div class="section">

                  <div class="divider"></div>
                  <div id="icon-prefixes" class="section">
                    <div class="row">
                      <div class="col s12 m4 l3">
                        <p></p>
                      </div>
                      <div class="col s12 m8 l9">
                        <div class="row">
                          <form class="col s12">
                            <div class="row">
                              <div class="input-field col s6">
                                <i class="mdi-action-search icon-demo prefix"></i>
                                <input id="icon_prefix3" class="validate" type="text">
                                <label for="icon_prefix3" class="">输入课程检索</label>
                              </div>
                            </div>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>



                  <!--Hoverable Table-->
                  <div class="divider"></div>
                  <div id="hoverable-table">
                    <h4 class="header">我所有课程成绩</h4>
                    <div class="row">
                      <div class="col s12 m4 l3">
                        <h4>平均成绩</h4>
                        <p>${AverageScore }</p>
                      </div>
                      <div class="col s12 m8 l9">
                        <table class="hoverable">
                          <thead>
                            <tr>
                              <th data-field="id">课程<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">成绩<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">排名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:choose>
                            	<c:when test="${studentScoreEntities=='0' }">
                            		<tr>
                            			<td>无数据</td>
                            			<td>无数据</td>
                            			<td>无数据</td>
                            		</tr>
                            	</c:when>
                            	<c:otherwise>
                            		<c:forEach items="${studentScoreEntities}" varStatus="i" var="item">
                            			<tr>
	                            			<td>${item.cou_name }</td>
	                            			<td>${item.score }</td>
	                            			<td>${item.rank }</td>
	                            		</tr>
                            		</c:forEach>
                            	</c:otherwise>
                            </c:choose>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
      <%@include file="StuFoot.jsp" %>
                  
                  
                  
                  
                  