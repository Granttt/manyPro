<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资源挂载位置管理</title>
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
		<li><a href="${ctx}/sys/sysResourcePosition/">资源挂载位置列表</a></li>
		<li class="active"><a href="${ctx}/sys/sysResourcePosition/form?id=${sysResourcePosition.id}">资源挂载位置<shiro:hasPermission name="sys:sysResourcePosition:edit">${not empty sysResourcePosition.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:sysResourcePosition:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sysResourcePosition" action="${ctx}/sys/sysResourcePosition/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">位置名称：</label>
			<div class="controls">
				<form:input path="positionName" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">位置描述：</label>
			<div class="controls">
				<form:textarea path="positionDesc" htmlEscape="false" rows="4" maxlength="100" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">位置宽度：</label>
			<div class="controls">
				<form:input path="positionWidth" htmlEscape="false" maxlength="10" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">位置高度：</label>
			<div class="controls">
				<form:input path="positionHeight" htmlEscape="false" maxlength="10" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:sysResourcePosition:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>