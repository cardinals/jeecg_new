<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>lte_building_floor</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript">
        //编写自定义JS代码
    </script>
</head>
<body>
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table"
             action="lteBuildingFloorController.do?doUpdate">
    <input id="id" name="id" type="hidden" value="${lteBuildingFloorPage.id }"/>
    <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
            <td align="right">
                <label class="Validform_label">
                    楼宇ID:
                </label>
            </td>
            <td class="value">
                <input id="buildingId" name="buildingId" type="text" style="width: 150px" class="searchbox-inputtext"
                       datatype="n" ignore="checked" onclick="inputClick(this,'building_id','pomp_building')"
                       value='${lteBuildingFloorPage.buildingId}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">楼宇ID</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    楼层名称:
                </label>
            </td>
            <td class="value">
                <input id="floorName" name="floorName" type="text" style="width: 150px" class="inputxt" ignore="ignore"
                       value='${lteBuildingFloorPage.floorName}'/>
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
                <input id="floorNo" name="floorNo" type="text" style="width: 150px" class="inputxt" ignore="ignore"
                       value='${lteBuildingFloorPage.floorNo}'/>
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
                       ignore="ignore" value='${lteBuildingFloorPage.floorProperty}'/>
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
                <textarea name="description" id="description"
                          style="width: 650px;height:300px">${lteBuildingFloorPage.description }</textarea>

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
                <textarea id="note" style="width:600px;" class="inputxt" rows="6" name="note"
                          ignore="ignore">${lteBuildingFloorPage.note}</textarea>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">楼宇备注</label>
            </td>
        </tr>
    </table>
</t:formvalid>
</body>
<script src="${webRoot}/webpage/com/lte/building_floor/lteBuildingFloor.js"></script>
