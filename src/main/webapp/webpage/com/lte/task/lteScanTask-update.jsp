<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>lte_scan_task</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript">
        //编写自定义JS代码
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
                <input id="buildingId" name="buildingId" type="text" style="width: 150px" class="inputxt" datatype="n"
                       ignore="checked" value='${lteScanTaskPage.buildingId}'/>
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
</t:formvalid>
</body>
<script src="${webRoot}/webpage/com/lte/task/lteScanTask.js"></script>
