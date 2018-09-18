<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>下载文件管理</title>
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
		<li class="active"><a href="${ctx}/cms/cmsDownload/">下载文件列表</a></li>
		<shiro:hasPermission name="cms:cmsDownload:edit"><li><a href="${ctx}/cms/cmsDownload/form">下载文件添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="cmsDownload" action="${ctx}/cms/cmsDownload/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>下载链接</th>
				<th>排序</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="cms:cmsDownload:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cmsDownload">
			<tr>
				<td><a href="${ctx}/cms/cmsDownload/form?id=${cmsDownload.id}">
					${cmsDownload.name}
				</a></td>
				<td>
					${cmsDownload.name} <a href="${cmsDownload.href}" target="_blank">下载预览</a>
				</td>
				<td>
					${cmsDownload.sort}
				</td>
				<td>
					<fmt:formatDate value="${cmsDownload.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${cmsDownload.remarks}
				</td>
				<shiro:hasPermission name="cms:cmsDownload:edit"><td>
    				<a href="${ctx}/cms/cmsDownload/form?id=${cmsDownload.id}">修改</a>
					<a href="${ctx}/cms/cmsDownload/delete?id=${cmsDownload.id}" onclick="return confirmx('确认要删除该下载文件吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>