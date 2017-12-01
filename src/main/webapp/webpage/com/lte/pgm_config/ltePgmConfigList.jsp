<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ltePgmConfigList" checkbox="true" pagination="true" fitColumns="true" title="lte_pgm_config" actionUrl="ltePgmConfigController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="ID"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="ID"  field="taskId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="ID"  field="buildingId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="ID"  field="buildingFloorId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="pgm类型"  field="pgmType"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="pgm分辨率"  field="originX"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="原点x"  field="originY"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="原点y"  field="originZ"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="原点z"  field="resolution"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="negate"  field="negate"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="occupied_thresh"  field="occupiedThresh"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="free_thresh"  field="freeThresh"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="pgm宽"  field="pgmWidth"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="pgm高"  field="pgmHeight"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="ltePgmConfigController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ltePgmConfigController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ltePgmConfigController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ltePgmConfigController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ltePgmConfigController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/pgm_config/ltePgmConfigList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ltePgmConfigController.do?upload', "ltePgmConfigList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ltePgmConfigController.do?exportXls","ltePgmConfigList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ltePgmConfigController.do?exportXlsByT","ltePgmConfigList");
}

 </script>