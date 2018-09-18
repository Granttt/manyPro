<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>关联管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			
			/*加选项*/
			$("input[name='resourceidcheck']").bind("click",function(){
				 var resourcevalue = "";
				 $("input[name='resourceidcheck']:checked").each(function () {
				 	resourcevalue += this.value+",";
                 });
                 $('#resourceid').val(resourcevalue);
			});
			
			
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
		<li ><a href="${ctx}/sys/sysResourceRelation?positionid=${sysResourceRelation.positionid}">关联列表</a></li>
		<shiro:hasPermission name="sys:sysResourceRelation:edit"><li class="active"><a href="${ctx}/sys/sysResourceRelation/form?positionid=${sysResourceRelation.positionid}">关联添加</a></li></shiro:hasPermission>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sysResourceRelation" action="${ctx}/sys/sysResourceRelation/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="positionid" value="${positionid}"/>
		<form:hidden path="resourceid" value="" id="resourceid"/>
		<sys:message content="${message}"/>		
		<!-- 资源列表开始 -->
		<table id="contentTable" class="table table-striped table-bordered table-condensed" data-click-to-select="true">
			<thead>
				<tr>
					<th>选择</th>
					<th>资源名称</th>
					<th>资源类型</th>
					<th>资源预览</th>
					<th>资源描述</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.list}" var="sysMediaResource">
					<tr>
						<td><input class="boolean optional" name="resourceidcheck" type="checkbox" value="${sysMediaResource.id}"/></td>
						<td><a href="${ctx}/sys/sysMediaResource/form?id=${sysMediaResource.id}">
							${sysMediaResource.resourcename} 
						<td>
							${fns:getDictLabel(sysMediaResource.resourcetype, 'sys_resource_type', '')}
							
						</td>
						<td>
							<c:if test="${sysMediaResource.resourcetype  == 2}">
								<a href="${sysMediaResource.resourceurl}" target="_blank">预览</a>
								<img style="width:20px;height:20px;" src="${sysMediaResource.resourceurl}"></img>
							</c:if>
							<c:if test="${sysMediaResource.resourcetype  == 1}">
								${sysMediaResource.resourceurl}  <a href="${sysMediaResource.resourceurl}" target="_blank">下载预览</a>
							</c:if>
						</td>
						<td>
							${sysMediaResource.resourcedesc}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="pagination">${page}</div>
		<!-- 资源列表结束 -->
		<div class="form-actions">
			<shiro:hasPermission name="sys:sysResourceRelation:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
	
	
	<form:form id="searchForm" modelAttribute="sysResourceRelation" action="${ctx}/sys/sysResourceRelation/form" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input id="positionid" name="positionid" type="hidden" value="${positionid}"/>
	</form:form>
	

</body>
</html>