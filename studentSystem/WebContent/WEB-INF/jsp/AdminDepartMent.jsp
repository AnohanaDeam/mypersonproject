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
                      <div class="col s12 m8 l9">
                        <table class="hoverable">
                          <thead>
                            <tr>
                              <th data-field="id">系名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">系联系方式<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">所属学院<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price"></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:choose>
                          		<c:when test="${departmentEntities=='0' }">
                          			<tr>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                            </tr>
                          		</c:when>
                          		<c:otherwise>
                          			<c:forEach items="${departmentEntities }" varStatus="i" var="item">
                          				<form action="updateDepartMent" method="post">
                          				<tr>
                          				<td><input name="dep_id" value="${item.dep_id }" type="text"></td>
                          				<td><input name="dep_name" value="${item.dep_name }" type="text"></td>
		                              	<td><input name="dep_phone" value="${item.dep_phone }" type="text"></td>
		                              	<td>
		                              		<div class="input-field">
			                                <select name="academy">
			                                  <option value="${item.academy }" disabled selected>${item.academy }</option>
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
			                                </div>
		                              	</td>
		                              	<td>
		                              		<button class="btn cyan waves-effect waves-light left" type="submit">修改
			                                  <i class="mdi-content-send right"></i>
			                                </button>
							                <a href="javascript:
					                        location.href='deleteDepartMent?dep_id='+encodeURI('${item.dep_id }');" 
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
                        <h4 class="header2">添加系</h4>
                        <div class="row">
                          <form action="increaseDepartment" method="post" class="col s12">
                            <div class="row">
                              <div class="input-field col s6">
                                <input name="dep_id" id="dep_id" type="text">
                                <label for="dep_id">系ID</label>
                              </div>

                              <div class="input-field col s6">
                                <input name="dep_name" id="dep_name" type="text">
                                <label for="dep_name">系名</label>
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
                                <input name="dep_phone" id="dep_phone" type="text">
                                <label for="dep_phone">联系方式</label>
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





