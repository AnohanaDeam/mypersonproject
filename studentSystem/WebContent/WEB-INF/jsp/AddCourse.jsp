<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="TeaHead.jsp" %>
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
                  <!--Hoverable Table-->


                  <!--Form Advance-->
                  <div class="row">
                    <div class="col s12 m12 l12">
                      <div class="card-panel">
                        <h4 class="header2">添加课程</h4>
                        <div class="row">
                          <form action="increaseCourse" method="post" class="col s12">
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
                                  	<c:when test="${Materials=='暂无教材' }">
                                  		<option value="0">暂无教材</option>
                                  	</c:when>
                                  	<c:otherwise>
                                  		<c:forEach items="${Materials }" varStatus="i" var="item">
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
                              <div class="input-field col s6">
                                <span>没有你想要的教材?</span>
                                <a id="addbooks" class="waves-effect waves-light btn"><i class="mdi-av-my-library-books"></i>点击添加教材</a>
                              </div>
                              <div class="input-field col s6">
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



                  <!--Form Advance-->
                  <div class="row" id="addMaters" style="display:none">
                    <div class="col s12 m12 l12">
                      <div class="card-panel">
                        <h4 class="header2">添加教材</h4>
                        <div class="row">
                          <form action="increaseMaterial" method="post" class="col s12">
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




