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
<meta name="" content="三合亿" /><!-- 填写百度检索关键字 -->
<!--当前网页的三要素-->
<title>SHY-官网</title>
<link rel="shortcut icon" type="text/css" href="${ctxStatic}/sanheyi/images/ll.ico" />
<link rel="stylesheet" type="text/css" href="${ctxStatic}/sanheyi/css/public.css"/><!--公用css，头部和底部及二级页面样式-->
<link rel="stylesheet" type="text/css" href="${ctxStatic}/sanheyi/css/style.css"/><!--各个页面css样式-->
<link rel="stylesheet" type="text/css" href="${ctxStatic}/sanheyi/css/reset.css"/><!--公用css，头部和底部及二级页面样式-->
<script type="text/javascript" src="${ctxStatic}/sanheyi/js/jquery-1.9.1.js"></script><!--公用jQuery-->
<script src="${ctxStatic}/sanheyi/js/jquery.flexslider-min.js"></script><!--banner-->
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
<!-- 头部所有 -->
<%@include file="../sanheyi/public/MSV_header.jsp" %>
<!-- 头部所有 end -->
<!-- banner -->
<div class="flexslider">
    <ul class="slides">
        <c:forEach items="${fnc:getFocusList('7a25c48f7c0b4bb799dee8f17225e028',3)}" varStatus="status" var="resource">
			<li style="width:1920px; height:600px;background:url('${resource.sysMidiaResource.resourceurl}') 50% 0 no-repeat;"><a href="#" ></a></li>
		</c:forEach>
    </ul>
</div>
<script type="text/javascript">
$(document).ready(function(){
    $('.flexslider').flexslider({
        directionNav: true,
        pauseOnAction: false,
        animation: "slide",
    });
    console.info("aaaaa")
    console.log("日志信息");
});
</script>
<!-- banner end-->
<div class="brief">
    <div class="brief_con">
        <p class="brief_p1">${fnc:getArticleAllInfo('df477d1fe561455d8f83d8b27d8b120d').title}</p>
        <p class="brief_p2">${fns:abbr(fnc:getArticleAllInfo('df477d1fe561455d8f83d8b27d8b120d').articleData.content,320)}</p>
    </div>
    <a href="${ctx}${fnc:getCategory('df477d1fe561455d8f83d8b27d8b120d').href}" class="b_more">MORE</a>
</div>
<script type="text/javascript"> 
  $(document).ready(function(){
    $(".pro_li a").hover(function(){
      $(this).stop().animate({
        marginTop: "-10px"
      }, 250);
      $(this).siblings('.p_shdow').css('display', 'block');
    }, function(){
      $(this).stop().animate({
        marginTop: "0px"
      }, 250);
      $(this).siblings('.p_shdow').css('display', 'none');
    });
  });
