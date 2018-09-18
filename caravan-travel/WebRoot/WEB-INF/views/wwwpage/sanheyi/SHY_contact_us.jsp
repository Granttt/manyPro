<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/wwwpage/sanheyi/public/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!--声明当前页面的编码集GBK，gb2312(中文编码)，UTF-8(国际编码)-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--Edge 模式告诉 IE 以最高级模式渲染文档  chrome=1 强制 IE 使用 Chrome Frame 渲染-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!--content的取值为webkit，ie-comp，ie-stand之一，区分大小写，分别代表用极速模式，兼容模式，IE模式打开-->
<meta name="renderer" content="webkit|ie-comp|ie-stand" />
<meta name="" content="" />
<!--当前网页的三要素-->
<title>SHY-关于我们--联系我们</title>
<link rel="shortcut icon" type="text/css" href="${ctxStatic}/sanheyi/images/ll.ico" />
<link rel="stylesheet" type="text/css" href="${ctxStatic}/sanheyi/css/public.css"/><!--公用css，头部和底部及二级页面样式-->
<link rel="stylesheet" href="${ctxStatic}/sanheyi/css/style.css" /><!--各个页面css样式-->
<link rel="stylesheet" type="text/css" href="${ctxStatic}/sanheyi/css/reset.css"/><!--公用css，头部和底部及二级页面样式-->
<script type="text/javascript" src="${ctxStatic}/sanheyi/js/jquery-1.9.1.js"></script><!--公用jQuery-->
<script type="text/javascript" src="${ctxStatic}/sanheyi/js/bdMap.js"></script><!-- 地图 -->
</head>
<body id="body">
<%@include file="../sanheyi/public/MSV_header.jsp" %>
<!-- banner -->
<div class="er_banner" style="background: url(${imageUrl}) center center no-repeat; height:300px;"></div>
<!-- banner end-->
<script>
$(function() {               /*弹出层2*/
    $(".alert1 b,.confirm").click(function(){
        $(this).parent(".alert1").css("display","none");
        $(this).parent(".alert1").parent(".alert_bg1").height(0).width(0);
        $(".contact_in input,textarea").val("");

    });
});
function liuyan(){
	var lname =$("#lname").val()
 	var email =$("#email").val()
	var phone =$("#phone").val()
 	var saytext =$("#saytext").val()
	 if(lname == ""  || lname.match(/^[ ]*$/)){//判断空格
	     alert("姓名不能为空");
	     return false;
	   }
	 if(phone == ""  || phone.match(/^[ ]*$/)){//判断空格
	     alert("电话不能为空");
	     return false;
	   }else if(!(/^1(3|4|5|7|8)\d{9}$/.test(phone)) && !/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(phone)){
	   alert("电话格式不正确")
	    return false;
	   } 
	   if(saytext == ""  || saytext.match(/^[ ]*$/)){//判断空格
	     alert("留言内容不能空");
	     return false;
	   }
 $.ajax({
		type:"POST",
		url:"${ctx }/messageBoard.html",
		dataType:"json",
		data:{lname:lname,email:email,phone:phone,saytext:saytext},
		success:function(data){
			if(data.status=='200'){
   		 	   	 $(".btn_w").siblings('.alert_bg1').height($("body").height());
			     $(".btn_w").siblings('.alert_bg1').width($("body").width());
			     $(".btn_w").siblings('.alert_bg1').children('.alert1').show();
    		    /* window.location.reload(); */
    		 }else{
    		    	alert("保存失败");
    	 	}
		},
		error:function(data){
		alert("提交失败");}
	});

}
</script>
<div class="about_con">
	<div class="about_con_l">
		<p class="a_tit">${fnc:getCategory('18').name}</p>
		<ul class="a_nav">
			<li><a href="#" class="a_cur">${fnc:getCategory('18').name}</a></li>
		</ul>
	</div>
	<div class="about_con_r">
		<div class="about_r_tit">
			<span  class="about_tit">${fnc:getCategory('18').name}</span>
		</div>
		<div class="about_t">
			<div class="map">
			
			<%-- <img src="${ctxStatic}/sanheyi/images/map.png" height="290" width="928" alt="" /> --%>
			<div id="map" style="height:290px;width:928px;border:1px solid #bcbcbc;margin: 0 auto;"></div>
					<script type="text/javascript">ShowMap("map",{city:'北京市',addr:'北京市朝阳区十里堡住邦2000商务楼1号楼',title:'',lawfirm:'',tel:'',mapx:'',pic:'',ismove:'0',piobj:'nxp'});</script>
					<br/><br/>
					
					<script>
					function setAdd(v){
						document.getElementById("show").innerHTML = v;
					}
					getBDAddress(setAdd);// 根据浏览器获取地址
					</script>
					演示：<span id="show"></span>
			</div>
			<div class="contact_con">
				<div class="contact_l">
					${fnc:getArticleAllInfo('18').articleData.content}
				</div>
				<div class="contact_r">
					<p class="contact_tit2">给我们留言<span class="leave">LEAVE A MESSAGE</span></p>
					<div class="contact_in">
					<form id="searchForm" action="${ctx}/projectlist/${child}" method="post">
						<div class="con_input">
							<input type="text" id="lname" class="c_input1" placeholder="姓名" />
							<input type="text" id="email" class="c_input2" placeholder="邮箱"/>
							<input type="text" id="phone" class="c_input2" placeholder="电话"/>
						</div>
						<textarea  style="resize:vertical" name="" id="saytext" class="textarea_w" placeholder="内容"></textarea>
					</form>
						<a href="javascript:liuyan();" class="btn_w">提交</a>
	                         <div class="alert_bg1">
	                             <div class="alert1">
	                                 <p class="coation">温馨提示</p>
	                                 <p class="btn_success">提交成功</p>
	                                 <a href="javascript:void(0);" class="confirm">确  认</a>
	                                 <b></b>
	                             </div>
	                         </div>
	                         <!-- <div class="alert_bg1">
	                             <div class="alert1">
	                                 <p class="coation">温馨提示</p>
	                                 <p class="btn_fail">提交失败</p>
	                                 <a href="javascript:void(0);" class="confirm confirm1">确  认</a>
	                                 <b></b>
	                             </div>
	                         </div> -->
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</div>
<%@include file="../sanheyi/public/MSV_footer.jsp" %>
</body>
</html>
