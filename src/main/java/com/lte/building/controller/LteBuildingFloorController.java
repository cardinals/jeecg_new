package com.lte.building.controller;

import com.lte.building.entity.LteBuildingFloorEntity;
import com.lte.building.service.LteBuildingFloorServiceI;
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
import org.springframework.web.bind.annotation.*;
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
 * @Description: lte_building_floor
 * @date 2017-11-14 13:26:26
 */
@Controller
@RequestMapping("/lteBuildingFloorController")
public class LteBuildingFloorController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(LteBuildingFloorController.class);

    @Autowired
    private LteBuildingFloorServiceI lteBuildingFloorService;
    @Autowired
    private SystemService systemService;
    @Autowired
    private Validator validator;


    /**
     * lte_building_floor列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/lte/building/lteBuildingFloorList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */

    @RequestMapping(params = "datagrid")
    public void datagrid(LteBuildingFloorEntity lteBuildingFloor, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(LteBuildingFloorEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, lteBuildingFloor, request.getParameterMap());
        try {
            //自定义追加查询条件
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.lteBuildingFloorService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除lte_building_floor
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(LteBuildingFloorEntity lteBuildingFloor, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        lteBuildingFloor = systemService.getEntity(LteBuildingFloorEntity.class, lteBuildingFloor.getId());
        message = "lte_building_floor删除成功";
        try {
            lteBuildingFloorService.delete(lteBuildingFloor);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "lte_building_floor删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除lte_building_floor
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "lte_building_floor删除成功";
        try {
            for (String id : ids.split(",")) {
                LteBuildingFloorEntity lteBuildingFloor = systemService.getEntity(LteBuildingFloorEntity.class,
                        Integer.parseInt(id)
                );
                lteBuildingFloorService.delete(lteBuildingFloor);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "lte_building_floor删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加lte_building_floor
     *
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(LteBuildingFloorEntity lteBuildingFloor, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "lte_building_floor添加成功";
        try {
            lteBuildingFloorService.save(lteBuildingFloor);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "lte_building_floor添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新lte_building_floor
     *
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(LteBuildingFloorEntity lteBuildingFloor, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "lte_building_floor更新成功";
        LteBuildingFloorEntity t = lteBuildingFloorService.get(LteBuildingFloorEntity.class, lteBuildingFloor.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(lteBuildingFloor, t);
            lteBuildingFloorService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "lte_building_floor更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * lte_building_floor新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(LteBuildingFloorEntity lteBuildingFloor, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(lteBuildingFloor.getId())) {
            lteBuildingFloor = lteBuildingFloorService.getEntity(LteBuildingFloorEntity.class, lteBuildingFloor.getId());
            req.setAttribute("lteBuildingFloorPage", lteBuildingFloor);
        }
        return new ModelAndView("com/lte/building/lteBuildingFloor-add");
    }

    /**
     * lte_building_floor编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(LteBuildingFloorEntity lteBuildingFloor, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(lteBuildingFloor.getId())) {
            lteBuildingFloor = lteBuildingFloorService.getEntity(LteBuildingFloorEntity.class, lteBuildingFloor.getId());
            req.setAttribute("lteBuildingFloorPage", lteBuildingFloor);
        }
        return new ModelAndView("com/lte/building/lteBuildingFloor-update");
    }

    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "lteBuildingFloorController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(LteBuildingFloorEntity lteBuildingFloor, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(LteBuildingFloorEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, lteBuildingFloor, request.getParameterMap());
        List<LteBuildingFloorEntity> lteBuildingFloors = this.lteBuildingFloorService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "lte_building_floor");
        modelMap.put(NormalExcelConstants.CLASS, LteBuildingFloorEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("lte_building_floor列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, lteBuildingFloors);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    /**
     * 导出excel 使模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXlsByT")
    public String exportXlsByT(LteBuildingFloorEntity lteBuildingFloor, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        modelMap.put(NormalExcelConstants.FILE_NAME, "lte_building_floor");
        modelMap.put(NormalExcelConstants.CLASS, LteBuildingFloorEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("lte_building_floor列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
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
                List<LteBuildingFloorEntity> listLteBuildingFloorEntitys = ExcelImportUtil.importExcel(file.getInputStream(), LteBuildingFloorEntity.class, params);
                for (LteBuildingFloorEntity lteBuildingFloor : listLteBuildingFloorEntitys) {
                    lteBuildingFloorService.save(lteBuildingFloor);
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
    public List<LteBuildingFloorEntity> list() {
        List<LteBuildingFloorEntity> listLteBuildingFloors = lteBuildingFloorService.getList(LteBuildingFloorEntity.class);
        return listLteBuildingFloors;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        LteBuildingFloorEntity task = lteBuildingFloorService.get(LteBuildingFloorEntity.class, id);
        if (task == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(task, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody LteBuildingFloorEntity lteBuildingFloor, UriComponentsBuilder uriBuilder) {
        //调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        Set<ConstraintViolation<LteBuildingFloorEntity>> failures = validator.validate(lteBuildingFloor);
        if (!failures.isEmpty()) {
            return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
        }

        //保存
        try {
            lteBuildingFloorService.save(lteBuildingFloor);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        //按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
        String id = lteBuildingFloor.getId().toString();
        URI uri = uriBuilder.path("/rest/lteBuildingFloorController/" + id).build().toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody LteBuildingFloorEntity lteBuildingFloor) {
        //调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        Set<ConstraintViolation<LteBuildingFloorEntity>> failures = validator.validate(lteBuildingFloor);
        if (!failures.isEmpty()) {
            return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
        }

        //保存
        try {
            lteBuildingFloorService.saveOrUpdate(lteBuildingFloor);
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
        lteBuildingFloorService.deleteEntityById(LteBuildingFloorEntity.class, id);
    }

    /**
     * 测试导出Word
     *
     * @return
     */
    @RequestMapping(params = "addExportWord")
    @ResponseBody
    public AjaxJson addExportWord(HttpServletRequest request) {
        AjaxJson ajaxJson = new AjaxJson();
        try {
            lteBuildingFloorService.addExportWord();
            ajaxJson.setMsg("导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.setMsg("导出失败");
            throw new BusinessException(e.getMessage());
        }
        return ajaxJson;
    }
}
