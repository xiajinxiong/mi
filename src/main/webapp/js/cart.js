function add(e) {
    xiao_ji(e.parentElement.parentElement);
    var n1 = e.parentElement.parentElement.children[2];
    var name = n1.children[0].innerHTML,
        version = n1.children[1].innerHTML,
        color = n1.children[2].innerHTML;
    var test = {name: name, version: version, color: color};
    $.ajax({
        method: "POST",
        url: "cart?add=1",
        data: {test : JSON.stringify(test)}
    })
        .done(function( msg ) {
            e.parentElement.children[0].value = parseInt(e.parentElement.children[0].value) + 1;
        });
    zong_ji();

}

function del(e) {
    xiao_ji(e.parentElement.parentElement);
    var n1 = e.parentElement.parentElement.children[2];
    var name = n1.children[0].innerHTML,
        version = n1.children[1].innerHTML,
        color = n1.children[2].innerHTML;
    var test = {name: name, version: version, color: color};
    $.ajax({
        method: "POST",
        url: "cart?delete=1",
        data: {test : JSON.stringify(test)}
    })
        .done(function( msg ) {
            if (e.parentElement.children[0].value === "1") {
                e.parentNode.parentNode.parentNode.removeChild(e.parentNode.parentNode);
            }
            else  {
                e.parentElement.children[0].value = e.parentElement.children[0].value - 1;
            }

        });
    zong_ji();

}

function drop(e) {
    var n1 = e.parentElement.children[2];
    var name = n1.children[0].innerHTML,
        version = n1.children[1].innerHTML,
        color = n1.children[2].innerHTML;
    var test = {name: name, version: version, color: color};
    $.ajax({
        method: "POST",
        url: "cart?drop=1",
        data: {test : JSON.stringify(test)}
    })
        .done(function( msg ) {
            if (e.parentElement.children[0].value === "1") {
                e.parentNode.parentNode.removeChild(e.parentNode);
            }
            else  {
                e.parentNode.parentNode.removeChild(e.parentNode);
            }
            e.parentNode.removeChild(e);

        });
    zong_ji();
}

function pay() {
    const list = document.getElementsByClassName("quanxuan");
    const n = list.length;
    var test = [];
    for (let i = 1; i < n; i++) {
        if (list[i].checked === true) {
            const p = list[i].parentElement.parentElement.children[2];
            //alert("%" + list[i].parentElement.parentElement.children[2].children[0].innerHTML +
                //"%");
            var pri = p.parentElement.children[3].innerHTML;
            test.push({name: p.children[0].innerHTML, version: p.children[1].innerHTML, color: p.children[2].innerHTML,
            price: pri.substr(0, pri.length - 1), number: p.parentElement.children[4].children[0].value});
        }
    }
    $.ajax({
        method: "POST",
        url: "alipay",
        data: {test : JSON.stringify(test)}
    })
        .done(function( msg ) {
            //alert(msg);
            const div = document.createElement('div');
            div.innerHTML=msg;
            document.body.appendChild(div);
            document.forms.punchout_form.submit();
        });
}

function xiao_ji(e) {
    var price = e.children[3].innerHTML.substr(0, e.children[3].innerHTML.length - 1);
    var number = e.children[4].children[0].value;
    e.children[5].innerHTML = String(price * number ) + "元";
}

function zong_ji() {
    var t = 0;
    var contents = document.getElementsByClassName("content2 center");
    for (let i = 0; i < contents.length; i++) {
        if (contents[i].children[0].children[0].checked === true) {
            t += parseInt(contents[i].children[5].innerHTML.substr(0, contents[i].children[5].innerHTML.length));
            //alert(t);
        }
    }
    document.getElementById("total").innerText = t + "元";
}

function quan(e) {
    var b = document.getElementsByClassName("quanxuan");
    for (let i = 0; i < b.length; i++) {
        b[i].checked = e.checked;
    }
    zong_ji();
}