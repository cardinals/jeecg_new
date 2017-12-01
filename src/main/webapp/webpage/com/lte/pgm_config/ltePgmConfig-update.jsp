<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>lte_pgm_config</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ltePgmConfigController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${ltePgmConfigPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="taskId" name="taskId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${ltePgmConfigPage.taskId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">ID</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="buildingId" name="buildingId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${ltePgmConfigPage.buildingId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="buildingFloorId" name="buildingFloorId" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${ltePgmConfigPage.buildingFloorId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">ID</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								pgm类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="pgmType" name="pgmType" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ltePgmConfigPage.pgmType}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">pgm类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								pgm分辨率:
							</label>
						</td>
						<td class="value">
						     	 <input id="originX" name="originX" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${ltePgmConfigPage.originX}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">pgm分辨率</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								原点x:
							</label>
						</td>
						<td class="value">
						     	 <input id="originY" name="originY" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${ltePgmConfigPage.originY}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原点x</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								原点y:
							</label>
						</td>
						<td class="value">
						     	 <input id="originZ" name="originZ" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${ltePgmConfigPage.originZ}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原点y</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								原点z:
							</label>
						</td>
						<td class="value">
						     	 <input id="resolution" name="resolution" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${ltePgmConfigPage.resolution}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原点z</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								negate:
							</label>
						</td>
						<td class="value">
						     	 <input id="negate" name="negate" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${ltePgmConfigPage.negate}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">negate</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								occupied_thresh:
							</label>
						</td>
						<td class="value">
						     	 <input id="occupiedThresh" name="occupiedThresh" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${ltePgmConfigPage.occupiedThresh}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">occupied_thresh</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								free_thresh:
							</label>
						</td>
						<td class="value">
						     	 <input id="freeThresh" name="freeThresh" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${ltePgmConfigPage.freeThresh}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">free_thresh</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								pgm宽:
							</label>
						</td>
						<td class="value">
						     	 <input id="pgmWidth" name="pgmWidth" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${ltePgmConfigPage.pgmWidth}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">pgm宽</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								pgm高:
							</label>
						</td>
						<td class="value">
						     	 <input id="pgmHeight" name="pgmHeight" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${ltePgmConfigPage.pgmHeight}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">pgm高</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建人名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="createName" name="createName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ltePgmConfigPage.createName}'/>
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
						     	 <input id="createBy" name="createBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ltePgmConfigPage.createBy}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人登录名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建日期:
							</label>
						</td>
						<td class="value">
									  <input id="createDate" name="createDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${ltePgmConfigPage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
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
						     	 <input id="updateName" name="updateName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ltePgmConfigPage.updateName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								更新人登录名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="updateBy" name="updateBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ltePgmConfigPage.updateBy}'/>
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
									  <input id="updateDate" name="updateDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${ltePgmConfigPage.updateDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新日期</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/pgm_config/ltePgmConfig.js"></script>		
