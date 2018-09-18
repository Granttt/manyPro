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
<title>SHY-关于我们--${fnc:getCategory(child).name}</title>
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
<div class="about_con">
<%@include file="../sanheyi/public/SHY_left.jsp" %>
	<div class="about_con_r">
		<div class="about_r_tit">
			<span  class="about_tit">${fnc:getCategory(child).name}</span>
		</div>
		<c:if test="${fnc:getArticleAllInfo(child).image ne null && fnc:getArticleAllInfo(child).image ne ''}">
			<div class="about_img"><img src="${fnc:getArticleAllInfo(child).image}" height="330" width="447" alt="" /></div>
		</c:if>
		<div class="about_t">
			<!-- <p class="about_t1">北京三合亿生物科技有限公司是天然生物防腐剂的领航者，是一家以发展生物技术为主导，集技术研发、生产加工和市场营销于一体的现代化高新技术企业。随着市场的进一步扩大，要求公司具备更大的生产规模，2012年，公司决定将生产经营地点迁往北京，注册成立北京三合亿生物科技有限公司。公司位于北京市，占地面积约150余亩，注册资金2000万元，主营业务为纳他霉素和乳酸链球菌的生产销售，产品在全球市场流通销售，同时提供生物科技领域的技术开发、咨询、转让和技术进出口服务。</p>
			<p class="about_t1">公司拥有全国先进的分析设备、发酵设备以及相关单元的提取设备，可满足不同产品的工艺技术研究，现有乳酸链球菌素年生产能力500吨，纳他霉素年生产能力100吨；公司具有完善的质量保障系统，已通过了ISO9001、HACCP、GMP等质量管理体系认证，同时还获得了KOSHER（犹太）、HALLAL（清真）认证。公司通过了高新技术企业认证、获得了北京市科学技术厅颁发的科技成果鉴定证书、市科技创新基金项目及国家创新基金项目奖、被评为“市百高企业”。公司下设研发部，拥有专业研发人员30多人，发明专利5项，曾受邀参与国家、行业标准的起草和修订，该部门与多所国内外知名大学紧密合作，致力于产品的研发和技术创新，这决定了奇泓生物科技有限公司在同类产品中的领航者地位。</p>
 -->		
 			${fnc:getArticleAllInfo(child).articleData.content}
 		</div>
	</div>
</div>
<%@include file="../sanheyi/public/MSV_footer.jsp" %>
</body>
</html>
