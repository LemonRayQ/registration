function selectDocByDeptId(obj) {
    var dept_id = obj.id;
    $.ajax({
        url: "/patient/selectDocByDeptId?deptId=" + dept_id,
        type: "post",
        success: showQuery,
        error: function () {
            alert("查询出错");
        }
    });
}

function showQuery(data) {
    var list = data.list;
    var length = list.length;
    var patientId = data.patientId;
    alert("patientId1:" + patientId);
    var item = "";
    for (var i = 0; i < length; i++) {
        var docId = list[i].id;
        item += "<div class='modal-body-item' >" +
            "<div class='modal-body-left'>" +
            "<div class='media'>" +
            "<div class='media-body' id='introduce' >" +
            "<h4 class='media-heading' id='docName'>" + list[i].name + "</h4>" +
            list[i].intro +
            "</div>" +
            "</div>" +
            "</div>" +
            "<div class='modal-body-right'>" +
            "<Button class='btn btn-success' id='" + list[i].id + "' name ='patientId' value='" + patientId + "' onclick='chooseDoctor(this)' >" + "确认" + "</Button>" +
            "</div>" +
            "</div>"
    }
    $("#queryDoctorByDeptId").html(item);
}

function chooseDoctor(obj) {
    var patientId = obj.value;
    docId = obj.id;
    alert("docId" + docId)
    alert("patientId" + patientId)
    $.ajax({
            url: "/patient/chooseDoc?docId=" + docId + "&pId=" + patientId,
            type: "post",
            success: function (data) {
                alert("挂号成功");
                $("#model").modal("hide");
            },
            error: function () {
                alert("挂号失败");
            }
        }
    );
}

function submitFeedBack1() {
    var data = $("#feedBack").serialize();
    $.ajax({
        url: "/patient/submitFeedBack",
        type: "post",
        data: data,
        dataType: "JSON",
        success: function (data) {
            if (data.status === "yes") {
                alert("提交成功")
            } else {
                alert("提交失败，请先选择医生挂号！")
            }
        }

    });
}

function writeIllness(obj) {
    var id = obj.id;
    alert(id);
    $.ajax({
        url: "/doctor/writeIllness?pId=" + id,
        type: "post",
        success: function (data) {
        }
    });
}

function submitIllness(obj) {
    var content = $("#illnessContent").val();
    $.ajax({
        url: "/doctor/submitIllness",
        type: "post",
        data: {content: content},
        success: function (data) {
            alert("编写成功");
            $('#submitIllness').modal('hide');
        }
    });

}

function showFeedBack1(obj) {
    var id = obj.id;
    alert(id);
    $.ajax({
        url: "/doctor/showFeedBack?pId=" + id,
        type: "post",
        success: function (data) {
            var item = "";
            item += data.content;
            $("#feedBackContent").html(item);
            alert("查询成功");
        }
    });
}



