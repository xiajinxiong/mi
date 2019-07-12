function disable_readonly(e) {
    var list = document.getElementsByTagName("input");
    if (e.value === "编辑") {
        e.value="保存";
        for (var i = 2; i <= 7; i++) {
            list[i].readOnly = false;
        }
    }
    else {
        var test = { nickName: list[2].value, phone: list[3].value ,
        pword: list[4].value, signature: list[5].value, "hobby": list[6].value, "address": list[7].value};
        $.ajax({
            method: "POST",
            url: "profile",
            data: {test : JSON.stringify(test)}
        })
            .done(function( msg ) {
                e.value="编辑";
                for (var i = 2; i <= 7; i++) {
                    list[i].readOnly = true;
                }
            });
    }
}


