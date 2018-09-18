<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>关联管理</title>
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
		<li class="active"><a href="${ctx}/sys/sysResourceRelation?positionid=${positionid}">关联列表</a></li>
		<shiro:hasPermission name="sys:sysResourceRelation:edit"><li><a href="${ctx}/sys/sysResourceRelation/form?positionid=${positionid}">关联添加</a></li></shiro:hasPermission>
	</ul>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>资源名称</th>
				<th>资源描述</th>
				<th>资源地址</th>
				<th>关联时间</th>
				<shiro:hasPermission name="sys:sysResourceRelation:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysResourceRelation">
			<tr>
				<td>${sysResourceRelation.sysMidiaResource.resourcename}</td>
				<td>${sysResourceRelation.sysMidiaResource.resourcedesc}</td>
				<td>
					<c:if test="${not empty sysResourceRelation.sysMidiaResource.resourceurl}">
						<a href="${sysResourceRelation.sysMidiaResource.resourceurl}" target="blank">预览</a>
						<img style="width:20px;height:20px;" src="${sysResourceRelation.sysMidiaResource.resourceurl}"></img>
					</c:if>
				</td>
				<td>${sysResourceRelation.datetime}</td>
				<shiro:hasPermission name="sys:sysResourceRelation:edit">
					<td>
						<a href="${ctx}/sys/sysResourceRelation/delete?id=${sysResourceRelation.id}&positionid=${positionid}" onclick="return confirmx('确认要删除该关联吗？', this.href)">删除</a>
					</td>
				</shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	
	
	<div class="pagination">${page}</div>
	
	
	<form:form id="searchForm" modelAttribute="sysResourceRelation" action="${ctx}/sys/sysResourceRelation/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	</form:form>
</body>
</html>