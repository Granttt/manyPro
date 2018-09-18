<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>图片管理</title>
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
		<li><a href="${ctx}/cms/cmsSlide/?category.id=${cmsSlide.categoryid}">幻灯图片列表</a></li>
		<li class="active"><a href="${ctx}/cms/cmsSlide/form?id=${cmsSlide.id}">幻灯图片<shiro:hasPermission name="cms:cmsSlide:edit">${not empty cmsSlide.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="cms:cmsSlide:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="cmsSlide" action="${ctx}/cms/cmsSlide/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="categoryid" value="${cmsSlide.categoryid}"/>
		<sys:message content="${message}"/>	
		<div class="control-group">
			<label class="control-label">图片名称：</label>
			<div class="controls">
				<form:input path="imagename" htmlEscape="false" maxlength="500" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">资源地址：</label>
			<div class="controls">
				<form:hidden id="slideImage" path="imageurl" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<sys:ckfinder input="slideImage" type="images" uploadPath="/slide" selectMultiple="false" maxWidth="100" maxHeight="100"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类别：</label>
			<div class="controls">
				<form:input path="imagetitle" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">链接地址：</label>
			<div class="controls">
				<form:input path="imagehref" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序：</label>
			<div class="controls">
				<form:input path="sort" htmlEscape="false" maxlength="10" class="input"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片描述：</label>
			<div class="controls">
				<form:input path="imagedesc" htmlEscape="false"  class="input"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">首页显示：</label>
			<div class="controls">
				<form:radiobuttons path="homeView" items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建时间：</label>
			<div class="controls">
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${cmsSlide.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="cms:cmsSlide:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>