function updateUserInfo1() {
    var data = $("#updateUserInfo").serialize();
    if ($("#phone").val() == "") {
        alert("手机号不能为空，请填写！")
    } else if ($("#name").val() == "") {
        alert("姓名不能为空，请填写！")
    } else if ($("#idcard").val() == "") {
        alert("身份证号不能为空，请填写！")
    } else {
        $.ajax({
            url: "/patient/update/Info",
            type: "post",
            data: data,
            success: function (data) {
                alert("修改成功")
                window.location.reload();
            },
            error: function (data) {
                alert("修改失败");
            }
        });
    }
}


function updateDocInfo1() {
    var data = $("#updateDocInfo").serialize();
    alert("jina;");
    if ($("#docId").val() == "") {
        alert("手机号不能为空，请填写！")
    } else if ($("#name").val() == "") {
        alert("姓名不能为空，请填写！")
    } else if ($("#intro").val() == "") {
        alert("简介不能为空，请填写！")
    } else if ($("#idcard").val() == "") {
        alert("身份证号不能为空，请填写！")
    } else if ($("#age").val() == "") {
        alert("年龄不能为空，请填写！")
    } else {
        $.ajax({
            url: "/doctor/update/Info",
            type: "post",
            data: data,
            success: function (data) {
                if (data === true) {
                    alert("修改成功");
                    window.location.reload();
                } else {
                    alert("修改失败");
                }
            }
        });
    }
}

function updateAdmin1() {
    var data = $("#updateAdminInfo").serialize();
    alert("jina;");
    if ($("#adminId").val() == "") {
        alert("手机号不能为空，请填写！")
    } else if ($("#adminName").val() == "") {
        alert("姓名不能为空，请填写！")
    } else if ($("#adminID").val() == "") {
        alert("身份证号不能为空，请填写！")
    } else {
        $.ajax({
            url: "/admin/update/Info",
            type: "post",
            data: data,
            success: function (data) {
                if (data === true) {
                    alert("修改成功");
                    window.location.reload();
                } else {
                    alert("修改失败");
                }
            }
        });
    }
}