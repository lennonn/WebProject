function getRootPath() {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    //生产环境 没有项目名称
   // var projectName = '';
    return (localhostPaht + projectName);
}

var setting = {
    view: {
        addHoverDom: addHoverDom,
        selectedMulti: false
    },
    check: {
        enable: true
    },
    data: {
        simpleData: {
            enable: true
        }
    },
    edit: {
        enable: true,
        showRemoveBtn: showRemoveBtn,
        showRenameBtn:showRenameBtn
    },
    callback: {
        beforeRemove: beforeRemove,
        onRemove:onRemove,
        onClick: onClick
    }
};




 function init(selectId) {

     $.ajax({
         url:getRootPath()+"/sysMenu/getMenuTree",
         type:"post",
         success:function(data) {
             $.fn.zTree.init($("#treeDemo"), setting, data);
debugger;
             var zTree = $.fn.zTree.getZTreeObj("treeDemo");
             var node = zTree.getNodeByParam("id", selectId, null); //根据新的id找到新添加的节点
             node.open=true;
            // zTree.updateNode(node);
             zTree.selectNode(node);
         }

     });
 }
$(document).ready(function () {
    init();
});
function onClick(event, treeId, treeNode, clickFlag) {

    $.ajax({
        url:getRootPath()+"/sysMenu/getMenuNodeById",
        type:"post",
        dataType:"json",
        data:{"menuId":treeNode.id},
        success:function(data) {
            var curr =data.curr;
            var parent =data.parent;
            if(parent==null){
                $("#parentName").val("无");
                $("#parentId").val("0");
            }else{
                $("#parentName").val(parent.menuName);
                $("#parentId").val(parent.menuId);
            }
            debugger;
            $("#menuName").val(curr.menuName);
            $("#menuUrl").val(curr.menuUrl);
            $("#menuId").val(curr.menuId);
            $("#menuOrder").val(curr.menuOrder);
        }
    });
}
function addHoverDom(treeId, treeNode) {
   var sObj = $("#" + treeNode.tId + "_span");
    if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
        + "' title='add node' onfocus='this.blur();'></span>";
    sObj.after(addStr);
    var btn = $("#addBtn_"+treeNode.tId);
    if (btn) btn.bind("click", function(){
        $.ajax({
            url:getRootPath()+"/sysMenu/getMenuNodeById",
            type:"post",
            dataType:"json",
            data:{"menuId":treeNode.id},
            success:function(data) {
                var curr =data.curr;
                var parent =data.parent;
                $("#operMenu input").attr("value","");
                    $("#parentName").val(curr.menuName);
                    $("#parentId").val(curr.menuId);
                    $("#menuOrder").val(data.menuCode);
            }
        });
            return false;
    });
};
/*function removeHoverDom(treeId, treeNode) {
    $.ajax({
        url: getRootPath()+"/sysMenu/deleteMenuById",
        dataType:"json",
        data:{"menuId":treeNode.id},
        type:"post",
        success: function (result) {
            alert(result.success);
            init();
        }
    });
    return false;
};*/

function onRemove(e, treeId, treeNode) {
    $.ajax({
        url: getRootPath()+"/sysMenu/deleteMenuById",
        dataType:"json",
        data:{"menuId":treeNode.id},
        type:"post",
        success: function (result) {
            alert(result.success);
            init(result.parentId);
        }
    });
    return false;
}

function showRemoveBtn(treeId, treeNode) {
    return true;
}

function showRenameBtn(treeId, treeNode) {
    return false;
}

function beforeRemove(treeId, treeNode) {
    return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
}