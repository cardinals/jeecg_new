<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>lte_building_floor</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript">
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
                }
            });
        });
    </script>
</head>
<body>
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table"
             action="lteBuildingFloorController.do?doAdd">
    <input id="id" name="id" type="hidden" value="${lteBuildingFloorPage.id }"/>
    <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
            <td align="right">
                <label class="Validform_label">
                    楼宇:
                </label>
            </td>
            <td class="value">
                <select id="buildingId" name="buildingId" ignore="ignore">
                        <%--<option value="1">是</option>--%>
                        <%--<option value="0">否</option>--%>
                </select>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">楼宇</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    楼层名称:
                </label>
            </td>
            <td class="value">
                <input id="floorName" name="floorName" type="text" style="width: 150px" class="inputxt"
                       ignore="ignore"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">楼层名称</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    楼层编号:
                </label>
            </td>
            <td class="value">
                <input id="floorNo" name="floorNo" type="text" style="width: 150px" class="inputxt" ignore="ignore"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">楼层编号</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    楼层属性:
                </label>
            </td>
            <td class="value">
                <input id="floorProperty" name="floorProperty" type="text" style="width: 150px" class="inputxt"
                       ignore="ignore"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">楼层属性</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    楼层描述:
                </label>
            </td>
            <td class="value">
                <script type="text/javascript" charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
                <script type="text/javascript" charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
                <textarea name="description" id="description" style="width: 650px;height:300px"></textarea>
                <script type="text/javascript">
                    var description_editor = UE.getEditor('description');
                </script>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">楼层描述</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    楼宇备注:
                </label>
            </td>
            <td class="value">
                <textarea style="width:600px;" class="inputxt" rows="6" id="note" name="note"
                          ignore="ignore"></textarea>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">楼宇备注</label>
            </td>
        </tr>
    </table>
</t:formvalid>
</body>
<script src="${webRoot}/webpage/com/lte/building_floor/lteBuildingFloor.js"></script>
