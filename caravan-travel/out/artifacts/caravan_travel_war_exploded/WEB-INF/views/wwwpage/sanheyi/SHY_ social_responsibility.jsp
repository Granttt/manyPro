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
<title>SHY-关于我们--社会责任</title>
<link rel="shortcut icon" type="text/css" href="images/ll.ico" />
<link rel="stylesheet" type="text/css" href="../css/public.css"/><!--公用css，头部和底部及二级页面样式-->
<link rel="stylesheet" href="../css/style.css" /><!--各个页面css样式-->
<link rel="stylesheet" type="text/css" href="../css/reset.css"/><!--公用css，头部和底部及二级页面样式-->
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script><!--公用jQuery-->

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
<div class="top">                                    
    <div class="top_con">      
        <p class="top_con_l">欢迎来到北京三合亿生物科技有限公司 官网</p>
        <p class="top_con_r"><a href="#">设为首页</a> | <a href="#">加入收藏</a> | <a href="#">联系我们</a></p>
    </div>
</div>
<script  type="text/javascript"><!-- nav -->
    $(function() {
        var navLi=$(".li");
        navLi.hover(function() {
            $(this).children("a").addClass("current1");
            $(this).find(".box").stop().slideDown(150);
        }, function() {
            $(this).children("a").removeClass("current1");
            $(this).find(".box").stop().slideUp(150);
        });
    });
</script> 
<div class="head">
    <div class="logo"><a href="#"><img src="../images/logo.png" height="78" width="228" alt="" /></a></div>
    <div class="nav1">
        <div class="nav mt5">
            <ul class="clearFloat">
                <li class="li"><a href="" class="nav_cell current1">网站首页</a></li>
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
                </li>
            </ul>
            <div class="absolute nav_block">
                <div class="absolute nav_line"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../js/nav2.js"></script>
<!-- 头部所有 end -->
<!-- banner -->
<div class="er_banner" style="background: url(../images/er_b1.jpg) center center no-repeat; height:300px;"></div>
<!-- banner end-->
<div class="about_con">
	<div class="about_con_l">
		<p class="a_tit">关于我们</p>
		<ul class="a_nav">
			<li><a href="#" >企业简介</a></li>
			<li><a href="#">企业文化</a></li>
			<li><a href="#" class="a_cur">社会责任</a></li>
		</ul>
	</div>
	<div class="about_con_r">
		<div class="about_r_tit">
			<span  class="about_tit">社会责任</span>
		</div>
		<div class="about_t">
			<p class="about_t1">北京三合亿生物科技有限公司一直注重实现企业的社会价值，以“为公司提供回报、为员工提供机会、为客户创造价值、为社会创造繁荣”为责任，在追求经济效益、保护公司利益的同时，切实诚信对待和保护其他利益相关者，尤其是员工、客户的合法权益，推进环境保护与友好、资源节约与循环等建设，参与、捐助社会公益及其慈善事业，以自身发展影响和带动地方经济的振兴，促进公司与社会、社区、自然的协调、和谐发展。北京三合亿生物科技有限公司致力于人类的食品安全，为人类创造安全、绿色、高效的生物防腐剂，从而替代其他一些防腐剂。</p>
		</div>
	</div>
</div>
<!-- 返回顶部 -->
<script><!-- 返回顶部 -->
    $(function() {
            $(window).scroll(function(){
                     if($(window).scrollTop()>200){
                    $(".back_top").fadeIn(); 
                }
                else{
                    $(".back_top").hide();
                }
        });
        $(".t_w3").click(function(event) {
                /* Act on the event */
                $("html,body").animate({
                    scrollTop:"0px"},
                    666
                    )
            });
    });
    </script><!-- 返回顶部 end-->
<div class="back_top">
    <a href="javascript:void(0);" class="t_w1"></a>
    <a href="javascript:void(0);" class="t_w2"></a>
    <a href="javascript:void(0);" class="t_w3"></a>
</div>
<!-- 返回顶部 end-->
<!-- 底部所有 -->
<div class="footer">
    <div class="footer1">
        <div class="f1_con">
            <div class="f1_con1">                            
                <p class="f_link"><a href="#">网站首页</a><a href="#">关于我们</a><a href="#">产品展示</a><a href="#">新闻动态</a><a href="#">联系我们</a></p>
                <p class="f_line"><img src="images/f_line.png" height="2" width="467" alt="" /></p>
                <p class="phone1">服务热线：</p>
                <p class="phone2">400-8888- 8888</p>
            </div>
            <div class="f1_con2">
                <ul class="foot_ul">
                    <li class="foot_li0">关注我们：</li>
                    <li class="foot_li1"><a href="#"></a></li>
                    <li class="foot_li2"><a href="#"></a></li>
                    <li class="foot_li3"><a href="#"></a></li>
                </ul>
                <p class="f_c2_txt">公司地址：北京市朝阳区住邦2000商务中心1号楼A区305室</p>
                <p class="f_c2_txt2">公司邮箱：<a href="#">www.wangboshijing.com</a></p>
            </div>
            <div class="f1_con3">
                <p class="code"><img src="../images/code.png" height="129" width="129" alt="" /></p>
                <p class="code_txt">扫一扫订阅号</p>
            </div>
        </div>
    </div>
    <div class="footer2">
        <div class="f2_con">
            <span>版权所有：网博实景（北京）网络科技有限公司</span>
            <span style="padding-left:55px;">COPYRIGHT © 2013京ICP备09004155号</span>
        </div>
    </div>
</div>
<!-- 底部所有 end -->
</body>
</html>
