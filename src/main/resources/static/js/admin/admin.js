function selectDocByDid(obj) {
    alert("aasa");
    var deptId = obj.id;
    alert("deptId" + deptId);
    $.ajax({
        url: "/admin/selectDocByDeptId",
        type: "post",
        data: {id: deptId},
        success: showQuery,
        error: function () {
            alert("查询出错");
        }
    });
}

function showQuery(data) {
    var infos = data.infos;
    var length = infos.length;
    var dept = data.depts;
    var length1 = dept.length;
    var item1 = ""
    for (var i = 0; i < length1; i++) {
        var id = dept[i].id;
        var name = dept[i].name;
        item1 += "<option  " +
            "value='" + id + "'  >" + name +
            "</option>";
    }
    alert(infos.length);
    var item = "";
    for (var i = 0; i < length; i++) {
        var docId = infos[i].id;
        item += "<div class = 'modal-body-item' >" +
            "<div class = 'panel panel-default' >" +
            " <div class = 'panel-heading' role = 'tab' id = 'headingOne' >" +
            "<div class = 'media' >" +
            "<div class='media-body'>" +
            "<h4 class='media-heading'>" +
            "<a role='button' data-toggle='collapse' data-parent='#accordion' " +
            "href='#collapseOne' aria-expanded='true' aria-controls='collapseOne' >" +
            infos[i].name +
            "</a>" +
            "</h4>" +
            "<p >" +
            infos[i].intro +
            "</p>" +
            "</div>" +
            "<button type='button' class='btn btn-primary' onclick='updateDoc(" + infos[i].id + ")'>" + "修改" +
            "</button>" + "<button type='button' class='btn btn-danger' onclick='deleteDoc(" + infos[i].id + ")'>" + "删除" + "</button>" +
            "</div>" +
            "</div>" +
            "<div id='collapseOne' class='panel-collapse collapse '" +
            "role='tabpanel' aria-labelledby='headingOne'>" +
            "<div class='panel-body'>" +
            "<div class='btn-group'>" +
            "科室选择:" +
            "<select name='deptName' id='selectDept'>" +
            item1 +
            "</select>" +
            "</div>" +
            "</div>" +
            "</div>"
        "</div>" +
        "</div>"
    }
    $("#adminQuery").html(item);

}

function updateDoc(docId) {
    var dept = $("#selectDept option:selected");
    deptId = dept.val();
    alert(docId);
    $.ajax({
        url: "/admin/updateDoc",
        type: "post",
        data: {id: deptId, docId: docId},
        success: function (data) {
            alert("修改成功");
            $("#deptModel").modal('hide');
        },
        error: function () {
            alert("修改失败");
        }
    });

}

function deleteDoc(docId) {
    $.ajax({
        url: "/admin/deleteDoc",
        type: "post",
        data: {docId: docId},
        success: function (data) {
            if (data == true) {
                alert("删除成功");
            } else {
                alert("删除失败")
            }

            $("#deptModel").modal('hide');
        }

    });
}

function insert() {
    var data = $("#insertDocForm").serialize();
    $.ajax({
        url: "/admin/insertDoc",
        type: "post",
        data: data,
        success: function (data) {
            if (data == true) {
                alert("添加医生成功");
            } else {
                alert("添加医生失败");
            }
        }
    });
}

function passVerify(obj) {


    var docId = obj.id;
    $.ajax({
        url: "/admin/verify",
        type: "post",
        data: {docId: docId, msg: "true"},
        success: function (data) {
            if (data == true) {
                alert("审核成功")
                window.location.reload();
            } else {
                alert("审核失败")
            }
        }
    });

}

function refuseVerify(obj) {
    var docId = obj.id;
    $.ajax({
        url: "/admin/verify",
        type: "post",
        data: {docId: docId, msg: "false"},
        success: function (data) {
            if (data == true) {
                alert("拒绝成功")
                window.location.reload();
            } else {
                alert("拒绝失败")
            }
        }
    });
}
