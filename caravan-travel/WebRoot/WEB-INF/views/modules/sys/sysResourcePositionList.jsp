<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资源挂载位置管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s,d){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
        
        function viewRelation(positionid) {
			top.$.jBox.open("iframe:${ctx}/sys/sysResourceRelation?pageSize=8&positionid="+positionid, "关联资源",$(top.document).width()-220,$(top.document).height()-180,{
				buttons:{"确定":true}, loaded:function(h){
					$(".jbox-content", top.document).css("overflow-y","hidden");
				}
			});
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/sysResourcePosition/">资源挂载位置列表</a></li>
		<shiro:hasPermission name="sys:sysResourcePosition:edit"><li><a href="${ctx}/sys/sysResourcePosition/form">资源挂载位置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysResourcePosition" action="${ctx}/sys/sysResourcePosition/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>位置名称：</label>
				<form:input path="positionName" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>位置名称</th>
				<th>位置描述</th>
				<th>位置宽度</th>
				<th>位置高度</th>
				<shiro:hasPermission name="sys:sysResourcePosition:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysResourcePosition">
			<tr>
				<td><a href="${ctx}/sys/sysResourcePosition/form?id=${sysResourcePosition.id}">
					${sysResourcePosition.positionName}
				</a></td>
				<td>
					${sysResourcePosition.positionDesc}
				</td>
				<td>
					${sysResourcePosition.positionWidth}
				</td>
				<td>
					${sysResourcePosition.positionHeight}
				</td>
				<shiro:hasPermission name="sys:sysResourcePosition:edit"><td>
    				<a href="${ctx}/sys/sysResourcePosition/form?id=${sysResourcePosition.id}">修改</a>
					<a href="${ctx}/sys/sysResourcePosition/delete?id=${sysResourcePosition.id}" onclick="return confirmx('确认要删除该资源挂载位置吗？', this.href)">删除</a>
					<a href="javascript:viewRelation('${sysResourcePosition.id}')">查看关联</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>