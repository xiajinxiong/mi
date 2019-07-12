function sub() {
    var username = document.getElementsByName("username")[0].value,
        pword = document.getElementsByName("password")[0].value,
        re_pword = document.getElementsByName("repassword")[0].value,
        phone = document.getElementsByName("tel")[0].value;
    var sub = true;
    if (username.length < 6 || username.length >18) {
        document.getElementById("username").innerText="用户名长度需大于等于6小于等于8";
        sub = false;
    }
    else {
        document.getElementById("username").innerText="";
    }
    if (pword.length === 0) {
        document.getElementById("pword").innerText="请输入密码";
        sub = false;
    }
    else {
        document.getElementById("pword").innerText="";
    }
    if (pword !== re_pword) {
        document.getElementById("pword_re").innerText="密码和确认密码需一致";
        sub = false;
    }
    else {
        document.getElementById("pword_re").innerText="";
    }
    if (phone.length !== 11) {
        document.getElementById("phone").innerText="请填写正确的手机号";
        sub = false;
    }
    else {
        document.getElementById("phone").innerText="";
    }
    if (!sub) {
        return;
    }
    var test = {username: username,
    pword: pword,
    phone: phone};
    $.ajax({
        method: "POST",
        url: "logup",
        data: {test : JSON.stringify(test)}
    })
        .done(function( msg ) {
            if (msg === "0") {
                window.location.href = "/mi_war_exploded/";
            }
            if (msg === "-1" || msg === "-2") {
                $('#username')[0].innerText="该用户名已被注册";
            }
            if (msg === "-1" || msg === "-3") {
                $('#phone')[0].innerText="该手机号已被注册";
            }
        });
}