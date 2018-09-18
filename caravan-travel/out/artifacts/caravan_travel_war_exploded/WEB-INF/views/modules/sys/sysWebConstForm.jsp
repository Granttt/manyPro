<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>网站常量管理</title>
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
		<li><a href="${ctx}/sys/sysWebConst/">网站常量列表</a></li>
		<li class="active"><a href="${ctx}/sys/sysWebConst/form?id=${sysWebConst.id}">网站常量<shiro:hasPermission name="sys:sysWebConst:edit">${not empty sysWebConst.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:sysWebConst:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sysWebConst" action="${ctx}/sys/sysWebConst/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">常量标识符：</label>
			<div class="controls">
				<form:input path="constuniq" htmlEscape="false" maxlength="20" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">常量键：</label>
			<div class="controls">
				<form:input path="constkey" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">常量类型：</label>
			<div class="controls">
				<form:select path="keytype" class="input-xlarge " onchange="changeOption();">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('const_key_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">常量值：</label>
			<div class="controls">
				<c:choose>
					<c:when test="${sysWebConst.keytype == 'pic' }">
						<form:hidden id="nameImage" path="constvalue" htmlEscape="false" maxlength="500" class="input-xlarge"/>
						<sys:ckfinder input="nameImage" type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100" maxHeight="100"/>
					</c:when>
					<c:otherwise>
						<form:input path="constvalue" htmlEscape="false" maxlength="500" class="input-xlarge "/>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">常量备注：</label>
			<div class="controls">
				<form:textarea path="constmark" htmlEscape="false" rows="4" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:sysWebConst:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>