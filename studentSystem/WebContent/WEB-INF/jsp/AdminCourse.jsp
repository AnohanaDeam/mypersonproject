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
                              <th data-field="id">课程号<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">课程名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">学分<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">教材</th>
                              <th></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:choose>
                          		<c:when test="${courseEntities=='0' }">
                          			<tr>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                            </tr>
                          		</c:when>
                          		<c:otherwise>
                          			<c:forEach items="${courseEntities }" varStatus="i" var="item">
                          				<form action="updateCourse" method="post">
                          				<tr>
                          				<td><input name="cou_id" value="${item.cou_id }" type="text"></td>
		                              	<td><input name="cou_name" value="${item.cou_name }" type="text"></td>
		                              	<td><input name="credit" value="${item.credit }" type="text"></td>	
		                              	<td>
		                              		<div class="input-field">
			                                <select name="materials">
			                                  <option value="${item.materials }" disabled selected>${item.materials }</option>
			                                  <c:choose>
			                                  	<c:when test="${materialEntities=='0' }">
			                                  		<option value="0">暂无教材</option>
			                                  	</c:when>
			                                  	<c:otherwise>
			                                  		<c:forEach items="${materialEntities }" varStatus="i" var="item">
			                                  			<option value="${item.isbn }">${item.book_name }</option>
			                                  		</c:forEach>
			                                  	</c:otherwise>
			                                  </c:choose>
			                                </select>
			                                <label>课程教材</label>
			                                </div>
										</td>
		                              	<td>
		                              		<button class="btn cyan waves-effect waves-light left" type="submit">修改
			                                  <i class="mdi-content-send right"></i>
			                                </button>
							                <a href="javascript:
					                        location.href='deleteCourse?cou_id='+encodeURI('${item.cou_id }');" 
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
                  <!--Form Advance-->
                  <div class="row">
                    <div class="col s12 m12 l12">
                      <div class="card-panel">
                        <h4 class="header2">添加课程</h4>
                        <div class="row">
                          <form action="addCourse" method="post" class="col s12">
                            <div class="row">
                              <div class="input-field col s6">
                                <input name="cou_name" id="cou_name" type="text">
                                <label for="cou_name">课程名称</label>
                              </div>

                              <div class="input-field col s6">
                                <input name="credit" id="credit" type="text">
                                <label for="credit">课程学分</label>
                              </div>
                            </div>

                            <div class="row">
                              <div class="input-field col s6">
                                <select name="materials">
                                  <option value="" disabled selected>选择教材</option>
                                  <c:choose>
                                  	<c:when test="${materialEntities=='0' }">
                                  		<option value="0">暂无教材</option>
                                  	</c:when>
                                  	<c:otherwise>
                                  		<c:forEach items="${materialEntities }" varStatus="i" var="item">
                                  			<option value="${item.isbn }">${item.book_name }</option>
                                  		</c:forEach>
                                  	</c:otherwise>
                                  </c:choose>
                                </select>
                                <label>课程教材</label>
                              </div>
                              <div class="input-field col s6">
                                <input type="text" class="datepicker">
                                <label for="dob">创建时间</label>
                              </div>
                            </div>

                            <div class="row">
                              <div class="input-field col s12">
                                <button class="btn cyan waves-effect waves-light right" type="submit">提交
                                  <i class="mdi-content-send right"></i>
                                </button>
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





