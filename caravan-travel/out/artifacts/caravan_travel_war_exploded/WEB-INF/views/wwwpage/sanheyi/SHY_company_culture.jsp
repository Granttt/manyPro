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
<title>SHY-关于我们--企业文化</title>
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
<!-- 头部所有 -->
<%@include file="../sanheyi/public/MSV_header.jsp" %>
<!-- 头部所有 end -->
<!-- banner -->
<div class="er_banner" style="background: url(${imageUrl}) center center no-repeat; height:300px;"></div>
<!-- banner end-->
<div class="about_con">
	<%@include file="../sanheyi/public/SHY_left.jsp" %>
	<div class="about_con_r">
		<div class="about_r_tit">
			<span  class="about_tit">企业文化</span>
		</div>
		<div class="about_t">
			<p class="about_t2">三合亿以高质量的产品和专业的服务保障食品的安全和品质。</p>
			<p class="about_t2">企业精神: 创新改变未来，努力成就梦想，团结创造辉煌。</p>
			<p class="about_t2">企业最高目标：追求人类健康，创造绿色文明，我们应尽善尽责</p>
			<p class="about_t2">企业产品宗旨：生产绿色产品，创造绿色世界，许诺绿色文明</p>
			<p class="about_t2">企业质量方针：以人为本，以质为先，持续创新，客户满意</p>
			<p class="about_t2">企业服务理念：专业服务，真诚服务</p>
			<p class="about_t2">公司愿景: 追求人类健康 创造绿色文明</p>
			<p class="about_t2">经营理念: 关注客户需求 提供高服务质量 为客户创造价值</p>
			<p class="about_t3">三合亿生物科技有限公司以“为客户提供价值”为经营理念，向客户提供安全、绿色、高效的生物防腐剂产品，为客户创造长期的价值和潜在的增长，立志做中国生物防腐剂的领航者。</p>
		</div>
	</div>
</div>
<%@include file="../sanheyi/public/MSV_footer.jsp" %>
</body>
</html>
