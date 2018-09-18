<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>大事记管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/enterprise/bxDashiji/">大事记列表</a></li>
		<shiro:hasPermission name="enterprise:bxDashiji:edit"><li><a href="${ctx}/enterprise/bxDashiji/form">大事记添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bxDashiji" action="${ctx}/enterprise/bxDashiji/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>概览：</label>
				<form:input path="dsjtitle" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>年份：</label>
				<form:input path="dsjyear" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>概览</th>
				<th>年份</th>
				<th>日期</th>
				<th>图片</th>
				<shiro:hasPermission name="enterprise:bxDashiji:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bxDashiji">
			<tr>
				<td><a href="${ctx}/enterprise/bxDashiji/form?id=${bxDashiji.id}">
					${bxDashiji.dsjtitle}
				</a></td>
				<td>
					${bxDashiji.dsjyear}
				</td>
				<td>
					<fmt:formatDate value="${bxDashiji.dsjdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<c:if test="${not empty bxDashiji.dsjpic}">
					<img style="width:20px;height:20px;" src="${bxDashiji.dsjpic}"/>&nbsp;&nbsp;<a target="_blank" href="${bxDashiji.dsjpic}">预览图片</a>
					</c:if>
				</td>
				<shiro:hasPermission name="enterprise:bxDashiji:edit"><td>
    				<a href="${ctx}/enterprise/bxDashiji/form?id=${bxDashiji.id}">修改</a>
					<a href="${ctx}/enterprise/bxDashiji/delete?id=${bxDashiji.id}" onclick="return confirmx('确认要删除该大事记吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>