function logout() {
    $.ajax({
        method: "POST",
        url: "logout",
        data: {test: "logout"}
    })
        .done(function( msg ) {
            if (msg === "s") {
                window.location.href="/mi_war_exploded";
            }
        });
}