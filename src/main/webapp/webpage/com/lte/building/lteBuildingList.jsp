<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
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
    </div>
</div>
<script src="${webRoot}/webpage/com/lte/building/lteBuildingList.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
    });


    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'lteBuildingController.do?upload', "lteBuildingList");
    }

    //导出
    function ExportXls() {
        JeecgExcelExport("lteBuildingController.do?exportXls", "lteBuildingList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("lteBuildingController.do?exportXlsByT", "lteBuildingList");
    }

</script>