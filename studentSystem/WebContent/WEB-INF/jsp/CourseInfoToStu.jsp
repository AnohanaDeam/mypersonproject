<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="StuHead.jsp" %>
<!--breadcrumbs start-->
              <div id="breadcrumbs-wrapper" class=" grey lighten-3">
                <div class="container">
                  <div class="row">
                    <div class="col s12 m12 l12">
                      <h5 class="breadcrumbs-title">课程信息</h5>
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
                    <h4 class="header"><br></h4>
                    <div class="row">
                      <div class="col s12 m4 l3">
                        <h4>可选课程</h4>
                        <p></p>
                      </div>
                      <div class="col s12 m8 l9">
                        <table class="hoverable">
                          <thead>
                            <tr>
                              <th data-field="id">课程<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">授课老师<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">学分<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">操作<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                            </tr>
                          </thead>
                          <tbody>
                            
                            <c:choose>
                            	<c:when test="${couStuAbSelects=='0' }">
                            		<tr>
                            			<td>无数据</td>
                            			<td>无数据</td>
                            			<td>无数据</td>
                            			<td>无数据</td>
                            		</tr>
                            	</c:when>
                            	<c:otherwise>
                            		<c:forEach items="${couStuAbSelects }" varStatus="i" var="item">
                            			<tr>
	                            			<td>${item.cou_name }</td>
	                            			<td>${item.tea_name }</td>
	                            			<td>${item.credit }</td>
	                            			<td>
	                            				<a href="SelectCou?cou_id=${item.cou_id }" class="btn waves-effect waves-light">
		                              				选该门课程
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
                    <h4 class="header"><br></h4>
                    <div class="row">
                      <div class="col s12 m4 l3">
                        <h4>可退课程</h4>
                        <p></p>
                      </div>
                      <div class="col s12 m8 l9">
                        <table class="hoverable">
                          <thead>
                            <tr>
                              <th data-field="id">课程<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">授课老师<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">学分<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">操作<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:choose>
                            	<c:when test="${couStuAlSelects=='0' }">
                            		<tr>
                            			<td>无数据</td>
                            			<td>无数据</td>
                            			<td>无数据</td>
                            			<td>无数据</td>
                            		</tr>
                            	</c:when>
                            	<c:otherwise>
                            		<c:forEach items="${couStuAlSelects }" varStatus="i" var="item">
                            			<tr>
	                            			<td>${item.cou_name }</td>
	                            			<td>${item.tea_name }</td>
	                            			<td>${item.credit }</td>
	                            			<td>
	                            				<a href="DropCou?cou_id=${item.cou_id }" class="btn waves-effect waves-light">
		                              				退选该门课程
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
                  <%@include file="StuFoot.jsp" %>
                  
                  
                  
                  
                  