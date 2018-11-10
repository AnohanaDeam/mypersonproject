<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="AdminHead.jsp" %>
<div class="container">
                <div class="section">
                  <!--Hoverable Table-->
                  <div class="divider"></div>
                  <div id="hoverable-table">
                    <h4 class="header">学院信息</h4>
                    <div class="row">
                      <div class="col s12 m8 l9">
                        <table class="hoverable">
                          <thead>
                            <tr>
                              <th data-field="id">学院名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">院长<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">性别<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price"></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:choose>
                          		<c:when test="${academyEntities=='0' }">
                          			<tr>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                            </tr>
                          		</c:when>
                          		<c:otherwise>
                          			<c:forEach items="${academyEntities }" varStatus="i" var="item">
                          				<form action="updateacademy" method="post">
                          				<tr>
                          				<td><input name="aca_name" value="${item.aca_name }" type="text"></td>
		                              	<td><input name="aca_dean" value="${item.aca_dean }" type="text"></td>
		                              	<td><input name="deansex" value="${item.deansex }" type="text"></td>
		                              	<td>
		                              		<button class="btn cyan waves-effect waves-light left" type="submit">修改
			                                  <i class="mdi-content-send right"></i>
			                                </button>
							                <a href="javascript:
					                        location.href='deleteacademy?aca_name='+encodeURI('${item.aca_name }');" 
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
                  <div class="row" id="addMaters" style="display:none">
                    <div class="col s12 m12 l12">
                      <div class="card-panel">
                        <h4 class="header2">添加学院</h4>
                        <div class="row">
                          <form action="increaseAcademy" method="post" class="col s12">
                            <div class="row">
                              <div class="input-field col s6">
                                <input name="aca_name" id="aca_name" type="text">
                                <label for="aca_name">学院名</label>
                              </div>

                              <div class="input-field col s6">
                                <input name="aca_dean" id="aca_dean" type="text">
                                <label for="aca_dean">院长</label>
                              </div>
                            </div>

                            <div class="row">
                              <div class="input-field col s6">
                                <p>
			                      <input name="deansex" type="radio" value="男" id="man" />
			                      <label for="man">男</label>
			                    </p>
			                    <p>
			                      <input name="deansex" type="radio" value="女" id="woman" />
			                      <label for="woman">女</label>
			                    </p>
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





