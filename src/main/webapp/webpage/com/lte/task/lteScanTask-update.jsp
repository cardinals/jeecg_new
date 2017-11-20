<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>lte_scan_task</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="online/template/ledefault/css/vendor.css">
    <link rel="stylesheet" href="online/template/ledefault/css/bootstrap-theme.css">
    <link rel="stylesheet" href="online/template/ledefault/css/bootstrap.css">
    <link rel="stylesheet" href="online/template/ledefault/css/app.css">

    <link rel="stylesheet" href="plug-in/Validform/css/metrole/style.css" type="text/css"/>
    <link rel="stylesheet" href="plug-in/Validform/css/metrole/tablefrom.css" type="text/css"/>

    <script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="plug-in/tools/dataformat.js"></script>
    <script type="text/javascript" src="plug-in/easyui/jquery.easyui.min.1.3.2.js"></script>
    <script type="text/javascript" src="plug-in/easyui/locale/zh-cn.js"></script>
    <script type="text/javascript" src="plug-in/tools/syUtil.js"></script>
    <script type="text/javascript" src="plug-in/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="plug-in/lhgDialog/lhgdialog.min.js"></script>
    <script type="text/javascript" src="plug-in/tools/curdtools_zh-cn.js"></script>
    <script type="text/javascript" src="plug-in/tools/easyuiextend.js"></script>
    <script type="text/javascript" src="plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
    <script type="text/javascript" src="plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
    <script type="text/javascript" src="plug-in/Validform/js/datatype_zh-cn.js"></script>
    <script type="text/javascript" src="plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></script>
    <script type="text/javascript" charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript">
        //编写自定义JS代码
    </script>
</head>

<body>
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table"
             action="lteScanTaskController.do?doUpdate" tiptype="1">
    <input type="hidden" id="btn_sub" class="btn_sub"/>
    <input type="hidden" name="id" value='${lteScanTaskPage.id}'>


    <div class="tab-wrapper">
        <!-- tab -->
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="javascript:void(0);">lte_scan_task</a></li>
        </ul>
        <!-- tab内容 -->
        <div class="con-wrapper" id="con-wrapper1" style="display: block;">
            <div class="row form-wrapper">
                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>楼宇ID：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="buildingId" name="buildingId" type="text" class="form-control" datatype="n"
                               ignore="checked" value='${lteScanTaskPage.buildingId}'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">楼宇ID</label>
                    </div>
                </div>


                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>任务名称：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="taskName" name="taskName" type="text" class="form-control" ignore="ignore"
                               value='${lteScanTaskPage.taskName}'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">任务名称</label>
                    </div>
                </div>


                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>任务编号：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="taskNo" name="taskNo" type="text" class="form-control" ignore="ignore"
                               value='${lteScanTaskPage.taskNo}'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">任务编号</label>
                    </div>
                </div>


                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>任务状态：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="taskStatus" name="taskStatus" type="text" class="form-control" datatype="n"
                               ignore="checked" value='${lteScanTaskPage.taskStatus}'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">任务状态</label>
                    </div>
                </div>


                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>报告状态：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="reportStatus" name="reportStatus" type="text" class="form-control" datatype="n"
                               ignore="checked" value='${lteScanTaskPage.reportStatus}'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">报告状态</label>
                    </div>
                </div>


                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>任务备注：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="note" name="note" type="text" class="form-control" ignore="ignore"
                               value='${lteScanTaskPage.note}'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">任务备注</label>
                    </div>
                </div>


                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>创建人名称：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="createName" name="createName" type="text" class="form-control" ignore="ignore"
                               value='${lteScanTaskPage.createName}'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">创建人名称</label>
                    </div>
                </div>


                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>创建人登录名称：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="createBy" name="createBy" type="text" class="form-control" ignore="ignore"
                               value='${lteScanTaskPage.createBy}'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">创建人登录名称</label>
                    </div>
                </div>


                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>创建日期：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="createDate" name="createDate" type="text"
                               style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
                               class="form-control" onClick="WdatePicker()" ignore="ignore"
                               value='<fmt:formatDate value='${lteScanTaskPage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">创建日期</label>
                    </div>
                </div>


                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>更新人名称：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="updateName" name="updateName" type="text" class="form-control" ignore="ignore"
                               value='${lteScanTaskPage.updateName}'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">更新人名称</label>
                    </div>
                </div>


                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>更新人登录名称：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="updateBy" name="updateBy" type="text" class="form-control" ignore="ignore"
                               value='${lteScanTaskPage.updateBy}'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">更新人登录名称</label>
                    </div>
                </div>


                <div class="row show-grid">
                    <div class="col-xs-3 text-center">
                        <b>更新日期：</b>
                    </div>
                    <div class="col-xs-3">
                        <input id="updateDate" name="updateDate" type="text"
                               style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
                               class="form-control" onClick="WdatePicker()" ignore="ignore"
                               value='<fmt:formatDate value='${lteScanTaskPage.updateDate}' type="date" pattern="yyyy-MM-dd"/>'/>
                        <span class="Validform_checktip" style="float:left;height:0px;"></span>
                        <label class="Validform_label" style="display: none">更新日期</label>
                    </div>
                </div>


                <div class="row" id="sub_tr" style="display: none;">
                    <div class="col-xs-12 layout-header">
                        <div class="col-xs-6"></div>
                        <div class="col-xs-6">
                            <button type="button" onclick="neibuClick();" class="btn btn-default">提交</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="con-wrapper" id="con-wrapper2" style="display: block;"></div>
    </div>
</t:formvalid>

<script type="text/javascript">
    $(function () {
        //查看模式情况下,删除和上传附件功能禁止使用
        if (location.href.indexOf("load=detail") != -1) {
            $(".jeecgDetail").hide();
        }

        if (location.href.indexOf("mode=read") != -1) {
            //查看模式控件禁用
            $("#formobj").find(":input").attr("disabled", "disabled");
        }
        if (location.href.indexOf("mode=onbutton") != -1) {
            //其他模式显示提交按钮
            $("#sub_tr").show();
        }
    });

    var neibuClickFlag = false;

    function neibuClick() {
        neibuClickFlag = true;
        $('#btn_sub').trigger('click');
    }

</script>
</body>
<script src="${webRoot}/webpage/com/lte/task/lteScanTask.js"></script>
</html>