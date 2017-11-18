<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="lteBuildingFloorList" checkbox="true" pagination="true" fitColumns="true"
                    title="lte_building_floor" actionUrl="lteBuildingFloorController.do?datagrid" idField="id"
                    fit="true" queryMode="group">
            <t:dgCol title="ID" field="id" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="楼宇ID" field="buildingId" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="楼层名称" field="floorName" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="楼层编号" field="floorNo" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="楼层属性" field="floorProperty" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="创建人名称" field="createName" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="创建人登录名称" field="createBy" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd" hidden="true" queryMode="group"
                     width="120"></t:dgCol>
            <t:dgCol title="更新人名称" field="updateName" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="更新人登录名称" field="updateBy" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="更新日期" field="updateDate" formatter="yyyy-MM-dd" hidden="true" queryMode="group"
                     width="120"></t:dgCol>
            <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
            <t:dgDelOpt title="删除" url="lteBuildingFloorController.do?doDel&id={id}" urlclass="ace_button"
                        urlfont="fa-trash-o"/>
            <t:dgToolBar title="录入" icon="icon-add" url="lteBuildingFloorController.do?goAdd"
                         funname="add"></t:dgToolBar>
            <t:dgToolBar title="编辑" icon="icon-edit" url="lteBuildingFloorController.do?goUpdate"
                         funname="update"></t:dgToolBar>
            <t:dgToolBar title="批量删除" icon="icon-remove" url="lteBuildingFloorController.do?doBatchDel"
                         funname="deleteALLSelect"></t:dgToolBar>
            <t:dgToolBar title="查看" icon="icon-search" url="lteBuildingFloorController.do?goUpdate"
                         funname="detail"></t:dgToolBar>
            <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
            <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
            <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
            <t:dgToolBar title="测试导出Word" icon="icon-putout" funname="ExportWord"></t:dgToolBar>
        </t:datagrid>
    </div>
</div>
<script src="${webRoot}/webpage/com/lte/building/lteBuildingFloorList.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
    });


    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'lteBuildingFloorController.do?upload', "lteBuildingFloorList");
    }

    //导出
    function ExportXls() {
        JeecgExcelExport("lteBuildingFloorController.do?exportXls", "lteBuildingFloorList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("lteBuildingFloorController.do?exportXlsByT", "lteBuildingFloorList");
    }

    //测试导出
    function ExportWord() {
        $.ajax({
            dataType:"json",
            url : "lteBuildingFloorController.do?addExportWord",// 请求的action路径
            error : function() {// 请求失败处理函数
                alert("出错了");
                frameElement.api.close();
            },
            success : function(data) {
                var d = data;
                if (d.success) {
                    //document.getElementById("tableList").innerHTML.val(d.obj);
                    $('#tableList').html(d.obj);
                }else{
                    document.getElementById("tableList").innerHTML.val("");
                }
            }
        });
    }

</script>