<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
	<link rel="stylesheet" href="./mdui-v0.4.0/css/mdui.min.css"/>
	<link rel="stylesheet" href="./css/service.css" />
	<link rel="stylesheet" href="./css/table.css" />
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<div class="mdui-container doc-container">
		<!--<h1 class="doc-title mdui-text-color-theme">档案查询</h1>
		<div class="mdui-row mdui-row-gapless mdui-text-center">
			搜索类型:
			<select class="mdui-select" mdui-select="options">
			    <option value="1">产权人</option>
			    <option value="2">业务受理号</option>
			    <option value="3">业务类型</option>
			</select>
			<input type="text" name="searchType">
			<input class="mdui-btn" type="submit" value="搜索">
		</div>-->
		<div class="doc-top">
  			<h1 class="doc-title mdui-text-color-theme head-title mdui-text-color-teal-500">档案查询</h1>
	  		<div class="search mdui-hoverable">
	  			<input type="text" name="search-input" class="search-input" value="" />
	  			<button class="search-button">
	  				<i class="mdui-icon material-icons search-ico">&#xe8b6;</i>
	  			</button>
	  			<!--<a href="#" style="color: #757575">
	  				<i class="mdui-icon material-icons search-ico">&#xe8b6;</i>
	  			</a>-->
	  		</div>
	  		<div class="select-box">
  				<span>搜索类型：</span>
  				<select class="mdui-select" mdui-select="{position: 'bottom'}" style="text-align: center">
  					<option value="holder">产权人</option>
				    <option value="adNum">业务受理号</option>
				    <option value="busNum">业务类型</option>
  				</select>
  			</div>
  		</div>
  		<!--
  			class="mdui-row mdui-row-gapless mdui-hoverable mdui-typo"
  		-->
		<div class="mdui-table-fluid mdui-hoverable mdui-typo doc-content">
			<table class="mdui-table mdui-table-hoverable" style="margin-bottom: 0px;">
				<thead>
				<tr>
					<th class="mdui-text-center">业务受理号</th>
					<th class="mdui-text-center">业务类型</th>
					<th class="mdui-text-center">产权人</th>
					<th class="mdui-text-center">档案存放位置</th>
					<th class="mdui-text-center">房产地址</th>
					<th class="mdui-text-center">密级</th>
					<th class="mdui-text-center">归档日期</th>
				</tr>
				</thead>
      			<tbody>
				<tr>
					<td class="mdui-text-center">DM20180312151756</td>
					<td class="mdui-text-center">商品房初始登记</td>
					<td class="mdui-text-center">王小明</td>
					<td class="mdui-text-center">档案室4-12号</td>
					<td class="mdui-text-center">C级</td>
					<td class="mdui-text-center">北京朝阳区.......</td>
					<td class="mdui-text-center">2018.3.12-20:17:56</td>
					<td class="mdui-text-center"><a href="Material.html">查看材料</a></td>
				</tr>
				<tr>
					<td class="mdui-text-center">DM20180312151756</td>
					<td class="mdui-text-center">商品房初始登记</td>
					<td class="mdui-text-center">王小明</td>
					<td class="mdui-text-center">档案室4-12号</td>
					<td class="mdui-text-center">C级</td>
					<td class="mdui-text-center">北京朝阳区.......</td>
					<td class="mdui-text-center">2018.3.12-20:17:56</td>
					<td class="mdui-text-center"><a href="Material.html">查看材料</a></td>
				</tr>
				<tr>
					<td class="mdui-text-center">DM20180312151756</td>
					<td class="mdui-text-center">商品房初始登记</td>
					<td class="mdui-text-center">王小明</td>
					<td class="mdui-text-center">档案室4-12号</td>
					<td class="mdui-text-center">C级</td>
					<td class="mdui-text-center">北京朝阳区.......</td>
					<td class="mdui-text-center">2018.3.12-20:17:56</td>
					<td class="mdui-text-center"><a href="Material.html">查看材料</a></td>
				</tr>
				<tr>
					<td class="mdui-text-center">DM20180312151756</td>
					<td class="mdui-text-center">商品房初始登记</td>
					<td class="mdui-text-center">王小明</td>
					<td class="mdui-text-center">档案室4-12号</td>
					<td class="mdui-text-center">C级</td>
					<td class="mdui-text-center">北京朝阳区.......</td>
					<td class="mdui-text-center">2018.3.12-20:17:56</td>
					<td class="mdui-text-center"><a href="Material.html">查看材料</a></td>
				</tr>
				<tr>
					<td class="mdui-text-center">DM20180312151756</td>
					<td class="mdui-text-center">商品房初始登记</td>
					<td class="mdui-text-center">王小明</td>
					<td class="mdui-text-center">档案室4-12号</td>
					<td class="mdui-text-center">C级</td>
					<td class="mdui-text-center">北京朝阳区.......</td>
					<td class="mdui-text-center">2018.3.12-20:17:56</td>
					<td class="mdui-text-center"><a href="Material.html">查看材料</a></td>
				</tr>
				</tbody>
			</table>
			<div class="mdui-text-center">
	        	<div class="mdui-btn-group">
	        		<button type="button" class="mdui-btn mdui-hidden">
						<i class="mdui-icon material-icons">chevron_left</i>
				    </button>
				    <button type="button" class="mdui-btn mdui-btn-active">1</button>
				    <button type="button" class="mdui-btn">2</button>
				    <button type="button" class="mdui-btn">3</button>
				    <button type="button" class="mdui-btn">4</button>
				    <button type="button" class="mdui-btn">...</button>
				    <button type="button" class="mdui-btn">
						<i class="mdui-icon material-icons">chevron_right</i>
				    </button>
				</div>
	        </div>
		</div>
		
	</div>

  	<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="../mdui-v0.4.0/js/mdui.min.js" type="text/javascript"></script>
  	<script src="https://cdn.bootcss.com/holder/2.9.4/holder.min.js"></script>
</html>