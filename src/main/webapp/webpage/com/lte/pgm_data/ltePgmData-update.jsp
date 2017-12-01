<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>lte_pgm_data</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ltePgmDataController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${ltePgmDataPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								pgm编号:
							</label>
						</td>
						<td class="value">
						     	 <input id="pgmConfigId" name="pgmConfigId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${ltePgmDataPage.pgmConfigId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">pgm编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								任务编号:
							</label>
						</td>
						<td class="value">
						     	 <input id="taskId" name="taskId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${ltePgmDataPage.taskId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">任务编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								楼宇ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="buildingId" name="buildingId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${ltePgmDataPage.buildingId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">楼宇ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								楼层ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="buildingFloorId" name="buildingFloorId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${ltePgmDataPage.buildingFloorId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">楼层ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建人名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="createName" name="createName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ltePgmDataPage.createName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建人登录名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="createBy" name="createBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ltePgmDataPage.createBy}'/>
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
									  <input id="createDate" name="createDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${ltePgmDataPage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								更新人名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="updateName" name="updateName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ltePgmDataPage.updateName}'/>
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
						     	 <input id="updateBy" name="updateBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ltePgmDataPage.updateBy}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人登录名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								更新日期:
							</label>
						</td>
						<td class="value">
									  <input id="updateDate" name="updateDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${ltePgmDataPage.updateDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新日期</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								每一行数据:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="pgmData" style="width:600px;" class="inputxt" rows="6" name="pgmData"  ignore="ignore" >${ltePgmDataPage.pgmData}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">每一行数据</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/pgm_data/ltePgmData.js"></script>		
