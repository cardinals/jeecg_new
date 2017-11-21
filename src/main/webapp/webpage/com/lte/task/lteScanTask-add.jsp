<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>lte_scan_task</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript">
        //编写自定义JS代码
    </script>
</head>
<body>
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="lteScanTaskController.do?doAdd">
    <input id="id" name="id" type="hidden" value="${lteScanTaskPage.id }"/>
    <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
            <td align="right">
                <label class="Validform_label">
                    楼宇ID:
                </label>
            </td>
            <td class="value">
                <input id="buildingId" name="buildingId" type="text" style="width: 150px" class="inputxt" datatype="n"
                       ignore="checked"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">楼宇ID</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    任务名称:
                </label>
            </td>
            <td class="value">
                <input id="taskName" name="taskName" type="text" style="width: 150px" class="inputxt" ignore="ignore"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">任务名称</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    任务编号:
                </label>
            </td>
            <td class="value">
                <input id="taskNo" name="taskNo" type="text" style="width: 150px" class="inputxt" ignore="ignore"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">任务编号</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    任务状态:
                </label>
            </td>
            <td class="value">
                <input id="taskStatus" name="taskStatus" type="text" style="width: 150px" class="inputxt" datatype="n"
                       ignore="checked"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">任务状态</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    报告状态:
                </label>
            </td>
            <td class="value">
                <input id="reportStatus" name="reportStatus" type="text" style="width: 150px" class="inputxt"
                       datatype="n" ignore="checked"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">报告状态</label>
            </td>
        </tr>


        <tr>
            <td align="right">
                <label class="Validform_label">
                    任务备注:
                </label>
            </td>
            <td class="value">
                <textarea style="width:600px;" class="inputxt" rows="10" id="note" name="note"
                          ignore="ignore"></textarea>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">任务备注</label>
            </td>
        </tr>
    </table>
</t:formvalid>
<t:datagrid name="lteBuildingList" checkbox="true" pagination="true" fitColumns="true" title="lte_building"
            actionUrl="lteBuildingController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="ID" field="id" hidden="true" queryMode="group" width="120"></t:dgCol>
    <t:dgCol title="楼宇名称" field="buildingName" queryMode="group" width="120"></t:dgCol>
    <t:dgCol title="楼宇编号" field="buildingNo" queryMode="group" width="120"></t:dgCol>
    <t:dgCol title="楼宇类型" field="buildingType" queryMode="group" width="120"></t:dgCol>
    <t:dgCol title="楼宇属性" field="buildingProperty" queryMode="group" width="120"></t:dgCol>
    <t:dgCol title="楼宇描述" field="description" hidden="true" queryMode="group" width="500"></t:dgCol>
    <t:dgCol title="楼宇备注" field="note" hidden="true" queryMode="group" width="500"></t:dgCol>
    <t:dgCol title="创建人名称" field="createName" hidden="true" queryMode="group" width="120"></t:dgCol>
    <t:dgCol title="创建人登录名称" field="createBy" hidden="true" queryMode="group" width="120"></t:dgCol>
    <t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd" hidden="true" queryMode="group"
             width="120"></t:dgCol>
    <t:dgCol title="更新人名称" field="updateName" hidden="true" queryMode="group" width="120"></t:dgCol>
    <t:dgCol title="更新人登录名称" field="updateBy" hidden="true" queryMode="group" width="120"></t:dgCol>
    <t:dgCol title="更新日期" field="updateDate" formatter="yyyy-MM-dd" hidden="true" queryMode="group"
             width="120"></t:dgCol>
    <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
    <t:dgDelOpt title="删除" url="lteBuildingController.do?doDel&id={id}" urlclass="ace_button"
                urlfont="fa-trash-o"/>
    <t:dgToolBar title="录入" icon="icon-add" url="lteBuildingController.do?goAdd" funname="add"></t:dgToolBar>
    <t:dgToolBar title="编辑" icon="icon-edit" url="lteBuildingController.do?goUpdate"
                 funname="update"></t:dgToolBar>
    <t:dgToolBar title="批量删除" icon="icon-remove" url="lteBuildingController.do?doBatchDel"
                 funname="deleteALLSelect"></t:dgToolBar>
    <t:dgToolBar title="查看" icon="icon-search" url="lteBuildingController.do?goUpdate"
                 funname="detail"></t:dgToolBar>
    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
</t:datagrid>
</body>
<script src="${webRoot}/webpage/com/lte/task/lteScanTask.js"></script>
