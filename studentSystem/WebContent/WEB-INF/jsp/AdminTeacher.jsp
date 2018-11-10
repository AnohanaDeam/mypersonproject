<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="AdminHead.jsp" %>
<div class="container">
                <div class="section">
                  <!--Hoverable Table-->
                  <div class="divider"></div>
                  <div id="hoverable-table">
                    <h4 class="header">系信息</h4>
                    <div class="row">
                      <div class="col s12">
                        <table class="hoverable">
                          <thead>
                            <tr>
                              <th data-field="id">教师号<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">姓名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">职称<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">年龄</th>
                              <th data-field="price">聘期</th>
                              <th data-field="price">系</th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:choose>
                          		<c:when test="${teacherEntities=='0' }">
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
                          			<c:forEach items="${teacherEntities }" varStatus="i" var="item">
                          				<form action="updateTeacher" method="post">
                          				<tr>
                          				<td>${item.tea_id }<input name="tea_id" value="${item.tea_id }" type="text" style="display:none"></td>
		                              	<td><input name="tea_name" value="${item.tea_name }" type="text"></td>
		                              	<td><input name="post" value="${item.post }" type="text"></td>
		                              	<td><input name="age" value="${item.age }" type="text"></td>
		                              	<td><input name="employ" value="${item.employ }" type="text"></td>

		                              	<td>
		                              		<button class="btn cyan waves-effect waves-light left" type="submit">修改
			                                  <i class="mdi-content-send right"></i>
			                                </button>
							                <a href="javascript:
					                        location.href='deleteTeacher?tea_id='+encodeURI('${item.tea_id }');" 
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
                        <h4 class="header2">添加教师</h4>
                        <div class="row">
                          <form action="addTeacher" method="post" class="col s12">
                            <div class="row">
                              <div class="input-field col s6">
                                <input name="tea_name" id="tea_name" type="text">
                                <label for="tea_name">姓名</label>
                              </div>
                              
                              <div class="input-field col s6">
                                <input name="post" id="post" type="text">
                                <label for="post">职称</label>
                              </div>
                            </div>

                            <div class="row">
								<div class="input-field">
			                        <select name="department">        
			                              <option value="${item.department }" disabled selected>${item.department }</option>    
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
			                    </div>
                            </div>
							<div class="row">
                              <div class="input-field col s6">
                                <input name="age" id="age" type="text">
                                <label for="age">年龄</label>
                              </div>

                              <div class="input-field col s6">
                                <input name="employ" id="employ" type="text">
                                <label for="employ">聘期</label>
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





