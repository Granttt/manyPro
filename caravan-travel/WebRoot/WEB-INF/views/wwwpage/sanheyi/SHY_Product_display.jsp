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
<title>SHY--产品展示</title>
<link rel="shortcut icon" type="text/css" href="${ctxStatic}/sanheyi/images/ll.ico" />
<link rel="stylesheet" type="text/css" href="${ctxStatic}/sanheyi/css/public.css"/><!--公用css，头部和底部及二级页面样式-->
<link rel="stylesheet" href="${ctxStatic}/sanheyi/css/style.css" /><!--各个页面css样式-->
<link rel="stylesheet" type="text/css" href="${ctxStatic}/sanheyi/css/reset.css"/><!--公用css，头部和底部及二级页面样式-->
<script type="text/javascript" src="${ctxStatic}/sanheyi/js/jquery-1.7.2.min.js"></script><!--公用jQuery-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 10]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body id="body">
<!--[if lt IE 7]>
    <p class="browsehappy">
        你正在使用一个
        <strong>
        过时
        </strong>
        的浏览器。请到
        <a href="http://browsehappy.com/">
        这个网站
        </a>
        更新您的浏览器以便获取更好的视觉效果。
    </p>
<![endif]-->
<%@include file="../sanheyi/public/MSV_header.jsp" %>
<!-- banner -->
<div class="er_banner" style="background: url(${imageUrl}) center center no-repeat; height:300px;"></div>
<!-- banner end-->
<script type="text/javascript"> 
  $(document).ready(function(){
    $(".pro2_li a").hover(function(){
      $(this).stop().animate({
        marginTop: "-10px"
      }, 250);
      $(this).siblings('.p_shdow3').css('display', 'block');
    }, function(){
      $(this).stop().animate({
        marginTop: "0px"
      }, 250);
      $(this).siblings('.p_shdow3').css('display', 'none');
    });
  });
</script>
<script>
$(function() {				 /*弹出层2*/
    $(".pro2_li a").click(function(){
      $(this).siblings('.alert_bg1').height($("body").height());
      $(this).siblings('.alert_bg1').width($("body").width());
      $(this).siblings('.alert_bg1').children('.alert4').show();
      // $("body").css('overflow', 'hidden');
       
    });
    $(".alert4 b").click(function(){
    	$(this).parent(".alert4").css("display","none");
    //  $("body").find(".alert_bg").css("display","none");
        $(this).parent(".alert4").parent(".alert_bg1").height(0).width(0);
        // $("body").css('overflow', 'auto');

    });
});
</script>
<div class="about_con">
	<div class="about_con_l">
		<p class="a_tit">${fnc:getCategory(child).name}</p>
		<ul class="a_nav">
			<li><a href="#" class="a_cur">${fnc:getCategory(child).name}</a></li>
		</ul>
	</div>
	<div class="about_con_r">
		<div class="about_r_tit">
			<span  class="about_tit">${fnc:getCategory(child).name}</span>
		</div>
		<div class="news_list">
			<ul class="pro2_ul">
			<c:forEach items="${page.list}" var="cmsslide" varStatus="status">
			<li class="pro2_li">
                 <a href="javascript:void(0);">
                     <p class="p_pic2"><img src="${cmsslide.imageurl }" height="194" width="296"  alt="" /></p>
                     <div class="p_txt" style="padding-top:10px;">
                         <p class="p_txt1">${cmsslide.imagename }</p>
                         <p class="p_txt2" style="padding-top:7px;">${cmsslide.imagetitle }</p>
                     </div>
                 </a>
                    <div class="alert_bg1">
						<div class="alert4">
							<p class="a_img">
								<img src="${cmsslide.imageurl }" height="582" width="890"  alt="" />
							</p>
							<b></b>
						</div>
					</div>
                <div class="p_shdow3"></div>
            </li>
			</c:forEach>
		    </ul>
			<div class="clear"></div>
			<form id="searchForm" action="${ctx}/projectlist/${child}" method="post" >
				<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
				<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
				<input id="last" name="last" type="hidden" value="${page.last}"/>
		    </form>
			<div class="page_w">
				<ul>
					${page}
				</ul>
			</div>
		</div>
	</div>
</div>
<%@include file="../sanheyi/public/MSV_footer.jsp" %>
</body>
<script type="text/javascript">
     function page(n,s,t){
     var inp=document.getElementById("inptt").value ;
     if(t == '11'){
	     if(inp !=null && inp !=''){
	     //填写页数大于总页数
	     if(inp>$("#last").val()){
	     	$("#pageNo").val($("#last").val());
	     }else{
			$("#pageNo").val(inp);
	     }
	     }else{
	     	$("#pageNo").val(n);
	     }
	    }
     else{
     		$("#pageNo").val(n);
     }
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
  </script>
</html>
