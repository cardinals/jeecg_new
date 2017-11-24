package com.lte.building_floor.service.impl;

import com.lte.building_floor.dao.LteBuildingFloorDao;
import com.lte.building_floor.entity.LteBuildingFloorEntity;
import com.lte.building_floor.service.LteBuildingFloorServiceI;
import com.lte.building_floor.vo.LteBuildingFloorVo;
import com.lte.util.HtmlToWordUtil;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("lteBuildingFloorService")
@Transactional
public class LteBuildingFloorServiceImpl extends CommonServiceImpl implements LteBuildingFloorServiceI {

    @Autowired
    private LteBuildingFloorDao lteBuildingFloorDao;

    public void delete(LteBuildingFloorEntity entity) throws Exception {
        super.delete(entity);
        //执行删除操作增强业务
        this.doDelBus(entity);
    }

    public Serializable save(LteBuildingFloorEntity entity) throws Exception {
        Serializable t = super.save(entity);
        //执行新增操作增强业务
        this.doAddBus(entity);
        return t;
    }

    public void saveOrUpdate(LteBuildingFloorEntity entity) throws Exception {
        super.saveOrUpdate(entity);
        //执行更新操作增强业务
        this.doUpdateBus(entity);
    }

    /**
     * 新增操作增强业务
     *
     * @param t
     * @return
     */
    private void doAddBus(LteBuildingFloorEntity t) throws Exception {
        //-----------------sql增强 start----------------------------
        //-----------------sql增强 end------------------------------

        //-----------------java增强 start---------------------------
        //-----------------java增强 end-----------------------------
    }

    /**
     * 更新操作增强业务
     *
     * @param t
     * @return
     */
    private void doUpdateBus(LteBuildingFloorEntity t) throws Exception {
        //-----------------sql增强 start----------------------------
        //-----------------sql增强 end------------------------------

        //-----------------java增强 start---------------------------
        //-----------------java增强 end-----------------------------
    }

    /**
     * 删除操作增强业务
     *
     * @return
     */
    private void doDelBus(LteBuildingFloorEntity t) throws Exception {
        //-----------------sql增强 start----------------------------
        //-----------------sql增强 end------------------------------

        //-----------------java增强 start---------------------------
        //-----------------java增强 end-----------------------------
    }

