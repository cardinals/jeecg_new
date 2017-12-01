<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>lte_data</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="lteDataController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${lteDataPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								楼宇ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="buildingId" name="buildingId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${lteDataPage.buildingId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">楼宇ID</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								楼层ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="buildingFloorId" name="buildingFloorId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${lteDataPage.buildingFloorId}'/>
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
						     	 <input id="taskId" name="taskId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${lteDataPage.taskId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">任务ID</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								CGI字符串:
							</label>
						</td>
						<td class="value">
						     	 <input id="lteCgiNo" name="lteCgiNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${lteDataPage.lteCgiNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">CGI字符串</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								CGI:
							</label>
						</td>
						<td class="value">
						     	 <input id="lteCgi" name="lteCgi" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${lteDataPage.lteCgi}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">CGI</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								RSRP指标:
							</label>
						</td>
						<td class="value">
						     	 <input id="lteRsrp" name="lteRsrp" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${lteDataPage.lteRsrp}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">RSRP指标</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								SINR指标:
							</label>
						</td>
						<td class="value">
						     	 <input id="lteSinr" name="lteSinr" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${lteDataPage.lteSinr}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">SINR指标</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								时间戳:
							</label>
						</td>
						<td class="value">
						     	 <input id="dataTimestamp" name="dataTimestamp" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${lteDataPage.dataTimestamp}'/>
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
						     	 <input id="dataYear" name="dataYear" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${lteDataPage.dataYear}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								月:
							</label>
						</td>
						<td class="value">
						     	 <input id="dataMonth" name="dataMonth" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${lteDataPage.dataMonth}'/>
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
						     	 <input id="dataDay" name="dataDay" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${lteDataPage.dataDay}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">日</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								时:
							</label>
						</td>
						<td class="value">
						     	 <input id="dataHour" name="dataHour" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${lteDataPage.dataHour}'/>
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
						     	 <input id="dataMinute" name="dataMinute" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${lteDataPage.dataMinute}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								秒:
							</label>
						</td>
						<td class="value">
						     	 <input id="dataSecond" name="dataSecond" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${lteDataPage.dataSecond}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">秒</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建人名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="createName" name="createName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${lteDataPage.createName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建人登录名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="createBy" name="createBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${lteDataPage.createBy}'/>
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
									  <input id="createDate" name="createDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${lteDataPage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								更新人名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="updateName" name="updateName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${lteDataPage.updateName}'/>
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
						     	 <input id="updateBy" name="updateBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${lteDataPage.updateBy}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人登录名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								更新日期:
							</label>
						</td>
						<td class="value">
									  <input id="updateDate" name="updateDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${lteDataPage.updateDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新日期</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/lte_data/lteData.js"></script>		
