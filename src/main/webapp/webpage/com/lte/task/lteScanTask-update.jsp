<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>lte_scan_task</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript">
        var buildingId = '${lteScanTaskPage.buildingId}';
        //编写自定义JS代码
        $(function () {
            $.ajax({
                url: 'lteBuildingController.do?listSel',
                dataType: 'json',
                data: {},
                success: function (ajaxJson) {
                    var relustList = ajaxJson.obj;
                    $.each(relustList, function (i, v) {
                        $('#buildingId')
                            .append($('<option>', {value: v.id})
                                .text(v.buildingName));
                    });
                    $("#buildingId option[value='" + buildingId + "']").attr("selected", "selected");
                    $('#lteBuildingFloorList').datagrid('load', {
                        buildingId: buildingId == "" ? 0 : buildingId
                    });
                }
            });

            $("#buildingId").change(function () {
                var buildingId = $("#buildingId option:selected").val();
                $('#lteBuildingFloorList').datagrid('load', {
                    buildingId: buildingId == "" ? 0 : buildingId
                });
            });
        });

        function addData() {
            var selectRow = $("#lteBuildingFloorList").datagrid("getSelected");
            var building_floor_id = selectRow.id;
            var buildingId = $("#buildingId option:selected").val();
            var taskId = $("#id").val();
            $.ajax({
                url: 'lteScanTaskController.do?addData',
                dataType: 'json',
                data: {
                    taskId:taskId,
                    buildingId:buildingId,
                    buildingFloorId:building_floor_id
                },
                success: function (ajaxJson) {
                    var relustList = ajaxJson.obj;
                    $.each(relustList, function (i, v) {
                        $('#buildingId')
                            .append($('<option>', {value: v.id})
                                .text(v.buildingName));
                    });
                    $("#buildingId option[value='" + buildingId + "']").attr("selected", "selected");
                    $('#lteBuildingFloorList').datagrid('load', {
                        buildingId: buildingId == "" ? 0 : buildingId
                    });
                }
            });
        }
    </script>
</head>
<body>
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table"
             action="lteScanTaskController.do?doUpdate">
    <input id="id" name="id" type="hidden" value="${lteScanTaskPage.id }"/>
    <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
            <td align="right">
                <label class="Validform_label">
                    楼宇ID:
                </label>
            </td>
            <td class="value">
                <select id="buildingId" name="buildingId" ignore="ignore">
                    <option value="">请选择楼宇</option>
                </select>
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
                <input id="taskName" name="taskName" type="text" style="width: 150px" class="inputxt" ignore="ignore"
                       value='${lteScanTaskPage.taskName}'/>
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
                <input id="taskNo" name="taskNo" type="text" style="width: 150px" class="inputxt" ignore="ignore"
                       value='${lteScanTaskPage.taskNo}'/>
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
                       ignore="checked" value='${lteScanTaskPage.taskStatus}'/>
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
                       datatype="n" ignore="checked" value='${lteScanTaskPage.reportStatus}'/>
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
                <textarea id="note" style="width:600px;" class="inputxt" rows="6" name="note"
                          ignore="ignore">${lteScanTaskPage.note}</textarea>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">任务备注</label>
            </td>
        </tr>
    </table>
    <div style="width:729px;height:300px;">
        <t:datagrid name="lteBuildingFloorList" pagination="true" fitColumns="true"
                    title="楼层信息" actionUrl="lteBuildingFloorController.do?datagrid"
                    extendParams="queryParams:{buildingId:0}"
                    idField="id"
                    fit="true" queryMode="group">
            <t:dgCol title="ID" field="id" hidden="true" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="楼宇ID" field="buildingId" queryMode="group" dictionary="pomp_building,building_id,id"
                     popup="true" width="120"></t:dgCol>
            <t:dgCol title="楼层名称" field="floorName" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="楼层编号" field="floorNo" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="楼层属性" field="floorProperty" queryMode="group" width="120"></t:dgCol>
            <t:dgCol title="楼层描述" field="description" hidden="true" queryMode="group" width="500"></t:dgCol>
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
            <t:dgFunOpt title="录入数据" funname="addData()" urlclass="ace_button"
                        urlfont="fa-trash-o"></t:dgFunOpt>
        </t:datagrid>
    </div>

</t:formvalid>
</body>
<script src="${webRoot}/webpage/com/lte/task/lteScanTask.js"></script>
