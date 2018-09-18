<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>视频管理</title>
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
		<li class="active"><a href="${ctx}/enterprise/bxVideo/">视频列表</a></li>
		<shiro:hasPermission name="enterprise:bxVideo:edit"><li><a href="${ctx}/enterprise/bxVideo/form">视频添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bxVideo" action="${ctx}/enterprise/bxVideo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>视频名称：</label>
				<form:input path="title" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>视频名称</th>
				<th>视频预览图地址</th>
				<th>视频地址</th>
				<th>创建时间</th>
				<shiro:hasPermission name="enterprise:bxVideo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bxVideo">
			<tr>
				<td><a href="${ctx}/enterprise/bxVideo/form?id=${bxVideo.id}">
					${bxVideo.title}
				</a></td>
				<td>
					<img style="width:20px;height:20px;" src="${bxVideo.imageurl}"/>&nbsp;&nbsp;<a target="_blank" href="${bxVideo.imageurl}">预览图片</a>
				</td>
				<td>
					<a target="_blank" href="${bxVideo.vidiourl}">预览视频</a>
				</td>
				<td>
					<fmt:formatDate value="${bxVideo.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="enterprise:bxVideo:edit"><td>
    				<a href="${ctx}/enterprise/bxVideo/form?id=${bxVideo.id}">修改</a>
					<a href="${ctx}/enterprise/bxVideo/delete?id=${bxVideo.id}" onclick="return confirmx('确认要删除该视频吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>