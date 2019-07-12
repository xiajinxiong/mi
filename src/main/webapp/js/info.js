function color_check(i) {
    for (var j = 0; ; j++) {
        var k = document.getElementById("color" + j);
        if (JSON.stringify(k) === '{}') {
            break;
        }
        k.style.borderColor = "#aaaaaa";
    }
    var e = document.getElementById("color" + i);
    e.style.borderColor="red";
    document.getElementById("color_se").innerText=e.innerText;
    document.getElementsByName("color_sub")[0].value=e.innerText;
}

function version_check(i) {
    for (var j = 0; ; j++) {
        var k = document.getElementById("version" + j);
        if (!k) {
            break;
        }
        k.style.borderColor = "#aaaaaa";
    }
    var e = document.getElementById("version" + i);
    e.style.borderColor="red";
    document.getElementById("version_se").innerText=e.innerText;
    document.getElementById("price_se").innerText=document.getElementsByName("price" + i)[0].value;
    document.getElementById("price1").innerText=document.getElementsByName("price" + i)[0].value;


    document.getElementsByName("version_sub")[0].value=e.innerText;
    document.getElementsByName("price_sub")[0].value=document.getElementsByName("price" + i)[0].value;
}

function submit_check(a) {
    document.getElementById("cart_hi").value=a;
    var version = document.getElementsByName("version_sub")[0].value;
    if (version === "") {
        alert("请选择版本");
    }
    var color = document.getElementsByName("color_sub")[0].value;
    if (color === "") {
        alert("请选择颜色");
    }
    if (version === "" || color === "") {
        return;
    }
    alert("即将发送post");
    var test = {name: document.getElementsByName("name_sub")[0].value,
        version: document.getElementsByName("version_sub")[0].value,
        color: document.getElementsByName("color_sub")[0].value};
    $.ajax({
        method: "POST",
        url: "alipay",
        async:false,
        data: {test : JSON.stringify(test)}
    })
        .done(function( msg ) {
            alert(msg);
            var div = document.createElement('div');
            div.innerHTML = msg; // html code
            document.body.appendChild(div.firstChild);
            document.forms.punchout_form.submit();
        });
}

function cart_check() {
    alert("2");
    document.getElementById("cart_hi").value="2";
}

function add_to_cart() {
    var version = document.getElementsByName("version_sub")[0].value;
    if (version === "") {
        alert("请选择版本");
    }
    var color = document.getElementsByName("color_sub")[0].value;
    if (color === "") {
        alert("请选择颜色");
    }
    if (version === "" || color === "") {
        return;
    }
    var test = {name: document.getElementsByName("name_sub")[0].value,
    version: document.getElementsByName("version_sub")[0].value,
    color: document.getElementsByName("color_sub")[0].value};
    $.ajax({
        method: "POST",
        url: "cart",
        async:false,
        data: {test : JSON.stringify(test)}
    })
        .done(function( msg ) {
            window.location.href = 'cart';
        });
}

function test() {
    alert("test");
    const test = {};
    $.ajax({
        method: "POST",
        url: "notify_url",
        async:false,
        data: {test : JSON.stringify(test)}
    })
        .done(function( msg ) {
            alert("post");
        });

}

function buy() {
    var version = document.getElementsByName("version_sub")[0].value;
    if (version === "") {
        alert("请选择版本");
    }
    var color = document.getElementsByName("color_sub")[0].value;
    if (color === "") {
        alert("请选择颜色");
    }
    if (version === "" || color === "") {
        return;
    }
    alert("version=" + version);
    var name = document.getElementsByName("name_sub")[0].value;
    var test = {name: name,
        version: version,
        color: color};
    $.ajax({
        method: "POST",
        url: "cart",
        async:false,
        data: {test : JSON.stringify(test)}
    })
        .done(function( msg ) {
            window.location.href = 'cart?buy=1&name=' + name + '&version=' + encodeURIComponent(version) + '&color=' + color;
        });
}