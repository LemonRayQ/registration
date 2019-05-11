function register2() {
    var data = $("#loginData").serialize();

    $.ajax({
        url: "/toRegister",
        type: "post",
        data: data,
        success: function (data) {
            switch (data) {
                case 2:
                    alert("管理员无法注册！")
                    window.location.href = '/login';
                    break;
                default:
                    window.location.href = '/register?identity=' + data;
                    break;
            }
        }
    });
}
