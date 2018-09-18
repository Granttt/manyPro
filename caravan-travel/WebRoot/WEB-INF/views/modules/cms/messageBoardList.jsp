<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>留言内容管理</title>
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
		<li class="active"><a href="${ctx}/cms/messageBoard/">留言内容列表</a></li>
		<%-- <shiro:hasPermission name="cms:messageBoard:edit"><li><a href="${ctx}/cms/messageBoard/form">留言内容添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="messageBoard" action="${ctx}/cms/messageBoard/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>电话：</label>
				<form:input path="phone" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>提交时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${messageBoard.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>电话</th>
				<th>邮箱</th>
				<th>提交时间</th>
				<shiro:hasPermission name="cms:messageBoard:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="messageBoard">
			<tr>
				<td><a href="${ctx}/cms/messageBoard/form?id=${messageBoard.id}">
					${messageBoard.name}
				</a></td>
				<td>
					${messageBoard.phone}
				</td>
				<td>
					${messageBoard.email}
				</td>
				<td>
					<fmt:formatDate value="${messageBoard.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="cms:messageBoard:edit"><td>
    				<a href="${ctx}/cms/messageBoard/form?id=${messageBoard.id}">查看</a>
					<a href="${ctx}/cms/messageBoard/delete?id=${messageBoard.id}" onclick="return confirmx('确认要删除该留言内容吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>