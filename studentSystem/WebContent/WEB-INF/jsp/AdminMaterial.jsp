<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="AdminHead.jsp" %>
<div class="container">
                <div class="section">
                  <!--Hoverable Table-->
                  <div class="divider"></div>
                  <div id="hoverable-table">
                    <h4 class="header">教材信息</h4>
                    <div class="row">
                      <div class="col s12">
                        <table class="hoverable">
                          <thead>
                            <tr>
                              <th data-field="id">ISBN<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">书名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">作者<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">单价<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">出版社<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
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
		                              <td>无数据</td>
		                              <td>无数据</td>
		                            </tr>
                          		</c:when>
                          		<c:otherwise>
                          			<c:forEach items="${materialEntities }" varStatus="i" var="item">
                          				<form action="updateMaterial" method="post">
                          				<tr>
                          				<td><input name="isbn" value="${item.isbn }" type="text"></td>
		                              	<td><input name="book_name" value="${item.book_name }" type="text"></td>
		                              	<td><input name="author" value="${item.author }" type="text"></td>	
										<td><input name="price" value="${item.price }" type="text" disabled></td>
		                              	<td><input name="publishing" value="${item.publishing }" type="text"></td>
		                

		                              	<td>
		                              		<button class="btn cyan waves-effect waves-light left" type="submit">修改
			                                  <i class="mdi-content-send right"></i>
			                                </button>
							                <a href="javascript:
					                        location.href='deleteMaterial?isbn='+encodeURI('${item.isbn }');" 
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
                        <h4 class="header2">添加教材</h4>
                        <div class="row">
                          <form action="addMaterial" method="post" class="col s12">
                            <div class="row">
                              <div class="input-field col s6">
                                <input name="isbn" id="isbn" type="text">
                                <label for="isbn">国际标准书号(IBSN)</label>
                              </div>

                              <div class="input-field col s6">
                                <input name="book_name" id="book_name" type="text">
                                <label for="book_name">书名</label>
                              </div>
                            </div>

                            <div class="row">
                              <div class="input-field col s6">
                                <input name="author" id="author" type="text">
                                <label>作者</label>
                              </div>
                              <div class="input-field col s6">
                                <input name="price" id="price" type="text">
                                <label for="price">单价</label>
                              </div>
                            </div>

                            <div class="row">
                              <div class="input-field col s6">
                                <input name="publishing" id="publishing" type="text">
                                <label>出版社</label>
                              </div>
                              <div class="input-field col s6">
                                <button class="btn cyan waves-effect waves-light right" type="submit">提交
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





