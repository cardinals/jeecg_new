<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="lteDataList" checkbox="true" pagination="true" fitColumns="true" title="lte_data" actionUrl="lteDataController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="ID"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="楼宇ID"  field="buildingId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="楼层ID"  field="buildingFloorId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="任务ID"  field="taskId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="CGI字符串"  field="lteCgiNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="CGI"  field="lteCgi"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="RSRP指标"  field="lteRsrp"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="SINR指标"  field="lteSinr"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="时间戳"  field="dataTimestamp"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="年"  field="dataYear"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="月"  field="dataMonth"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="日"  field="dataDay"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="时"  field="dataHour"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="分"  field="dataMinute"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="秒"  field="dataSecond"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="lteDataController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="lteDataController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="lteDataController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="lteDataController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="lteDataController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/lte_data/lteDataList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'lteDataController.do?upload', "lteDataList");
}

//导出
function ExportXls() {
	JeecgExcelExport("lteDataController.do?exportXls","lteDataList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("lteDataController.do?exportXlsByT","lteDataList");
}

 </script>