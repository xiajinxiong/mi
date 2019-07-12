function loginCheck() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var sub = true;
    if (username === "") {
        $('#username_error')[0].innerText="请输入用户名";
        sub = false;
    }
    else {
        $('#username_error')[0].innerText="";
    }
    if (password === "") {
        $('#password_error')[0].innerText="请输入密码";
        sub = false;
    }
    else {
        $('#password_error')[0].innerText="";
    }
    if (sub) {
        var test = {username: username,
            pword: password};
        $.ajax({
            method: "POST",
            url: "login",
            data: {test : JSON.stringify(test)}
        })
            .done(function( msg ) {
                if (msg === "s") {
                    window.location.href = "/mi_war_exploded/";
                }
                else {
                    $('#info')[0].innerText="用户名或密码不正确";
                }
            });
    }
}

window.onload = function (ev) {
    $('#username_error')[0].innerText="";
    $('#password_error')[0].innerText="";
}