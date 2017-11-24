package com.lte.task.controller;

import com.lte.building_floor.entity.LteBuildingFloorEntity;
import com.lte.building_floor.service.LteBuildingFloorServiceI;
import com.lte.building_floor.vo.LteBuildingFloorVo;
import com.lte.task.entity.LteScanTaskEntity;
import com.lte.task.service.LteScanTaskServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Controller
 * @Description: lte_scan_task
 * @date 2017-11-20 13:41:06
 */
@Controller
@RequestMapping("/lteScanTaskController")
public class LteScanTaskController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(LteScanTaskController.class);

    @Autowired
    private LteScanTaskServiceI lteScanTaskService;
    @Autowired
    private LteBuildingFloorServiceI lteBuildingFloorService;
    @Autowired
    private SystemService systemService;
    @Autowired
    private Validator validator;


    /**
     * lte_scan_task列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/lte/task/lteScanTaskList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */

    @RequestMapping(params = "datagrid")
    public void datagrid(LteScanTaskEntity lteScanTask, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(LteScanTaskEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, lteScanTask, request.getParameterMap());
        try {
            //自定义追加查询条件
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.lteScanTaskService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除lte_scan_task
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(LteScanTaskEntity lteScanTask, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        lteScanTask = systemService.getEntity(LteScanTaskEntity.class, lteScanTask.getId());
        message = "lte_scan_task删除成功";
        try {
            lteScanTaskService.delete(lteScanTask);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "lte_scan_task删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除lte_scan_task
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "lte_scan_task删除成功";
        try {
            for (String id : ids.split(",")) {
                LteScanTaskEntity lteScanTask = systemService.getEntity(LteScanTaskEntity.class,
                        Integer.parseInt(id)
                );
                lteScanTaskService.delete(lteScanTask);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "lte_scan_task删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加lte_scan_task
     *
     * @param ids
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(LteScanTaskEntity lteScanTask, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "lte_scan_task添加成功";
        try {
            lteScanTaskService.save(lteScanTask);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "lte_scan_task添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新lte_scan_task
     *
     * @param ids
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(LteScanTaskEntity lteScanTask, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "lte_scan_task更新成功";
        LteScanTaskEntity t = lteScanTaskService.get(LteScanTaskEntity.class, lteScanTask.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(lteScanTask, t);
            lteScanTaskService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "lte_scan_task更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * lte_scan_task新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(LteScanTaskEntity lteScanTask, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(lteScanTask.getId())) {
            lteScanTask = lteScanTaskService.getEntity(LteScanTaskEntity.class, lteScanTask.getId());
            req.setAttribute("lteScanTaskPage", lteScanTask);
        }
        return new ModelAndView("com/lte/task/lteScanTask-add");
    }

    /**
     * lte_scan_task编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(LteScanTaskEntity lteScanTask, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(lteScanTask.getId())) {
            lteScanTask = lteScanTaskService.getEntity(LteScanTaskEntity.class, lteScanTask.getId());
            req.setAttribute("lteScanTaskPage", lteScanTask);
        }
        return new ModelAndView("com/lte/task/lteScanTask-update");
    }

    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "lteScanTaskController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(LteScanTaskEntity lteScanTask, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(LteScanTaskEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, lteScanTask, request.getParameterMap());
        List<LteScanTaskEntity> lteScanTasks = this.lteScanTaskService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "lte_scan_task");
        modelMap.put(NormalExcelConstants.CLASS, LteScanTaskEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("lte_scan_task列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, lteScanTasks);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    /**
     * 导出excel 使模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXlsByT")
    public String exportXlsByT(LteScanTaskEntity lteScanTask, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        modelMap.put(NormalExcelConstants.FILE_NAME, "lte_scan_task");
        modelMap.put(NormalExcelConstants.CLASS, LteScanTaskEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("lte_scan_task列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, new ArrayList());
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(params = "importExcel", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile file = entity.getValue();// 获取上传文件对象
            ImportParams params = new ImportParams();
            params.setTitleRows(2);
            params.setHeadRows(1);
            params.setNeedSave(true);
            try {
                List<LteScanTaskEntity> listLteScanTaskEntitys = ExcelImportUtil.importExcel(file.getInputStream(), LteScanTaskEntity.class, params);
                for (LteScanTaskEntity lteScanTask : listLteScanTaskEntitys) {
                    lteScanTaskService.save(lteScanTask);
                }
                j.setMsg("文件导入成功！");
            } catch (Exception e) {
                j.setMsg("文件导入失败！");
                logger.error(ExceptionUtil.getExceptionMessage(e));
            } finally {
                try {
                    file.getInputStream().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return j;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<LteScanTaskEntity> list() {
        List<LteScanTaskEntity> listLteScanTasks = lteScanTaskService.getList(LteScanTaskEntity.class);
        return listLteScanTasks;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        LteScanTaskEntity task = lteScanTaskService.get(LteScanTaskEntity.class, id);
        if (task == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(task, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody LteScanTaskEntity lteScanTask, UriComponentsBuilder uriBuilder) {
        //调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        Set<ConstraintViolation<LteScanTaskEntity>> failures = validator.validate(lteScanTask);
        if (!failures.isEmpty()) {
            return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
        }

        //保存
        try {
            lteScanTaskService.save(lteScanTask);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        //按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
        String id = lteScanTask.getId().toString();
        URI uri = uriBuilder.path("/rest/lteScanTaskController/" + id).build().toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody LteScanTaskEntity lteScanTask) {
        //调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        Set<ConstraintViolation<LteScanTaskEntity>> failures = validator.validate(lteScanTask);
        if (!failures.isEmpty()) {
            return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
        }

        //保存
        try {
            lteScanTaskService.saveOrUpdate(lteScanTask);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        //按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        lteScanTaskService.deleteEntityById(LteScanTaskEntity.class, id);
    }

    @RequestMapping(params = "addData")
    @ResponseBody
    public AjaxJson addData(LteScanTaskEntity lteScanTask, HttpServletRequest request) {
        String message = null;
        AjaxJson ajaxJson = new AjaxJson();
        message = "录入成功";
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();

            //查询实例
            List<Map<String, String>> all = lteBuildingFloorService.getAll();
            List<LteBuildingFloorEntity> entityAll = lteBuildingFloorService.getEntityAll();
            LteBuildingFloorEntity lteBuildingFloorEntity = new LteBuildingFloorEntity();
            MiniDaoPage<LteBuildingFloorEntity> allEntities = lteBuildingFloorService.getAllEntities(lteBuildingFloorEntity, 1, 10);
            List<LteBuildingFloorVo> voAll = lteBuildingFloorService.getVoAll();
            LteBuildingFloorVo lteBuildingFloorVo = new LteBuildingFloorVo();
            MiniDaoPage<LteBuildingFloorVo> allVos = lteBuildingFloorService.getAllVos(lteBuildingFloorVo, 1, 10);
        } catch (Exception e) {
            e.printStackTrace();
            message = "录入成功";
            throw new BusinessException(e.getMessage());
        }
        ajaxJson.setMsg(message);
        return ajaxJson;
    }
}
