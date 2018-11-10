<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="AdminHead.jsp" %>
<div class="container">
                <div class="section">
                  <!--Hoverable Table-->
                  <div class="divider"></div>
                  <div id="hoverable-table">
                    <h4 class="header">学生信息</h4>
                    <div class="row">
                      <div class="col s12">
                        <table class="hoverable">
                          <thead>
                            <tr>
                              <th data-field="id">学号<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">姓名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">性别<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">班级<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">总学分<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">绩点<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">学院<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">系<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:choose>
                          		<c:when test="${studentEntities=='0' }">
                          			<tr>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                            </tr>
                          		</c:when>
                          		<c:otherwise>
                          			<c:forEach items="${studentEntities }" varStatus="i" var="item">
                          				<form action="updateStudent" method="post">
                          				<tr>
                          				<td>${item.stuid }<input name="stuid" value="${item.stuid }" style="display:none" type="text"></td>
		                              	<td><input name="stu_name" value="${item.stu_name }" type="text"></td>
		                              	<td><input name="sex" value="${item.sex }" type="text"></td>
		                              	<td><input name="classM" value="${item.classM }" type="text"></td>
		                              	<td>${item.totalcredits }<input name="totalcredits" value="${item.totalcredits }" style="display:none" type="text"></td>
		                              	<td>${item.gpa }<input name="gpa" value="${item.gpa }" style="display:none" type="text"></td>
		                              	<td><input name="academy" value="${item.academy }" type="text"></td>
		                              	<td>
		                              		<button class="btn cyan waves-effect waves-light left" type="submit">修改
			                                  <i class="mdi-content-send right"></i>
			                                </button>
							                <a href="javascript:
					                        location.href='deleteStudent?stuid='+encodeURI('${item.stuid }');" 
					                        class="btn waves-effect waves-light">
						                              	删除
							                      <i class="mdi-content-send right"></i>
							                </a>
		                              	</td>
		                              	</tr>
		                              	</form>
                          			</c:forEach>
                          		</c:otherwise>
                          	</c:choose>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                  
                  
                  <!--Form Advance-->
                  <div class="divider"></div>
                  <div class="row" id="addMaters">
                    <div class="col s12 m12 l12">
                      <div class="card-panel">
                        <h4 class="header2">添加学生</h4>
                        <div class="row">
                          <form action="addStudent" method="post" class="col s12">
                            <div class="row">
                              <div class="input-field col s6">
                                <input name="stu_name" id="stu_name" type="text">
                                <label for="stu_name">姓名</label>
                              </div>
                              
                              <div class="input-field col s6">
                                <input name="sex" id="sex" type="text">
                                <label for="sex">性别</label>
                              </div>
                            </div>

                            <div class="row">
                              <div class="input-field col s6">
								<select name="academy">
			                                  <option value="${item.academy }" disabled selected></option>
			                                  <c:choose>
			                                  	<c:when test="${academyEntities=='0' }">
			                                  		<option value="0">暂无学院</option>
			                                  	</c:when>
			                                  	<c:otherwise>
			                                  		<c:forEach items="${academyEntities }" varStatus="i" var="item">
			                                  			<option value="${item.aca_name }">${item.aca_name }</option>
			                                  		</c:forEach>
			                                  	</c:otherwise>
			                                  </c:choose>
			                                </select>
			                                <label>学院</label>
                              </div>
                              <div class="input-field col s6">
                                <select name="department">
			                                  <option disabled selected></option>
			                                  <c:choose>
			                                  	<c:when test="${departmentEntities=='0' }">
			                                  		<option value="0">请先选择学院</option>
			                                  	</c:when>
			                                  	<c:otherwise>
			                                  		<c:forEach items="${departmentEntities }" varStatus="i" var="item">
			                                  			<option value="${item.dep_id }">${item.dep_name }</option>
			                                  		</c:forEach>
			                                  	</c:otherwise>
			                                  </c:choose>
			                                </select>
			                                <label>系</label>
                              </div>
                            </div>
							<div class="row">
                              <div class="input-field col s4">
                                <input name="classM" id="classM" type="text">
                                <label for="classM">班级</label>
                              </div>

                              <div class="input-field col s4">
                                <input name="totalcredits" id="totalcredits" type="text">
                                <label for="totalcredits">总学分</label>
                              </div>
                              
                              <div class="input-field col s4">
                                <input name="gpa" id="gpa" type="text">
                                <label for="gpa">总绩点</label>
                              </div>
                            </div>
                            <div class="row">
                              <div class="input-field col s6">
                                <button class="btn cyan waves-effect waves-light right" type="submit">添加
                                  <i class="mdi-content-send right"></i>
                                </button>
                              </div>
                            </div>

                            <div class="row">
                              <div class="input-field col s12">

                              </div>
                            </div>

                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                  
                </div>
              </div>
<%@include file="AdminFoot.jsp" %>





