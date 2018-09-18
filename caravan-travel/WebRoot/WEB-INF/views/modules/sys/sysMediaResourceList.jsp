<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>多媒体资源管理</title>
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
		<li class="active"><a href="${ctx}/sys/sysMediaResource/">多媒体资源列表</a></li>
		<shiro:hasPermission name="sys:sysMediaResource:edit"><li><a href="${ctx}/sys/sysMediaResource/form">多媒体资源添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysMediaResource" action="${ctx}/sys/sysMediaResource/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>资源名称：</label>
				<form:input path="resourcename" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>资源类型：</label>
				<form:select path="resourcetype" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sys_resource_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>资源名称</th>
				<th>资源类型</th>
				<th>资源地址</th>
				<th>资源描述</th>
				<th>外链地址</th>
				<th>添加时间</th>
				<shiro:hasPermission name="sys:sysMediaResource:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysMediaResource">
			<tr>
				<td><a href="${ctx}/sys/sysMediaResource/form?id=${sysMediaResource.id}">
					${sysMediaResource.resourcename}
				</a></td>
				<td>
					${fns:getDictLabel(sysMediaResource.resourcetype, 'sys_resource_type', '')}
				</td>
				<td>
					<c:if test="${sysMediaResource.resourcetype == 1 }">
						<a target="_blank" href="${sysMediaResource.resourceurl}">预览视频</a>
					</c:if>
					<c:if test="${sysMediaResource.resourcetype == 2 }">
						<img style="width:20px;height:20px;" src="${sysMediaResource.resourceurl}"/>&nbsp;&nbsp;<a target="_blank" href="${sysMediaResource.resourceurl}">预览图片</a>
					</c:if>
				</td>
				<td>
					${sysMediaResource.resourcedesc}
				</td>
				<td>
					${sysMediaResource.hrefurl}
				</td>
				<td><fmt:formatDate value="${sysMediaResource.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<shiro:hasPermission name="sys:sysMediaResource:edit"><td>
    				<a href="${ctx}/sys/sysMediaResource/form?id=${sysMediaResource.id}">修改</a>
					<a href="${ctx}/sys/sysMediaResource/delete?id=${sysMediaResource.id}" onclick="return confirmx('确认要删除该多媒体资源吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>