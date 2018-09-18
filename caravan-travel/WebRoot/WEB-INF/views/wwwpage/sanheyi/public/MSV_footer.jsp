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
<title>SHY-底部</title>
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
    		//qq关注
            var qq_chat = true;
			function PlayJsAdPopWin() {
				if (qq_chat) {
				popwin = window.location.href = 'tencent://message/?uin=${fnc:getConstByUni('qq')}&Site=&Menu=yes'
				}
			};
    </script><!-- 返回顶部 end-->
<div class="back_top">
    <a href="javascript:void(0);" class="jiathis_button_tsina"></a>
    <a href="javascript:void(0);" class="jiathis_button_weixin"></a>
    <a href="javascript:void(0);" class="t_w3"></a>
</div>
<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
<!-- 返回顶部 end-->
<!-- 底部所有 -->
<div class="footer">
    <div class="footer1">
        <div class="f1_con">
            <div class="f1_con1">                            
                <p class="f_link"><a href="${ctx }/index.html">网站首页</a><a href="${ctx}/enterprise/df477d1fe561455d8f83d8b27d8b120d.html">关于我们</a><a href="${ctx}/projectlist/24">产品展示</a><a href="${ctx}/newslist/0c5de388a2fc49adb18b8cad9e995ed5">新闻动态</a><a href="${ctx}/corporate/18.html">联系我们</a></p>
                <p class="f_line"><img src="${ctxStatic}/sanheyi/images/f_line.png" height="2" width="467" alt="" /></p>
                <p class="phone1">服务热线：</p>
                <p class="phone2">${fnc:getConstByUni('telphone')}</p>
            </div>
            <div class="f1_con2">
                <%-- <ul class="foot_ul">
                    <li class="foot_li0">关注我们：</li>
                    <li class="foot_li1"><a href="${fnc:getConstByUni('weibo')}" target="_blank"></a></li>
                    <li class="foot_li2"><a href="javascript:PlayJsAdPopWin();"></a></li>
                    <!-- <li class="foot_li3"><a href="#"></a></li> -->
                </ul> --%>
                <p class="f_c2_txt">公司地址：${fnc:getConstByUni('address')}</p>
                <p class="f_c2_txt2">版权所有：${fnc:getConstByUni('copyright')}</p>
                <p class="f_c2_txt2">${fnc:getConstByUni('icp')}</p>
            </div>
            <%-- <div class="f1_con3">
                <p class="code"><img src="${fnc:getConstByUni('qrcode')}" height="129" width="129" alt="" /></p>
                <p class="code_txt">扫一扫订阅号</p>
            </div> --%>
        </div>
    </div>
    <%-- <div class="footer2">
        <div class="f2_con">
            <span>版权所有：${fnc:getConstByUni('copyright')}</span>
            <span style="padding-left:55px;">${fnc:getConstByUni('icp')}</span>
        </div>
    </div> --%>
</div>
<!-- 底部所有 end -->
</body>
</html>
