<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="lteScanTaskList" checkbox="true" pagination="true" fitColumns="true" title="lte_scan_task"
                    actionUrl="lteScanTaskController.do?datagrid" idField="id" fit="true" queryMode="group">
            <t:dgCol title="ID" field="id" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="楼宇ID" field="buildingId" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="任务名称" field="taskName" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="任务编号" field="taskNo" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="任务状态" field="taskStatus" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="报告状态" field="reportStatus" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="任务备注" field="note" hidden="true" queryMode="group" width="500"></t:dgCol>
            <t:dgCol title="创建人名称" field="createName" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="创建人登录名称" field="createBy" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd" hidden="true" queryMode="group"
                     width="120"></t:dgCol>
            <t:dgCol title="更新人名称" field="updateName" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="更新人登录名称" field="updateBy" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="更新日期" field="updateDate" formatter="yyyy-MM-dd" hidden="true" queryMode="group"
                     width="120"></t:dgCol>
            <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
            <t:dgDelOpt title="删除" url="lteScanTaskController.do?doDel&id={id}" urlclass="ace_button"
                        urlfont="fa-trash-o"/>
            <t:dgToolBar title="录入" icon="icon-add" url="lteScanTaskController.do?goAdd" funname="add"></t:dgToolBar>
            <t:dgToolBar title="编辑" icon="icon-edit" url="lteScanTaskController.do?goUpdate"
                         funname="update"></t:dgToolBar>
            <t:dgToolBar title="批量删除" icon="icon-remove" url="lteScanTaskController.do?doBatchDel"
                         funname="deleteALLSelect"></t:dgToolBar>
            <t:dgToolBar title="查看" icon="icon-search" url="lteScanTaskController.do?goUpdate"
                         funname="detail"></t:dgToolBar>
            <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
            <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
            <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
            <t:dgToolBar title="生成Word" icon="icon-putout" onclick="createWord()"></t:dgToolBar>
            <t:dgToolBar title="下载Word" icon="icon-putout" onclick="downWord()"></t:dgToolBar>
        </t:datagrid>
    </div>
</div>
<script src="${webRoot}/webpage/com/lte/task/lteScanTaskList.js"></script>
<script type="text/javascript">
    function createWord() {
        var selectRow = $("#lteScanTaskList").datagrid("getSelected");
        if(selectRow == undefined || selectRow == null){
            alert("请选择一行数据");
            return false;
        }
        var taskId = selectRow.id;
        $.ajax({
            url: "lteScanTaskController.do?createWord",
            data: {
                taskId: taskId,
                fileName:'报告模板v2.docx'
            },
            success: function (msg) {
            }
        });
    }

    function downWord() {
        var selectRow = $("#lteScanTaskList").datagrid("getSelected");
        if(selectRow == undefined || selectRow == null){
            alert("请选择一行数据");
            return false;
        }
        var taskId = selectRow.id;
        window.location.href = 'lteScanTaskController.do?downWord&taskId=' + taskId;
//        var frm = $("#wordForm");
//        frm.attr("action", "lteScanTaskController.do?downWord");
//        frm.submit();
    }

    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'lteScanTaskController.do?upload', "lteScanTaskList");
    }

    //导出
    function ExportXls() {
        JeecgExcelExport("lteScanTaskController.do?exportXls", "lteScanTaskList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("lteScanTaskController.do?exportXlsByT", "lteScanTaskList");
    }

</script>