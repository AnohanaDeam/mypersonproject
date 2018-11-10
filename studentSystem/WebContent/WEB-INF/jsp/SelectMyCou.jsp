<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="TeaHead.jsp" %>
    <!--breadcrumbs start-->
              <div id="breadcrumbs-wrapper" class=" grey lighten-3">
                <div class="container">
                  <div class="row">
                    <div class="col s12 m12 l12">
                      <h5 class="breadcrumbs-title">选我课的学生</h5>
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
                              <th data-field="id">课程名<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="name">课程ID<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price">课程学生数<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
                              <th data-field="price"></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:choose>
                          		<c:when test="${vwCountOfSTTEntities=='0' }">
                          			<tr>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                              <td>无数据</td>
		                            </tr>
                          		</c:when>
                          		<c:otherwise>
                          			<c:forEach items="${vwCountOfSTTEntities }" varStatus="i" var="item">
                          				<tr>
                          				<td>${item.cou_name }</td>
		                              	<td>${item.cou_id }</td>
		                              	<td>${item.snum }</td>
		                              	<td>
		                              		<form action="selectCouStu" method="post">
		                              		<button class="btn waves-effect waves-light " name="cou_id" type="submit" value="${item.cou_id }">
		                              			查看该门课程学生
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
                      </div>
                    </div>
                  </div>



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
                              <th data-field="price">性别<a class="waves-effect waves-light mdi-hardware-keyboard-arrow-up"></a></th>
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
		                            </tr>
                          		</c:when>
                          		<c:otherwise>
                          			<c:forEach items="${studentEntities }" varStatus="i" var="item">
                          				<tr>
                          				<td>${item.stuid }</td>
		                              	<td>${item.stu_name }</td>
		                              	<td>${item.classM }</td>
		                              	<td>${item.sex }</td>
		                              	</tr>
                          			</c:forEach>
                          		</c:otherwise>
                          	</c:choose>
                          </tbody>
                        </table>
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
	
	
	
	