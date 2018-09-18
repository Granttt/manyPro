<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>网站常量管理</title>
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
		<li class="active"><a href="${ctx}/sys/sysWebConst/">网站常量列表</a></li>
		<shiro:hasPermission name="sys:sysWebConst:edit"><li><a href="${ctx}/sys/sysWebConst/form">网站常量添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysWebConst" action="${ctx}/sys/sysWebConst/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>常量标识符：</label>
				<form:input path="constuniq" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>常量键：</label>
				<form:input path="constkey" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>常量标识符</th>
				<th>常量键</th>
				<th>常量类型</th>
				<th>常量值</th>
				<shiro:hasPermission name="sys:sysWebConst:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysWebConst">
			<tr>
				<td><a href="${ctx}/sys/sysWebConst/form?id=${sysWebConst.id}">
					${sysWebConst.constuniq}
				</a></td>
				<td>
					${sysWebConst.constkey}
				</td>
				<td>
					${fns:getDictLabel(sysWebConst.keytype, 'const_key_type', '')}
				</td>
				<td>
					<c:choose>
						<c:when test="${sysWebConst.keytype == 'pic' }">
							<a href="${sysWebConst.constvalue}" target="_blank"><img style="height:20px;width:20px;" src="${sysWebConst.constvalue}"/></a>
						</c:when>
						<c:otherwise>
							${sysWebConst.constvalue}
						</c:otherwise>
					</c:choose>
				</td>
				<shiro:hasPermission name="sys:sysWebConst:edit"><td>
    				<a href="${ctx}/sys/sysWebConst/form?id=${sysWebConst.id}">修改</a>
					<a href="${ctx}/sys/sysWebConst/delete?id=${sysWebConst.id}" onclick="return confirmx('确认要删除该网站常量吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>