</script>
<script>
$(function() {				 /*弹出层2*/
    $(".pro_li a").click(function(){
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
<div class="product">
    <p class="pro_tit"><img src="${ctxStatic}/sanheyi/images/pro_tit.png" height="46" width="372" alt="" /></p>
    <div class="product_con">
        <div class="pro_con1">
            <ul class="pro_ul">
            <c:forEach items="${cmslist }" varStatus="status" var="cmsslide" end="5">
	            <c:choose> 
					  <c:when test="${status.count<4}">   
					    <li class="pro_li pro_li2">
		                    <a href="javascript:void(0);">
		                        <p class="p_pic"><img src="${cmsslide.imageurl }" height="246" width="376" alt="" /></p>
		                        <div class="p_txt">
		                            <p class="p_txt1">${cmsslide.imagename }</p>
		                            <p class="p_txt2">${cmsslide.imagetitle }</p>
		                        </div>
		                    </a>
		                    <div class="alert_bg1">
								<div class="alert4">
									<p class="a_img"><img src="${cmsslide.imageurl }" height="582" width="890"  alt="" /></p>
									<b></b>
								</div>
							</div>
		                    <div class="p_shdow"></div>
		                </li>
					  </c:when> 
					  <c:otherwise>   
					    <li class="pro_li">
		                    <a href="javascript:void(0);">
		                        <p class="p_pic"><img src="${cmsslide.imageurl }" height="246" width="376" alt="" /></p>
		                        <div class="p_txt">
		                            <p class="p_txt1">${cmsslide.imagename }</p>
		                            <p class="p_txt2">${cmsslide.imagetitle }</p>
		                        </div>
		                    </a>
		                    <div class="alert_bg1">
								<div class="alert4">
									<p class="a_img"><img src="${cmsslide.imageurl }" height="582" width="890"  alt="" /></p>
									<b></b>
								</div>
							</div>
		                    <div class="p_shdow"></div>
		                </li>
					  </c:otherwise> 
				</c:choose> 
			</c:forEach>
                <!-- <li class="pro_li pro_li2">
                    <a href="#">
                        <p class="p_pic"><img src="images/p2.png"  alt="" /></p>
                        <div class="p_txt">
                            <p class="p_txt1">盘尼西林</p>
                            <p class="p_txt2">抗生素</p>
                        </div>
                    </a>
                    <div class="alert_bg1">
					<div class="alert4">
						<p class="a_img">
							<img src="../images/p1.png" height="582" width="890"  alt="" />
						</p>
						<b></b>
					</div>
				</div>
                    <div class="p_shdow"></div>
                </li>
                <li class="pro_li">
                    <a href="#">
                        <p class="p_pic"><img src="images/p6.png"  alt="" /></p>
                        <div class="p_txt">
                            <p class="p_txt1">盘尼西林</p>
                            <p class="p_txt2">抗生素</p>
                        </div>
                    </a>
                    <div class="p_shdow"></div>
                </li> -->
            </ul>
            <div class="clear"></div>
            <a href="${ctx}${fnc:getCategory('24').href}" class="b_more2">MORE</a>
        </div>
    </div>
</div>
<script type="text/javascript"> 
  $(document).ready(function(){
    $(".new_li a").hover(function(){
      $(this).stop().animate({
        marginTop: "-10px"
      }, 250);
      $(this).siblings('.n_shdow').css('display', 'block');
    }, function(){
      $(this).stop().animate({
        marginTop: "0px"
      }, 250);
      $(this).siblings('.n_shdow').css('display', 'none');
    });
  });
</script>
<div class="news">
    <p class="pro_tit"><img src="${ctxStatic}/sanheyi/images/new.png" height="46" width="368" alt="" /></p>
    <div class="new_con">
        <ul class="new_ul">
        	<c:forEach items="${fnc:getArticleLists('0c5de388a2fc49adb18b8cad9e995ed5')}" begin="0" end="1" var="article">
            <li class="new_li">
                <a href="${ctx}/articledetail/${article.id}.html" target="_blank">
                    <div class="new_img"><img src="${article.image}"  alt="" /></div>
                    <div class="new_txt">
                        <p class="new_txt1"><fmt:formatDate value="${article.createDate}" pattern="yyyy-MM-dd"/></p>
                        <p class="new_txt2" title="${article.title}">${article.title}</p>
                        <p class="new_txt3">${fns:abbr(article.articleData.content,110)}</p>
                    </div>
                </a>
                <div class="n_shdow"></div>
            </li>
			</c:forEach>
			<c:forEach items="${fnc:getArticleLists('f7db5d80fdc648f0bb1e62dd5d4bb2c7')}" begin="0" end="1" var="article">
            <li class="new_li">
                <a href="${ctx}/articledetail/${article.id}.html" target="_blank">
                    <div class="new_img"><img src="${article.image}"  alt="" /></div>
                    <div class="new_txt">
                        <p class="new_txt1"><fmt:formatDate value="${article.createDate}" pattern="yyyy-MM-dd"/></p>
                        <p class="new_txt2" title="${article.title}">${article.title}</p>
                        <p class="new_txt3">${fns:abbr(article.articleData.content,110)}</p>
                    </div>
                </a>
                <div class="n_shdow"></div>
            </li>
            </c:forEach>
        </ul>
        <div class="clear"></div>
        <a href="${ctx}${fnc:getCategory('0c5de388a2fc49adb18b8cad9e995ed5').href}" class="b_more2" style="margin:20px auto 0;">MORE</a>
    </div>
</div>

<!-- 底部所有 -->
<%@include file="../sanheyi/public/MSV_footer.jsp" %>
<!-- 底部所有 end -->
</body>
</html>
