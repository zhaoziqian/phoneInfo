<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=basePath %>static/css/amazeui.min.css" />
		<script src="<%=basePath %>static/js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath %>static/js/amazeui.min.js" type="text/javascript" charset="utf-8"></script>
		<title>手机资讯</title>
	</head>

	<body>
		<div class="am-container">
			<header class="am-header"></header>
			<div class="am-panel">
				<div class="am-panel-hd am-text-center am-text-xl">手机资讯</div>
				<div class="am-panel-bd">
					<table class="am-table am-table-bordered am-table-striped am-table-hover">
						<thead>
							<tr>
								<th>序号</th>
								<th>标题</th>
								<th>回复/查看</th>
								<th>发表时间</th>
								<th>最新回复</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${imformations }" var="imf">
								<tr class="">
									<td>${imf.id }</td>
									<td><a href="detial/${imf.id }">${imf.title }</a></td>
									<td>${imf.replyCount }/${imf.viewCount }</td>
									<td><fmt:formatDate value="${imf.reportTime }" pattern="yyyy-MM-dd"/></td>
									<td><fmt:formatDate value="${imf.lastPostTime }" pattern="yyyy-MM-dd"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<footer class="am-footer"></footer>
		</div>
	</body>

</html>