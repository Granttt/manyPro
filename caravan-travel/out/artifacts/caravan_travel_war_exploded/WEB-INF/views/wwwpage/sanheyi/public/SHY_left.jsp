<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/wwwpage/sanheyi/public/taglib.jsp"%>
	<%-- <script type="text/javascript" src="${ctxStatic}/hezhengbao/js/jquery.cookie.js">
	</script> --%>
		<div class="about_con_l">
			<p class="a_tit">${fnc:getCategory(categoryid).name}</p>
			<ul class="a_nav">
			<c:forEach items="${fnc:getLeftCategory(child)}" var="category">
				<c:choose>
					<c:when test="${category.id eq child }">
						<li><a href="${ctx}${category.href}" class="a_cur">${category.name}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${ctx}${category.href}">${category.name}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</ul>
		</div>
