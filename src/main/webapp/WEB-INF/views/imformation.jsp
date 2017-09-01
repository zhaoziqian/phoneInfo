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
		<title>${imformation.title }</title>
	</head>

	<body>
		<div class="am-container">
			<header class="am-header"></header>
			<div id="information">
				<article class="am-article">
					<div class="am-article-hd">
						<h1 class="am-article-title">${imformation.title }</h1>
						<p class="am-article-meta">发表于: <fmt:formatDate value="${imformation.reportTime }" pattern="yyyy-MM-dd"/> </p>
					</div>
					<hr/>
					<div class="am-article-bd">
						<p>
							${imformation.content }
						</p>
					</div>
				</article>
			</div>
			<div>
				<hr class="am-scrollable-horizontal" /><a name="msgTop"></a>
				<p class="am-text-xl">读者回应</p>
				<div id="replies">
					<ul class="am-padding-0" style="list-style: none;">
						<c:forEach items="${replys}" var="r">
							<li>
								<div class="zz-time">发表于:<span class="time"><fmt:formatDate value="${r.replyTime }" pattern="yyyy-MM-dd"/></span></div>
								<div class="zz-text">${r.content }</div>
								<br>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div id="form" style="width: 500px;">
				<span>快速回复(字数200字以内)</span>
				<form action="post" class="am-form">
					<textarea rows="3" maxlength="300"></textarea><span id="message"></span>
						<div class="am-margin-top-xs">
							<a href="#msgTop" type="button" class="am-btn am-btn-xs am-btn-secondary am-margin-right-xs am-disabled">提交</a>
							<a href="${pageContext.request.contextPath }/index">返回首页</a>
						</div>
				</form>
			</div>
			<footer class="am-footer"></footer>
		</div>
		<script type="text/javascript">
			$(function(){
				function clearMsg (){
					$('#message').text("");
				}
				$('#form textarea').blur(function(){
					var content = $('#form textarea').val();
					clearMsg();
					if (content.trim().length <= 0) {
						$('#message').text("请输入回复内容！")
					} else if (content.length > 200) {
						$('#message').text("回复内容过长！！")
					}
				});
				$('#form textarea').change(function(){
					clearMsg();
					var content = $('#form textarea').val();
					if (content.trim().length <= 0) {
						$('#message').text("请输入回复内容！")
					} else if (content.length > 200) {
						$('#message').text("回复内容过长！！")
					}
				});
				$('#form textarea').keydown(function() {
					clearMsg();
					var content = $('#form textarea').val();
					if (content.trim().length <= 0) {
						$('#message').text("请输入回复内容！")
						$('#form a[type="button"]').addClass('am-disabled');
					} else if (content.length > 200) {
						$('#message').text("回复内容过长！！")
						$('#form a[type="button"]').addClass('am-disabled');
					} else {
						$('#form a[type="button"]').removeClass('am-disabled');
						$('#message').text("还可以输入" + (200 - content.length) + "个字")
					}
				});
				$('#form a[type=button]').click(function(){
					var content = $('#form textarea').val();
					$.ajax({
						type: 'post',
						url: '${pageContext.request.contextPath}/newReply',
						dataType: 'json',
						data: {
							'content': content,
							'infoId': '${imformation.id}'
						},
						success: function(xmlq) {
							if (xmlq.msg == "error") {
								alert("信息发送失败");
							} else {

								var item = ""+"<li>"
								  +"<div class='zz-time'> 发表于:<span class='time'>"+ xmlq.replyTime +"</span></div>"
								  +"<div class='zz-text'>"+ xmlq.content +"</div>"
								  +"</li>" + "<br>";
								
								$('#replies ul>li:first').before(item);
								$('#form textarea').val("");
								$('#form a[type="button"]').addClass('am-disabled');
							}
						},
						error: function(xmlq, errq) {
							//alert(errq);
						}
					});
				});
			});
		</script>
	</body>

</html>