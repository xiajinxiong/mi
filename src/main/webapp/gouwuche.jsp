<%@ page import="java.util.HashMap" %>
<%@ page import="com.sure.mi.model.CartItem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xiajinxiong
  Date: 2019/7/7
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>我的购物车-小米商城</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <script type="text/javascript" src="js/cart.js"></script>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/logout.js"></script>
</head>
<body>
<!-- start header -->
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="./index.html" target="_blank"><div class="logo fl"></div></a>

    <div class="wdgwc fl ml40">我的购物车</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <div class="dlzc fr">
        <ul>
            <li><a href="./login.html" target="_blank">登录</a></li>
            <li>|</li>
            <li><a href="./register.jsp" target="_blank">注册</a></li>
        </ul>

    </div>
    <div class="clear"></div>
</div>
<div class="xiantiao"></div>
<div class="gwcxqbj">
    <div class="gwcxd center">
        <div class="top2 center">
            <div class="sub_top fl">
                <input type="checkbox" onclick="quan(this)" value="quanxuan" class="quanxuan" />全选
            </div>
            <div class="sub_top fl">商品名称</div>
            <div class="sub_top fl">单价</div>
            <div class="sub_top fl">数量</div>
            <div class="sub_top fl">小计</div>
            <div class="sub_top fr">操作</div>
            <div class="clear"></div>
        </div>
        <%List<CartItem> cartItems = (List<CartItem>) request.getAttribute("item");
        String b_name = (String) request.getAttribute("name");
        String b_version = (String) request.getAttribute("version");
        String b_color = (String) request.getAttribute("color");
        int sel_num = 0;
        double sel_mon = 0;
        for (CartItem cartItem : cartItems) {%>
        <div class="content2 center">
            <div class="sub_content fl ">
                <%if (b_name == null || b_version == null ||b_color == null
                    || !b_name.equals(cartItem.getName()) || !b_version.equals(cartItem.getVersion()) ||
                        !b_color.equals(cartItem.getColor())) { %>
                <input type="checkbox" onclick="zong_ji()" value="quanxuan" class="quanxuan" />
                <%} else {%>
                <input type="checkbox" onclick="zong_ji()" checked value="quanxuan" class="quanxuan" />
                <%sel_num++;sel_mon += cartItem.getPrice() * cartItem.getNumber();}%>
            </div>
            <div class="sub_content fl"><img src="./image/gwc_xiaomi6.jpg"></div>
            <div class="sub_content fl ft20">
                <span class="a"><%=cartItem.getName()%></span>
                <span class="a"><%=cartItem.getVersion()%></span>
                <span class="a"><%=cartItem.getColor()%></span>
            </div>
            <div class="sub_content fl "><%=cartItem.getPrice()%>元</div>
            <div class="sub_content fl">
                <input class="shuliang" type="number" value="<%=cartItem.getNumber()%>" step="1" min="1" >
                <button class="add_del" onclick="add(this)">+</button><button class="add_del" onclick="del(this)">-</button>
            </div>
            <div class="sub_content fl" id="xiao_ji"><%=cartItem.getPrice() * cartItem.getNumber()%>元</div>
            <div class="sub_content fl" onclick="drop(this)" style="cursor: pointer">×</div>
            <div class="clear"></div>
        </div>
        <%}%>
    </div>
    <div class="jiesuandan mt20 center">
        <div class="tishi fl ml20">
            <ul>
                <li><a href="./liebiao.html">继续购物</a></li>
                <li>|</li>
                <li>共<span id="toal_number"><%=cartItems.size()%></span>件商品，已选择<span id="se_number"><%=sel_num%></span>件</li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="jiesuan fr">
            <div class="jiesuanjiage fl">合计（不含运费）：<span id="total"><%=sel_mon%></span>元</div>
            <div class="jsanniu fr"><input class="jsan" onclick="pay()" type="button" name="jiesuan"  value="去结算"/></div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</div>




<!-- footer -->
<footer class="center">

    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>

</body>
</html>

