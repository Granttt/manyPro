<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>视频管理</title>
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
			
			var file=$("#nameV");
			
 			if($.trim(file.val())==''){
        	  return false;

               }
			
		});
		
		
		
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/enterprise/bxVideo/">视频列表</a></li>
		<li class="active"><a href="${ctx}/enterprise/bxVideo/form?id=${bxVideo.id}">视频<shiro:hasPermission name="enterprise:bxVideo:edit">${not empty bxVideo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="enterprise:bxVideo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="bxVideo" action="${ctx}/enterprise/bxVideo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">视频名称：</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">视频预览图地址：</label>
			<div class="controls">
				<form:hidden id="nameImage" path="imageurl" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="nameImage" type="images" uploadPath="/videothumb" selectMultiple="false" maxWidth="100" maxHeight="100"/>
			</div>
			
		</div>
		<div class="control-group">
			<label class="control-label">视频地址：</label>
			<div class="controls">
				<span id="nameref">请添加 swf,wmv,asf,wma,mp3,asx,mid,midi,rm,ra,rmvb,mp4,mov,avi,wav,ram,mpg,mpeg,flv格式的文件</span>
				<form:hidden id="nameV" path="vidiourl" htmlEscape="false" maxlength="255" class="input-xlarge"	title="请添加MP4格式的文件"	/>
				<sys:ckfinder input="nameV" type="video" uploadPath="/video" selectMultiple="false" maxWidth="100" maxHeight="100" />
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">视频说明：</label>
			<div class="controls">
				<form:textarea id="content" htmlEscape="true" path="mark" rows="4" maxlength="200" class="input-xxlarge"/>
				<sys:ckeditor replace="content" uploadPath="/video/content" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建时间：</label>
			<div class="controls">
				<input name="createtime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${bxVideo.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="enterprise:bxVideo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>