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
<title>SHY--新闻动态详情</title>
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
		<div class="about_t">
			<p class="s_new_tt">${article.title }</p>
			<p class="s_new_tt1">来源：${article.articleData.copyfrom }</p>
			<p class="s_new_tt1">发布时间：<fmt:formatDate value="${article.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
			<div class="ceshi">
				${article.articleData.content }
			</div><!-- <p class="about_t4">从前，在生物学研究领域，有一个白富美叫基因组学（Genomics），她有一项强大的技能：DNA测序，凭借这项技能，她完成了对多种物种的基因组测序、定位了编码基因和确定编码基因的结构等基本的基因组注释任务。但她对基因组注释方法主要依赖于DNA及RNA序列信息。而为了更加精确地解读完成测序的基因组，单凭她一己之力是不够的，还需整合多种类型组学方法来进行基因组注释。</p>
			<p class="about_t4">著名屌丝闪亮登场！名曰蛋白质组学（Proteomics），暗恋女神已多年，苦于自身并无一技之长，虽长期以来一直在女神面前狂刷存在感，但并未引起女神注意。故针对基因组学技能缺陷，潜心修炼，终获独门神技——串联质谱技术，弥补女神缺憾，终于逆袭成功。该技能实现了对蛋白质组的高覆盖，使得利用串联质谱数据进行基因组注释成为可能。串联质谱数据一方面可以对已注释的基因进行表达验证，另一方面还可以校正原注释基因，进而发现新基因，实现对基因组序列的重新注释。这样一来就很好的弥补了基因组学的不足，从而一举获得女神青睐，抱得美人归。成为生物学研究领域的史密斯夫妇，他们给自己的组合取了个很没创新性的名字——蛋白质基因组学（Proteogenomics），义指蛋白质组学与基因组学的交叉，这个交叉范围很广且可以多种方式定义，但通常是指基于串联质谱技术的蛋白质组学信息研究来提高对基因组的注释。</p>
			<p class="about_t4">今年6月份，国际知名期刊Nature和Cell分别报导了这对夫妇利用自身强大技能对生物学研究领域邪恶组织成员乳腺癌和卵巢癌进行无情打击的英勇事迹。</p>
			<p class="about_t4">其中在Nature题为”Proteogenomics connects somatic mutations to signalling in breast cancer”的报导中描述了对来自 “癌症基因组图集”(TCGA)、代表由mRNA定义的四个主要乳腺癌内在子类型的105个乳腺癌样本所做的基于iTRAQ联合串联质谱量化了超过12,000个蛋白质和33,000个磷酸化位点的蛋白质组学和磷酸化蛋白质组学分析。</p>
-->		<div class="prve_next">
	 		<c:if test="${not empty up }">
				<p class="prve_txt1">上一篇：<a href="${ctx}/articledetail/${up.id}.html">${up.title }</a></p>
			</c:if>
			<c:if test="${not empty down }">
				<p class="prve_txt1">下一篇：<a href="${ctx}/articledetail/${down.id}.html">${down.title }</a></p>
			</c:if>
		</div>
		</div>
	</div>
</div>
<%@include file="../sanheyi/public/MSV_footer.jsp" %>
</body>
</html>
