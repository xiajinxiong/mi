<%@ page import="com.sure.mi.model.Product" %>
<%@ page import="com.sure.mi.model.Version" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sure.mi.util.UserNameUtil" %><%--
  Created by IntelliJ IDEA.
  User: xiajinxiong
  Date: 2019/7/6
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>小米6立即购买-小米商城</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <script type="text/javascript" src="js/info.js"></script>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/logout.js"></script>
</head>
<body>
<!-- start header -->
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="/mi_war_exploded" target="_self">小米商城</a></li>
                <li>|</li>
                <li><a href="">MIUI</a></li>
                <li>|</li>
                <li><a href="">米聊</a></li>
                <li>|</li>
                <li><a href="">游戏</a></li>
                <li>|</li>
                <li><a href="">多看阅读</a></li>
                <li>|</li>
                <li><a href="">云服务</a></li>
                <li>|</li>
                <li><a href="">金融</a></li>
                <li>|</li>
                <li><a href="">小米商城移动版</a></li>
                <li>|</li>
                <li><a href="">问题反馈</a></li>
                <li>|</li>
                <li><a href="">Select Region</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="gouwuche fr"><a href="/mi_war_exploded/order">我的订单</a></div>
            <div class="fr">
                <ul>
                    <%String username = UserNameUtil.getUsername(request.getCookies());
                        if (username != null) {%>
                    <li><span><%=username%></span></li>
                    <li>|</li>
                    <li ><span onclick="logout()" style="cursor: pointer;">注销</span></li>
                    <li>|</li>
                    <%}
                    else {%>
                    <li><a href="./login.html" target="_self">登录</a></li>
                    <li>|</li>
                    <li><a href="./register.jsp" target="_self" >注册</a></li>
                    <li>|</li>
                    <%}%>
                    <li><a href="profile">个人中心</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="" target="_blank"><div class="logo fl"></div></a>
    <a href=""><div class="ad_top fl"></div></a>
    <div class="nav fl">
        <ul>
            <li><a href="">小米手机</a></li>
            <li><a href="">红米</a></li>
            <li><a href="">平板·笔记本</a></li>
            <li><a href="">电视</a></li>
            <li><a href="">盒子·影音</a></li>
            <li><a href="">路由器</a></li>
            <li><a href="">智能硬件</a></li>
            <li><a href="">服务</a></li>
            <li><a href="">社区</a></li>
        </ul>
    </div>
    <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
            </div>
            <div class="submit fl">
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>
<!-- end banner_x -->


<!-- xiangqing -->
<form action="alipay" method="post" >
    <div class="xiangqing">
        <div class="neirong w">
            <div class="xiaomi6 fl">小米6</div>
            <nav class="fr">
                <li><a href="">概述</a></li>
                <li>|</li>
                <li><a href="">变焦双摄</a></li>
                <li>|</li>
                <li><a href="">设计</a></li>
                <li>|</li>
                <li><a href="">参数</a></li>
                <li>|</li>
                <li><a href="">F码通道</a></li>
                <li>|</li>
                <li><a href="">用户评价</a></li>
                <div class="clear"></div>
            </nav>
            <div class="clear"></div>
        </div>
    </div>

    <div class="jieshao mt20 w">
        <div class="left fl"><img src="./image/liebiao_xiaomi6.jpg"></div>
        <div class="right fr">
            <%Product info = (Product) request.getAttribute("info");
                List<Version> versions = info.getVersions();
            List<String> versionList = new ArrayList<>();
            List<String> colorList = new ArrayList<>();
            for (Version version : versions) {
                if (!versionList.contains(version.getVersion())) {
                    versionList.add(version.getVersion());
                }
                if (!colorList.contains(version.getColor())) {
                    colorList.add(version.getColor());
                }
            }

            %>
            <div class="h3 ml20 mt20"><%=info.getName()%></div>
            <div class="jianjie mr40 ml20 mt10"><%=info.getDetail()%></div>
            <div class="jiage ml20 mt10" id="price1"><%=versions.get(0).getPrice()%></div>
            <div class="ft20 ml20 mt20">选择版本</div>
            <div class="xzbb ml20 mt10">
                <%int i = 0; for (Version version : info.getVersions()) {%>
                <input type="hidden" name="price<%=i%>" value="<%=version.getPrice()%>">
                    <div class="banben fl" id="version<%=i%>"  onclick="version_check(<%=i%>)">
                        <a><span class="yanse" id="version_<%=i%>"><%=version.getVersion()%></span></a>
                    </div>
                <%i++;}%>
                <div class="clear"></div>
            </div>
            <div class="ft20 ml20 mt20" >选择颜色</div>
            <div class="xzbb ml20 mt10">
                <%int j = 0; for (String color : colorList) {%>
                    <div class="banben color" id="color<%=j%>" onclick="color_check(<%=j%>)">
                        <a><span class="yanse" id="version_<%=j%>"><%=color%></span></a>
                    </div>
                <%j++;}%>


            </div>
            <div class="xqxq mt20 ml20">
                <div class="top1 mt10">
                    <div class="left1 fl"><%=info.getName()%> <span id="version_se"></span> <span id="color_se"></span></div>
                    <div class="right1 fr"><span class="price_se"></span></div>
                    <div class="clear"></div>
                </div>
                <div class="bot mt20 ft20 ftbc">总计：<span id="price_se"></span> </div>
            </div>
            <input type="hidden" name="name_sub" value="<%=info.getName()%>">
            <input type="hidden" name="version_sub" value="">
            <input type="hidden" name="color_sub" value="">
            <input type="hidden" name="price_sub" value="">
            <input type="hidden" name="photo_sub" value="<%=info.getVersions().get(0).getPhoto()%>">
            <span class="xiadan ml20 mt20">
                <input class="jrgwc"  type="button" name="jrgwc" value="立即选购" onclick="buy()"/>
                <input class="jrgwc" type="button" name="jrgwc" value="加入购物车" onclick="add_to_cart()"/>
                <input class="jrgwc" type="button" name="jrgwc" value="测试" onclick="test()"/>
                <input type="hidden" value="1" name="cart_hi" id="cart_hi">
            </span>
        </div>
        <div class="clear"></div>
    </div>
</form>
<!-- footer -->
<footer class="mt20 center">

    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>

</footer>

</body>
</html>
