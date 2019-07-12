<%--
  Created by IntelliJ IDEA.
  User: xiajinxiong
  Date: 2019/7/5
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="./css/login.css">
    <script type="text/javascript" src="js/register.js"></script>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/logout.js"></script>

</head>
<body>
<form  method="post" action="logup">
    <div class="regist">
        <div class="regist_center">
            <div class="regist_top">
                <div class="left fl">会员注册</div>
                <div class="right fr"><li><a href="/mi_war_exploded" target="_self">小米商城</a></li>
                <div class="clear"></div>
                <div class="xian center"></div>
            </div>
            <div class="regist_main center">
                <br>
                <div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text" name="username" placeholder="请输入你的用户名"/><span id="username"></span></div>
                <span class="username" id="username_dup"></span>
                <div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="password" placeholder="请输入你的密码"/><span id="pword"></span></div>
                <div class="username">确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="repassword" placeholder="请确认你的密码"/><span id="pword_re"></span></div>
                <div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang" type="text" name="tel" placeholder="请填写正确的手机号"/><span id="phone"></span></div>
                <span class="username" id="phone_dup"></span>
                <div class="username">
                    <div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="yanzhengma" type="text" name="key" placeholder="请输入验证码"/></div>
                    <div class="right fl"><img src="./image/yanzhengma.jpg"></div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="regist_submit">
                <input class="submit" type="button" name="submit" value="立即注册" onclick="sub()">
            </div>

        </div>
    </div>
</form>
</body>
</html>