//父单选框
var fatherCheckBox = document.getElementsByName("father_check");
//子单选框
var checkBox = document.getElementsByName("check");

//父单选框点击事件
$(fatherCheckBox).change(function() {
    if ($(fatherCheckBox).prop('checked')) {
        for (var i = 0; i < checkBox.length; i++) {
            $(checkBox[i]).prop("checked",true);
        }
    } else{
        for (var i = 0; i < checkBox.length; i++) {
            $(checkBox[i]).prop("checked",false);
        }
    }
});

//子单选框点击事件
$(checkBox).change(function() {
    var count = 0;
    for (var i = 0; i < checkBox.length; i++) {
        if ($(checkBox[i]).is(":checked")) {
            count++;
        }
    }
    if (count !== checkBox.length) {
        $(fatherCheckBox).prop("checked",false);
    } else {
        $(fatherCheckBox).prop("checked",true);
    }
});

//叉图片事件
var cancelImg = document.getElementById('imgCancel');
cancelImg.onclick = function() {
    document.getElementById("all").style.display = "none";
};

//取消按钮事件
var cancelBtn = document.getElementById('cancel');
cancelBtn.onclick = function() {
    $("#number").attr("readOnly",false);
    $("#name").attr("readOnly",false);
    $("#college").attr("readOnly",false);
    $("#profession").attr("readOnly",false);
    $("#class").attr("readOnly",false);
    $("#old").attr("readOnly",false);
    document.getElementById("updatedefine").style.display = "none";
    document.getElementById("define").style.display = "none";
    document.getElementById("all").style.display = "none";
};

//新增按钮事件
var newBtn = document.getElementById('new');
newBtn.onclick = function() {
    document.getElementById('number').value = "";
    document.getElementById('name').value = "";
    document.getElementById('college').value = "";
    document.getElementById('profession').value = "";
    document.getElementById('grade').value = "";
    document.getElementById('class').value = "";
    document.getElementById('old').value = "";
    document.getElementById('inTitle').innerHTML = "新增教师信息";
    document.getElementById("define").style.display = "inline";
    document.getElementById("all").style.display = "block";
};

//新增确定按钮事件
var defineBtn = document.getElementById('define');
defineBtn.onclick = function() {
    if(confirm("您确定新增么?")) {
        document.getElementById("define").style.display = "none";
        document.getElementById("all").style.display = "none";
    } else {
        //Do something
    }
};

//修改按钮事件
var changeBtn = document.getElementById('change');
changeBtn.onclick = function() {
    var count = 0;
    for (var i = 0; i < checkBox.length; i++) {
        if ($(checkBox[i]).is(":checked")) {
            count++;
        }
    }
    if (count === 1) {
        for (var i = 0; i < checkBox.length; i++) {
            if ($(checkBox[i]).is(":checked")) {
                document.getElementById('inTitle').innerHTML = "修改学生信息";
                var table = document.getElementById("tableId");
                var rows = table.rows;//获取所有行
                var row = rows[i + 1];//获取每一行
                for (var i = 1; i < 8; i++) {
                    var id = row.cells[i].innerHTML;//获取具体单元格
                    switch (i) {
                        case 1: {
                            document.getElementById('number').value = id;
                            $("#number").attr("readOnly", true);
                            break;
                        }
                        case 2: {
                            document.getElementById('name').value = id;
                            break;
                        }
                        case 3: {
                            document.getElementById('college').value = id;
                            break;
                        }
                        case 4: {
                            document.getElementById('profession').value = id;
                            break;
                        }
                        case 5: {
                            document.getElementById('grade').value = id;
                            break;
                        }
                        case 6: {
                            document.getElementById('class').value = id;
                            break;
                        }
                        case 7: {
                            document.getElementById('old').value = id;
                            break;
                        }
                    }
                    document.getElementById("all").style.display = "block";
                    document.getElementById("updatedefine").style.display = "inline";
                }
            }
        }
    } else {
        alert("请只勾选一列");
    }
};

//修改确定按钮事件
$('#updatedefine').on('click',function(){
    if(confirm("您确定修改么?")) {
        document.getElementById("updatedefine").style.display = "none";
        document.getElementById("all").style.display = "none";
    } else {
        //Do something
    }
});