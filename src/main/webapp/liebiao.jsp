<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xiajinxiong
  Date: 2019/7/6
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.sure.mi.model.Overview" %>
<%@ page import="com.sure.mi.util.UserNameUtil" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>小米手机列表</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <script type="text/javascript" src="js/logout.js"></script>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
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

<!-- start banner_y -->
<!-- end banner -->

<!-- start danpin -->
<div class="danpin center">

    <div class="biaoti center">小米手机</div>
    <div class="main center">
        <%List<Overview> overviewList = (List<Overview>) request.getAttribute("list");
        for (Overview overview : overviewList) {%>
        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
            <div class="sub_mingxing"><a href="info?product=<%=overview.getName()%>" target="_self"><img src="./image/<%=overview.getImage()%>" alt=""></a></div>
            <div class="pinpai"><a href="info" target="_self"><%=overview.getName()%></a></div>
            <div class="youhui"><%=overview.getOverview()%></div>
            <div class="jiage"><%=overview.getPrice()%></div>
        </div>
        <%}%>
        <div class="clear"></div>
    </div>
</div>


<footer class="mt20 center">
    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>

<!-- end danpin -->


</body>
</html>
