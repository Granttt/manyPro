<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>多媒体资源管理</title>
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
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/sysMediaResource/">多媒体资源列表</a></li>
		<li class="active"><a href="${ctx}/sys/sysMediaResource/form?id=${sysMediaResource.id}">多媒体资源<shiro:hasPermission name="sys:sysMediaResource:edit">${not empty sysMediaResource.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:sysMediaResource:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sysMediaResource" action="${ctx}/sys/sysMediaResource/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">资源名称：</label>
			<div class="controls">
				<form:input path="resourcename" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">资源类型：</label>
			<div class="controls">
				<form:select path="resourcetype" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sys_resource_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">资源地址：</label>
			<div class="controls">
				<form:hidden id="nameImage" path="resourceurl" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="nameImage" type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100" maxHeight="100"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">外链地址：</label>
			<div class="controls">
				<form:input path="hrefurl" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">资源描述：</label>
			<div class="controls">
				<form:textarea path="resourcedesc" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:sysMediaResource:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>