    private Map<String, Object> populationMap(LteBuildingFloorEntity t) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", t.getId());
        map.put("building_id", t.getBuildingId());
        map.put("floor_name", t.getFloorName());
        map.put("floor_no", t.getFloorNo());
        map.put("floor_property", t.getFloorProperty());
        map.put("description", t.getDescription());
        map.put("note", t.getNote());
        map.put("create_name", t.getCreateName());
        map.put("create_by", t.getCreateBy());
        map.put("create_date", t.getCreateDate());
        map.put("update_name", t.getUpdateName());
        map.put("update_by", t.getUpdateBy());
        map.put("update_date", t.getUpdateDate());
        return map;
    }

    /**
     * 替换sql中的变量
     *
     * @param sql
     * @param t
     * @return
     */
    public String replaceVal(String sql, LteBuildingFloorEntity t) {
        sql = sql.replace("#{id}", String.valueOf(t.getId()));
        sql = sql.replace("#{building_id}", String.valueOf(t.getBuildingId()));
        sql = sql.replace("#{floor_name}", String.valueOf(t.getFloorName()));
        sql = sql.replace("#{floor_no}", String.valueOf(t.getFloorNo()));
        sql = sql.replace("#{floor_property}", String.valueOf(t.getFloorProperty()));
        sql = sql.replace("#{description}", String.valueOf(t.getDescription()));
        sql = sql.replace("#{note}", String.valueOf(t.getNote()));
        sql = sql.replace("#{create_name}", String.valueOf(t.getCreateName()));
        sql = sql.replace("#{create_by}", String.valueOf(t.getCreateBy()));
        sql = sql.replace("#{create_date}", String.valueOf(t.getCreateDate()));
        sql = sql.replace("#{update_name}", String.valueOf(t.getUpdateName()));
        sql = sql.replace("#{update_by}", String.valueOf(t.getUpdateBy()));
        sql = sql.replace("#{update_date}", String.valueOf(t.getUpdateDate()));
        sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
        return sql;
    }

    /**
     * 执行JAVA增强
     */
    private void executeJavaExtend(String cgJavaType, String cgJavaValue, Map<String, Object> data) throws Exception {
        if (StringUtil.isNotEmpty(cgJavaValue)) {
            Object obj = null;
            try {
                if ("class".equals(cgJavaType)) {
                    //因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
                    obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
                } else if ("spring".equals(cgJavaType)) {
                    obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
                }
                if (obj instanceof CgformEnhanceJavaInter) {
                    CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
                    javaInter.execute("lte_building_floor", data);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("执行JAVA增强出现异常！");
            }
        }
    }

    @Override
    public List<Map<String, String>> getAll(){
        List<Map<String, String>> all = lteBuildingFloorDao.getAll();
        return all;
    }

    @Override
    public List<LteBuildingFloorEntity> getEntityAll(){
        List<LteBuildingFloorEntity> entityAll = lteBuildingFloorDao.getEntityAll();
        return entityAll;
    }

    @Override
    public MiniDaoPage<LteBuildingFloorEntity> getAllEntities(@Param("LteBuildingFloorEntity") LteBuildingFloorEntity lteBuildingFloorEntity, @Param("page") int page, @Param("rows") int rows){
        MiniDaoPage<LteBuildingFloorEntity> allEntities = lteBuildingFloorDao.getAllEntities(lteBuildingFloorEntity, page, rows);
        return allEntities;
    }

    @Override
    public List<LteBuildingFloorVo> getVoAll() {
        List<LteBuildingFloorVo> voAll = lteBuildingFloorDao.getVoAll();
        return voAll;
    }

    @Override
    public MiniDaoPage<LteBuildingFloorVo> getAllVos(LteBuildingFloorVo lteBuildingFloorVo, int page, int rows) {
        MiniDaoPage<LteBuildingFloorVo> allVos = lteBuildingFloorDao.getAllVos(lteBuildingFloorVo, page, rows);
        return allVos;
    }

    @Override
    public void addExportWord() throws Exception {
        LteBuildingFloorEntity lteBuildingFloorEntity = this.getEntity(LteBuildingFloorEntity.class, 1);
        String htmlFilePath = "E:\\export\\htmlTemplate\\报告模板v2.html";
        File htmlFile = new File(htmlFilePath);
        String htmlString = HtmlToWordUtil.toHtmlString(htmlFile);
        //替换内容
        String replaceString = htmlString.replace("${description}", "阿萨德法师打发");
        String allTableStr = "<TABLE WIDTH=518 BORDER=1 BORDERCOLOR=\"#00000a\" CELLPADDING=7 CELLSPACING=0>\n" +
                "    <COL WIDTH=115>\n" +
                "    <COL WIDTH=194>\n" +
                "    <COL WIDTH=165>\n" +
                "    <TR VALIGN=TOP>\n" +
                "        <TD WIDTH=115>\n" +
                "            <P><FONT SIZE=3>测试点数</FONT></P>\n" +
                "        </TD>\n" +
                "        <TD WIDTH=194>\n" +
                "            <P>\n" +
                "                <FONT FACE=\"Calibri, serif\">\n" +
                "                <SPAN LANG=\"en-US\">\n" +
                "                    <FONT SIZE=3>RSRP&gt;=105dbm</FONT>\n" +
                "                </SPAN>\n" +
                "                </FONT>\n" +
                "                <FONT SIZE=3>并且</FONT>\n" +
                "                <FONT FACE=\"Calibri, serif\">\n" +
                "                    <SPAN LANG=\"en-US\">\n" +
                "                        <FONT SIZE=3>SNIR&gt;=-3db</FONT>\n" +
                "                    </SPAN>\n" +
                "                </FONT>\n" +
                "                <FONT SIZE=3>的点数</FONT>\n" +
                "            </P>\n" +
                "        </TD>\n" +
                "        <TD WIDTH=165>\n" +
                "            <P>\n" +
                "                <FONT SIZE=3>覆盖率</FONT>\n" +
                "                <FONT FACE=\"Calibri, serif\">\n" +
                "                    <SPAN LANG=\"en-US\">\n" +
                "                        <FONT SIZE=3>%</FONT>\n" +
                "                    </SPAN>\n" +
                "                </FONT>\n" +
                "            </P>\n" +
                "        </TD>\n" +
                "    </TR>\n" +
                "    <TR>\n" +
                "        <TD WIDTH=115>\n" +
                "            <P STYLE=\"widows: 2; orphans: 2\">\n" +
                "                <FONT FACE=\"Calibri, serif\">\n" +
                "                    <SPAN LANG=\"en-US\">\n" +
                "                        <FONT COLOR=\"#000000\">\n" +
                "                            <FONT FACE=\"Calibri, serif\">53</FONT>\n" +
                "                        </FONT>\n" +
                "                    </SPAN>\n" +
                "                </FONT>\n" +
                "            </P>\n" +
                "        </TD>\n" +
                "        <TD WIDTH=194>\n" +
                "            <P>\n" +
                "                <FONT FACE=\"Calibri, serif\">\n" +
                "                    <SPAN LANG=\"en-US\">\n" +
                "                        <FONT COLOR=\"#000000\">\n" +
                "                            <FONT FACE=\"Calibri, serif\">50</FONT>\n" +
                "                        </FONT>\n" +
                "                    </SPAN>\n" +
                "                </FONT>\n" +
                "            </P>\n" +
                "        </TD>\n" +
                "        <TD WIDTH=165>\n" +
                "            <P>\n" +
                "                <FONT FACE=\"Calibri, serif\">\n" +
                "                    <SPAN LANG=\"en-US\">\n" +
                "                        <FONT COLOR=\"#000000\">\n" +
                "                            <FONT FACE=\"Calibri, serif\">94.34</FONT>\n" +
                "                        </FONT>\n" +
                "                    </SPAN>\n" +
                "                </FONT>\n" +
                "            </P>\n" +
                "        </TD>\n" +
                "    </TR>\n" +
                "</TABLE>\n";
        replaceString = replaceString.replace("${allTable}", allTableStr);
        replaceString = replaceString.replace("${RSRP}", "<img width=\"300\" height=\"300\" src=\"E:\\export\\htmlTemplate\\报告模板2v2_html_m2f778711.jpg\"");
        //替换内容
        String uuid = UUID.randomUUID().toString();
        String replaceFilePath = "E:\\export\\" + uuid;
        File dirFile = new File(replaceFilePath);
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        HtmlToWordUtil.htmlToWord2(replaceString, new File(replaceFilePath + "\\模板.doc"));
    }
}