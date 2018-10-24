<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>��������</title>

</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body>
<div class="row">
    <div class="col-md-12">
        <table id="sysOperationTable"></table>
        <div id="toolbar">
            <div class="btn-group">
                <button class="btn btn-block btn-info" data-toggle="modal" data-target="#modal-default">
                    <i class="fa fa-plus-square">���</i>
                </button>
            </div>
        </div>
        <div class="modal fade" id="modal-default">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">�������</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id ="sysOperationForm">

                            <input type="hidden" name="id" id="id" value="">
                             <div class="form-group">
                             </div>
                             <div class="form-group">
                                    <label for="odesc" class="col-sm-2 control-label">��������</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="odesc" name="odesc" placeholder="�������������"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="oname" class="col-sm-2 control-label">��������</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="oname" name="oname" placeholder="�������������"/>
                                    </div>
                             </div>
                             <div class="form-group">
                                    <label for="oper" class="col-sm-2 control-label">������־</label>
                                    <div class="col-xs-6">
                                        <input class="form-control" id="oper" name="oper" placeholder="�����������־"/>
                                    </div>
                             </div>
                        </form>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">�ر�</button>
                        <button type="button" class="btn btn-primary" onclick="_save();">�����ύ</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>

    </div>
</div>

<script type="text/javascript">
    $(function(){
        var oTable = new TableInit();
        oTable.Init();
    });
    var TableInit = function () {
        var oTableInit = new Object();
        //��ʼ��Table
        oTableInit.Init = function () {
            $('#sysOperationTable').bootstrapTable({
                url: '${pageContext.request.contextPath}/sysOperation/initTable',         //�����̨��URL��*��
                striped: true,  //�����ʾ����
                method: 'get',
                pagination: true, //������ҳ
                toolbar: "#toolbar",                //���߰�ť���ĸ�����
                pageSize: 10,  //ÿҳ��ʾ�ļ�¼��
                pageNumber: 1, //��ǰ�ڼ�ҳ
                pageList: [30, 40, 80],  //��¼����ѡ�б�
                search: true,  //�Ƿ����ò�ѯ
                showColumns: true,  //��ʾ������ѡҪ��ʾ����
                showRefresh: true,  //��ʾˢ�°�ť
                sidePagination: "server", //��ʾ���������
                //����Ϊundefined���Ի�ȡpageNumber��pageSize��searchText��sortName��sortOrder
                //����Ϊlimit���Ի�ȡlimit, offset, search, sort, order
                //queryParamsType: "undefined",
                queryParamsType : 'undefined',
                queryParams: function queryParams(params) {   //���ò�ѯ����
                    var param = {
                        pageNumber: params.pageNumber,
                        pageSize: params.pageSize,
                        searchText:params.searchText
                    };
                    return param;
                },
                columns: [
                    {checkbox: true},
                    {field: 'oname', title: '��������', sortable: true},
                    {field: 'odesc', title: '��������', sortable: true},
                    {field: 'oper', title: '������־', sortable: true},
                    {field: 'button', title: '����', events: "operateEvents", formatter: operateFormatter}
                    ],
                onLoadSuccess: function () {  //���سɹ�ʱִ��
                    // alert("���سɹ�");
                },
                onLoadError: function () {  //����ʧ��ʱִ��
                    // alert("��������ʧ��");
                }
            });
        };
        return oTableInit;
    };


    function operateFormatter(value, row, index) {
        return [
            '<button type="button" class="edit btn btn-info btn-xs" > <i class="fa fa-edit">�༭</i></button>',
            '<button type="button" class="delete btn btn-info btn-xs" > <i class="fa  fa-remove">ɾ��</i></button>'
        ].join('');
    }
    function test(value, row, index){
        debugger;
    }

    window.operateEvents = {
        'click .edit': function (e, value, row, index) {
            $("#sysOperationForm").find(':input').each(function () {
                var  name= $(this).attr("name");
                debugger;
                $("#"+name).val(row[name]);
            });
            $("#modal-default").modal('show');
        },
        'click .delete': function (e, value, row, index) {
            $.ajax({
                url:"${pageContext.request.contextPath}/sysOperation/delete?id="+row.id,
                type: "post",
                dataType: "json",
                success: function (res) {
                    alert(res.msg);
                    getContent('${pageContext.request.contextPath}/sysOperation/list');//ˢ��ds_table������
                }
            });
        }
    };

    function _save() {
        var  data = $("#sysOperationForm").serialize();
        $.ajax({
            url:"${pageContext.request.contextPath}/sysOperation/save",
            type: "post",
            data:data,
            dataType: "json",
            success: function (res) {
                alert(res.msg);
                $("#modal-default").modal('toggle');
                getContent('${pageContext.request.contextPath}/sysOperation/list');
                // $('body').removeClass('modal-open');
                $('.modal-backdrop').remove();
            }
        });
    }
</script>
</body>
</html>
