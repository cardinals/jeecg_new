<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>lte_scan_trail</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="lteScanTrailController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${lteScanTrailPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							楼宇ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="buildingId" name="buildingId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">楼宇ID</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							楼层ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="buildingFloorId" name="buildingFloorId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">楼层ID</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							任务ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="taskId" name="taskId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">任务ID</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							时间戳:
						</label>
					</td>
					<td class="value">
					     	 <input id="trailTimestamp" name="trailTimestamp" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">时间戳</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							年:
						</label>
					</td>
					<td class="value">
					     	 <input id="trailYear" name="trailYear" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							月:
						</label>
					</td>
					<td class="value">
					     	 <input id="trailMonth" name="trailMonth" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">月</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							日:
						</label>
					</td>
					<td class="value">
					     	 <input id="trailDay" name="trailDay" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">日</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							时:
						</label>
					</td>
					<td class="value">
					     	 <input id="trailHour" name="trailHour" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">时</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							分:
						</label>
					</td>
					<td class="value">
					     	 <input id="trailMinute" name="trailMinute" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							秒:
						</label>
					</td>
					<td class="value">
					     	 <input id="trailSecond" name="trailSecond" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">秒</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							x坐标:
						</label>
					</td>
					<td class="value">
					     	 <input id="trailX" name="trailX" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">x坐标</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							y坐标:
						</label>
					</td>
					<td class="value">
					     	 <input id="trailY" name="trailY" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">y坐标</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							x坐标:
						</label>
					</td>
					<td class="value">
					     	 <input id="picX" name="picX" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">x坐标</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							y坐标:
						</label>
					</td>
					<td class="value">
					     	 <input id="picY" name="picY" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">y坐标</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建人名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="createName" name="createName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建人登录名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="createBy" name="createBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人登录名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建日期:
						</label>
					</td>
					<td class="value">
							   <input id="createDate" name="createDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							更新人名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="updateName" name="updateName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							更新人登录名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="updateBy" name="updateBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人登录名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							更新日期:
						</label>
					</td>
					<td class="value">
							   <input id="updateDate" name="updateDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新日期</label>
						</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/scan_trail/lteScanTrail.js"></script>		
