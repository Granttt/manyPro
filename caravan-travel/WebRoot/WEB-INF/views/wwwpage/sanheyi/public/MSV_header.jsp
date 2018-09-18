<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
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
<title>SHY-头部</title>

<script type="text/javascript">
 
//设为首页
function SetHome(obj,url){
    try{
        obj.style.behavior='url(#default#homepage)';
        obj.setHomePage(url);
    }catch(e){
        if(window.netscape){
            try{
                netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
            }catch(e){
                alert("抱歉，此操作被浏览器拒绝！\n\n请在浏览器地址栏输入“about:config”并回车然后将[signed.applets.codebase_principal_support]设置为'true'");
            }
        }else{
            alert("抱歉，您所使用的浏览器无法完成此操作。\n\n您需要手动将【"+url+"】设置为首页。");
        }
    }
}
 
//收藏本站
function AddFavorite(title, url) {
    try {
        window.external.addFavorite(url, title);
    }
    catch (e) {
        try {
            window.sidebar.addPanel(title, url, "");
        }
        catch (e) {
            alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
        }
    }
}
        </script>
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
<div class="top">                                    
    <div class="top_con">      
        <p class="top_con_l">欢迎来到北京三合亿生物科技有限公司 官网</p>
        <p class="top_con_r"><a href="#" onclick="SetHome(this,document.domain);">设为首页</a> | <a href="#"   onclick="AddFavorite('我的网站',location.href)">加入收藏</a> | <a href="${ctx}/corporate/18.html">联系我们</a></p>
    </div>
</div>
<script  type="text/javascript"><!-- nav -->
    $(function() {
        var navLi=$(".li");
        navLi.hover(
	        function() {
	            $(this).children("a").addClass("current1");
	            $(this).find(".box").stop().slideDown(150);//二级菜单向下滑动效果
	        }, 
	        function() {
	        /* alert($("#inp").val()) */
	        if($(this).attr("id") !=$("#inp").val()){
	            $(this).children("a").removeClass("current1");
	        }
	            $(this).find(".box").stop().slideUp(150);
	        }
        );
    });
</script> 
<input type="hidden" id="inp" value="${categoryid}" />
<div class="head">
    <div class="logo"><a href="${ctx }/index.html"><img src="${ctxStatic}/sanheyi/images/logo.png" height="78" width="228" alt="" /></a></div>
    <div class="nav1">
        <div class="nav mt5">
            <ul class="clearFloat">
        <!--         <li class="li"><a href="" class="nav_cell current1">网站首页</a></li>
                <li class="li">
                    <a href="" class="nav_cell">关于我们</a>
                    <div class="box">
                            <a href="#">企业简介</a>
                            <a href="#">企业文化</a>
                            <a href="#" style="border-bottom:0;">社会责任</a>
                    </div>
                </li>
                <li class="li">
                    <a href="#" class="nav_cell">产品展示</a>
                </li>
                <li class="li">
                    <a href="#" class="nav_cell">新闻动态</a>
                    <div class="box">
                            <a href="#">公司动态</a>
                            <a href="#" style="border-bottom:0;">行业动态</a>
                    </div>
                </li>
                <li class="li">
                    <a href="#" class="nav_cell">联系我们</a>
                </li> -->
                 <c:forEach items="${fnc:getAllCategoryList()}" var="map">
					<c:forEach items="${map.value}" var="parent">
						<c:forEach items="${parent.childList}" var="se">
						<li class="li" id="${se.id}">
							<c:if test="${se.id eq categoryid}">
								<a href="${ctx}${se.href}" class="nav_cell current1">
							</c:if>
							<c:if test="${se.id ne categoryid}">
								<a href="${ctx}${se.href}"  class="nav_cell">
							</c:if>
								${se.name}</a>
								<div class="box">
									<c:forEach items="${se.childList }" var="tr">
										<a href="${ctx}${tr.href}" title="${tr.name}">${tr.name}</a>
									</c:forEach>
								</div>
							</li>
						</c:forEach>
					</c:forEach>
				</c:forEach>
       
            </ul>
            <div class="absolute nav_block">
                <div class="absolute nav_line"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctxStatic}/sanheyi/js/nav2.js"></script>
<!-- 头部所有 end -->
</body>
</html>
