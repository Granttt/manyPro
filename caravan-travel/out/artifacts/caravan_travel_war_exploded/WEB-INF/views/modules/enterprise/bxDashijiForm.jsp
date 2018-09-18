<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>大事记管理</title>
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
		<li><a href="${ctx}/enterprise/bxDashiji/">大事记列表</a></li>
		<li class="active"><a href="${ctx}/enterprise/bxDashiji/form?id=${bxDashiji.id}">大事记<shiro:hasPermission name="enterprise:bxDashiji:edit">${not empty bxDashiji.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="enterprise:bxDashiji:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="bxDashiji" action="${ctx}/enterprise/bxDashiji/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">概览：</label>
			<div class="controls">
				<form:input path="dsjtitle" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">年份：</label>
			<div class="controls">
				<form:input path="dsjyear" htmlEscape="false" maxlength="11" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">日期：</label>
			<div class="controls">
				<input name="dsjdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${bxDashiji.dsjdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片：</label>
			<div class="controls">
				<form:hidden id="dsjImage" path="dsjpic" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="dsjImage" type="images" uploadPath="/dsjphoto" selectMultiple="false" maxWidth="100" maxHeight="100"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">内容：</label>
			<div class="controls">
				<form:textarea id="content" htmlEscape="true" path="dsjcontent" rows="4" maxlength="200" class="input-xxlarge"/>
				<sys:ckeditor replace="content" uploadPath="/beixindsj/article" />
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="enterprise:bxDashiji:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>