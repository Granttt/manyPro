<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>图片管理</title>
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
		<li class="active"><a href="${ctx}/cms/cmsSlide/?category.id=${categoryid}">幻灯图片列表</a></li>
		<shiro:hasPermission name="cms:cmsSlide:edit"><li><a href="${ctx}/cms/cmsSlide/form?categoryid=${categoryid}">幻灯图片添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="cmsSlide" action="${ctx}/cms/cmsSlide/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>图片名称：</label>
				<form:input path="imagename" htmlEscape="false" maxlength="500" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>图片名称</th>
				<th>资源url</th>
				<th>类别</th>
				<th>排序</th>
				<th>首页显示</th>
				<th>图片描述</th>
			<!-- 	<th>分类ID</th> -->
				<th>创建时间</th>
				<shiro:hasPermission name="cms:cmsSlide:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cmsSlide">
			<tr>
				<td><a href="${ctx}/cms/cmsSlide/form?id=${cmsSlide.id}&categoryid=${cmsSlide.categoryid}">
					${cmsSlide.imagename}
				</a></td>
				<td>
					<a href="${cmsSlide.imageurl}"><img width="20px" height="20px" src="${cmsSlide.imageurl}"/>&nbsp;&nbsp;预览图片</a>
				</td>
				<td>
					${cmsSlide.imagetitle}
				</td>
				<td>
					${cmsSlide.sort}
				</td>
				<td>
					${fns:getDictLabel(cmsSlide.homeView, 'yes_no', '否')}
				</td>
				<td>
					${cmsSlide.imagedesc}
				</td>
				<%-- <td>
					${cmsSlide.categoryid}
				</td> --%>
				<td>
					<fmt:formatDate value="${cmsSlide.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="cms:cmsSlide:edit"><td>
    				<a href="${ctx}/cms/cmsSlide/form?id=${cmsSlide.id}&categoryid=${cmsSlide.categoryid}">修改</a>
					<a href="${ctx}/cms/cmsSlide/delete?id=${cmsSlide.id}&categoryid=${cmsSlide.categoryid}" onclick="return confirmx('确认要删除该图片吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>