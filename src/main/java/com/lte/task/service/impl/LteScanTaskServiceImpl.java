package com.lte.task.service.impl;

import com.lte.building.entity.LteBuildingEntity;
import com.lte.lidar.DrawPieImage;
import com.lte.lidar.LteKettleThread;
import com.lte.task.dao.LteTaskDao;
import com.lte.task.entity.LteScanTaskEntity;
import com.lte.task.service.LteScanTaskServiceI;
import com.lte.task.vo.ReportPieDataVO;
import com.lte.task.vo.ReportTableDataVO;
import com.lte.util.CustomXWPFDocument;
import com.lte.util.HtmlToWordUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.logging.LogLevel;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("lteScanTaskService")
@Transactional
public class LteScanTaskServiceImpl extends CommonServiceImpl implements LteScanTaskServiceI {

    @Autowired
    private LteTaskDao lteTaskDao;

    public void delete(LteScanTaskEntity entity) throws Exception {
        super.delete(entity);
        //执行删除操作增强业务
        this.doDelBus(entity);
    }

    public Serializable save(LteScanTaskEntity entity) throws Exception {
        Serializable t = super.save(entity);
        //执行新增操作增强业务
        this.doAddBus(entity);
        return t;
    }

    public void saveOrUpdate(LteScanTaskEntity entity) throws Exception {
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
    private void doAddBus(LteScanTaskEntity t) throws Exception {
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
    private void doUpdateBus(LteScanTaskEntity t) throws Exception {
        //-----------------sql增强 start----------------------------
        //-----------------sql增强 end------------------------------

        //-----------------java增强 start---------------------------
        //-----------------java增强 end-----------------------------
    }

    /**
     * 删除操作增强业务
     *
     * @param id
     * @return
     */
    private void doDelBus(LteScanTaskEntity t) throws Exception {
        //-----------------sql增强 start----------------------------
        //-----------------sql增强 end------------------------------

        //-----------------java增强 start---------------------------
        //-----------------java增强 end-----------------------------
    }

    private Map<String, Object> populationMap(LteScanTaskEntity t) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", t.getId());
        map.put("building_id", t.getBuildingId());
        map.put("task_name", t.getTaskName());
        map.put("task_no", t.getTaskNo());
        map.put("task_status", t.getTaskStatus());
        map.put("report_status", t.getReportStatus());
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
    public String replaceVal(String sql, LteScanTaskEntity t) {
        sql = sql.replace("#{id}", String.valueOf(t.getId()));
        sql = sql.replace("#{building_id}", String.valueOf(t.getBuildingId()));
        sql = sql.replace("#{task_name}", String.valueOf(t.getTaskName()));
        sql = sql.replace("#{task_no}", String.valueOf(t.getTaskNo()));
        sql = sql.replace("#{task_status}", String.valueOf(t.getTaskStatus()));
        sql = sql.replace("#{report_status}", String.valueOf(t.getReportStatus()));
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
                    javaInter.execute("lte_scan_task", data);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("执行JAVA增强出现异常！");
            }
        }
    }

    @Override
    public void runTask(Long buildingId, Long buildingFloorId, Long taskId, String basePath) {
        // TODO Auto-generated method stub
        String dataPath = basePath + "//scanData//" + buildingId + "//" + buildingFloorId + "//" + taskId;

        try {
            Job job = buildJob(buildingId, buildingFloorId, taskId, basePath, dataPath);

            //统计页面要的表格begin...

            //所有楼层+最后一段话需要的值(所有楼层不需要floorId)

			/*先画一幅饼图*/
            Map<String, Object> pieMap = new HashMap<String, Object>();
            pieMap.put("buildingId", buildingId);
            pieMap.put("taskId", taskId);
            List<ReportPieDataVO> pieList = lteTaskDao.getReportPie(pieMap);
            if (CollectionUtils.isNotEmpty(pieList)) {
                ReportPieDataVO vo = pieList.get(0);
                Map<String, Integer> dataMap = new HashMap<>();
                dataMap.put("覆盖不达标", 100 - (vo.getPercent()).intValue());
                dataMap.put("覆盖达标", (vo.getPercent()).intValue()); // 输入数据
                String title = "覆盖";
                String reportFloder = basePath + "//report//" + taskId;
                File file = new File(reportFloder);
                if (!file.exists()) {
                    file.mkdirs();
                }
                DrawPieImage drawPie = new DrawPieImage(reportFloder, title, dataMap);
                drawPie.draw();
            }


            double best = 0.0;//最好的楼层
            String bestFloor = "";
            double worst = 100.0; //最坏的楼层
            String worstFloor = "";
            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put("buildingId", buildingId);
            paraMap.put("taskId", taskId);
            List<ReportTableDataVO> list = lteTaskDao.getReportTable(paraMap);
            for (ReportTableDataVO vo : list) {
                if (vo.getPercent() > best) {
                    best = vo.getPercent();
                    bestFloor = vo.getFloorName();
                }
                if (vo.getPercent() < worst) {
                    worst = vo.getPercent();
                    worstFloor = vo.getFloorName();
                }
            }
            System.out.println(best);
            System.out.println(worst);
            System.out.println(bestFloor);
            System.out.println(worstFloor);

            //单独楼层
            Map<String, Object> paraMapSingle = new HashMap<String, Object>();
            paraMapSingle.put("buildingId", buildingId);
            paraMapSingle.put("floorId", buildingFloorId);
            paraMapSingle.put("taskId", taskId);
            List<ReportTableDataVO> listSingle = lteTaskDao.getReportTable(paraMapSingle);

            //统计页面要的表格end...


            LteKettleThread lt = new LteKettleThread(buildingId, buildingFloorId, taskId, job, dataPath, lteTaskDao);
            Thread taskThread = new Thread(lt);
            taskThread.start();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


    }

    @Override
    public void createWordOld(Map<String, Object> parameterMap, String realPath) throws Exception {
        String fileName = (String) parameterMap.get("fileName");
        String taskId = (String) parameterMap.get("taskId");
        LteScanTaskEntity lteScanTaskEntity = this.getEntity(LteScanTaskEntity.class, Integer.parseInt(taskId));
        Integer buildingId = lteScanTaskEntity.getBuildingId();
        LteBuildingEntity lteBuildingEntity = this.getEntity(LteBuildingEntity.class, buildingId);
        String description = lteBuildingEntity.getDescription();
        String htmlFilePath = realPath + "\\" + fileName;
        File htmlFile = new File(htmlFilePath);
        String htmlString = HtmlToWordUtil.toHtmlString(htmlFile);
        //替换内容
        String replaceString = htmlString.replace("${description}", description);
        StrBuilder allTableStr = new StrBuilder("");
        allTableStr.append("<TABLE WIDTH=518 BORDER=1 BORDERCOLOR=\"#00000a\" CELLPADDING=7 CELLSPACING=0>\n" +
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
                "    </TR>\n");
        Map<String, Object> pieMap = new HashMap<String, Object>();
        pieMap.put("buildingId", buildingId);
        pieMap.put("taskId", taskId);
        List<ReportPieDataVO> pieList = lteTaskDao.getReportPie(pieMap);
        if (pieList != null && !pieList.isEmpty()) {
            for (int i = 0; i < pieList.size(); i++) {
                ReportPieDataVO reportPieDataVO = pieList.get(i);
                Integer totalCnt = reportPieDataVO.getTotalCnt();
                Integer validCnt = reportPieDataVO.getValidCnt();
                Double percent = reportPieDataVO.getPercent();
                allTableStr.append(
                        "    <TR>\n" +
                                "        <TD WIDTH=115>\n" +
                                "            <P STYLE=\"widows: 2; orphans: 2\">\n" +
                                "                <FONT FACE=\"Calibri, serif\">\n" +
                                "                    <SPAN LANG=\"en-US\">\n" +
                                "                        <FONT COLOR=\"#000000\">\n" +
                                "                            <FONT FACE=\"Calibri, serif\">" + totalCnt + "</FONT>\n" +
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
                                "                            <FONT FACE=\"Calibri, serif\">" + validCnt + "</FONT>\n" +
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
                                "                            <FONT FACE=\"Calibri, serif\">" + percent + "</FONT>\n" +
                                "                        </FONT>\n" +
                                "                    </SPAN>\n" +
                                "                </FONT>\n" +
                                "            </P>\n" +
                                "        </TD>\n" +
                                "    </TR>\n" +
                                "</TABLE>\n");
            }
        }

        replaceString = replaceString.replace("${allTable}", allTableStr.toString());
        replaceString = replaceString.replace("${pieChart}", "<img width=\"300\" height=\"300\" src=\"E:\\src\\demo\\intellij_idea\\jeecg\\jeecg_wyj\\target\\jeecg\\report\\1\\pieChart.jpg\"/>");
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("buildingId", buildingId);
        paraMap.put("taskId", taskId);
        List<ReportTableDataVO> list = lteTaskDao.getReportTable(paraMap);
        StringBuilder buildingFloorStr = new StringBuilder("");
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                ReportTableDataVO reportTableDataVO = list.get(i);
                Integer totalCnt = reportTableDataVO.getTotalCnt();
                Integer validCnt = reportTableDataVO.getValidCnt();
                Double percent = reportTableDataVO.percent;
                Long floorId = reportTableDataVO.getBuildingFloorId();
                buildingFloorStr.append(
                        "<H4 CLASS=\"cjk\">\n" +
                                "    <FONT FACE=\"Cambria, serif\">\n" +
                                "        <SPAN LANG=\"en-US\">3." + (i + 1) + " " + (i + 1) + "F</SPAN>\n" +
                                "    </FONT>\n" +
                                "</H4>\n" +
                                "<P STYLE=\"margin-bottom: 0cm; line-height: 150%\">\n" +
                                "    <FONT SIZE=3>统计</FONT>\n" +
                                "</P>\n" +
                                "<TABLE WIDTH=518 BORDER=1 BORDERCOLOR=\"#00000a\" CELLPADDING=7 CELLSPACING=0>\n" +
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
                                "                            <FONT FACE=\"Calibri, serif\">" + totalCnt + "</FONT>\n" +
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
                                "                            <FONT FACE=\"Calibri, serif\">" + validCnt + "</FONT>\n" +
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
                                "                            <FONT FACE=\"Calibri, serif\">" + percent + "</FONT>\n" +
                                "                        </FONT>\n" +
                                "                    </SPAN>\n" +
                                "                </FONT>\n" +
                                "            </P>\n" +
                                "        </TD>\n" +
                                "    </TR>\n" +
                                "</TABLE>\n" +
                                "<P ALIGN=LEFT STYLE=\"margin-bottom: 0cm; line-height: 150%\">\n" +
                                "    <FONT FACE=\"Calibri, serif\">\n" +
                                "        <SPAN LANG=\"en-US\">\n" +
                                "            <FONT SIZE=3>RSRP</FONT>\n" +
                                "        </SPAN>\n" +
                                "    </FONT>\n" +
                                "    <FONT SIZE=3>分布图</FONT>\n" +
                                "</P>\n" +
                                "<img width=\"300\" height=\"300\" src=\"E:\\src\\demo\\intellij_idea\\jeecg\\jeecg_wyj\\target\\jeecg\\scanData\\" + buildingId + "\\" + floorId + "\\" + taskId + "\\MAP_RSRP.jpg\"/>" +
                                "<P ALIGN=LEFT STYLE=\"margin-bottom: 0cm; line-height: 150%\">\n" +
                                "    <FONT FACE=\"Calibri, serif\">\n" +
                                "        <SPAN LANG=\"en-US\"><FONT SIZE=3>SINR</FONT>\n" +
                                "        </SPAN>\n" +
                                "    </FONT>\n" +
                                "    <FONT SIZE=3>分布图</FONT>\n" +
                                "</P>\n" +
                                "<img width=\"300\" height=\"300\" src=\"E:\\src\\demo\\intellij_idea\\jeecg\\jeecg_wyj\\target\\jeecg\\scanData\\" + buildingId + "\\" + floorId + "\\" + taskId + "\\MAP_SINR.jpg\"/>" +
                                "<P ALIGN=LEFT STYLE=\"margin-bottom: 0cm; line-height: 150%\">\n" +
                                "    <FONT FACE=\"Calibri, serif\">\n" +
                                "        <SPAN LANG=\"en-US\">\n" +
                                "            <FONT SIZE=3>CGI</FONT>\n" +
                                "        </SPAN>\n" +
                                "    </FONT>\n" +
                                "    <FONT SIZE=3>分布图</FONT>\n" +
                                "</P>\n" +
                                "<img width=\"300\" height=\"300\" src=\"E:\\src\\demo\\intellij_idea\\jeecg\\jeecg_wyj\\target\\jeecg\\scanData\\" + buildingId + "\\" + floorId + "\\" + taskId + "\\MAP_CGI.jpg\"/>"
                );
            }
        }
        replaceString = replaceString.replace("${buildinf_floor_list}", buildingFloorStr.toString());
        String uuid = UUID.randomUUID().toString();
        String replaceFilePath = realPath + "\\" + uuid;
        File dirFile = new File(replaceFilePath);
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        HtmlToWordUtil.htmlToWord2(replaceString, new File(replaceFilePath + "\\模板.doc"));
    }

    /**
     * 复制文件的方法
     */
    private void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { // 文件存在时
                InputStream inStream = new FileInputStream(oldPath); // 读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; // 字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
                fs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createWord(Map<String, Object> parameterMap, String realPath) throws Exception {
        String fileName = (String) parameterMap.get("fileName");
        String taskId = (String) parameterMap.get("taskId");
        LteScanTaskEntity lteScanTaskEntity = this.getEntity(LteScanTaskEntity.class, Integer.parseInt(taskId));
        Integer buildingId = lteScanTaskEntity.getBuildingId();
        LteBuildingEntity lteBuildingEntity = this.getEntity(LteBuildingEntity.class, buildingId);
        String description = lteBuildingEntity.getDescription();
        String filePath = realPath + "\\" + fileName;
        //复制一份模板文件,避免冲突
        String newFilePath = "\\files\\report\\" + taskId + "\\";
        String newFileStr = newFilePath + UUID.randomUUID().toString() + ".docx";
        File newFile = new File(newFileStr);
        if (!newFile.exists()) {
            newFile.getParentFile().mkdirs();
        }
        copyFile(filePath, newFileStr);
        CustomXWPFDocument document;
        try {
            /** 打开word2007的文件 */
            OPCPackage opc = POIXMLDocument.openPackage(newFileStr);
            document = new CustomXWPFDocument(opc);
            document.createParagraph().createRun().setText("1.简介");
            document.createParagraph().createRun().setText(description);
            XWPFTable descriptTable = document.createTable(2, 4);
            mergeCellsHorizontal(descriptTable, 0, 1, 3);
            List<XWPFTableRow> descriptTableRows = descriptTable.getRows();
            XWPFTableRow descriptTableRowTitle = descriptTableRows.get(0);
            List<XWPFTableCell> descriptTableCellList = descriptTableRowTitle.getTableCells();
            descriptTableCellList.get(0).setText("网络");
            descriptTableCellList.get(1).setText("测试项");
            XWPFTableRow descriptTableRowContent = descriptTableRows.get(1);
            List<XWPFTableCell> descriptTableCellContentList = descriptTableRowContent.getTableCells();
            descriptTableCellContentList.get(0).setText("电信LTE网络");
            descriptTableCellContentList.get(1).setText("CGI");
            descriptTableCellContentList.get(2).setText("RSRP");
            descriptTableCellContentList.get(3).setText("SINR");

            document.createParagraph().createRun().setText("2.整体情况统计");
            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put("buildingId", buildingId);
            paraMap.put("taskId", taskId);
            List<ReportTableDataVO> list = lteTaskDao.getReportTable(paraMap);
            XWPFTable table = document.createTable((list.size() + 2), 4);
            List<XWPFTableRow> rows = table.getRows();
            XWPFTableRow firstRow = rows.get(0);
            List<XWPFTableCell> firstRowTableCells = firstRow.getTableCells();
            firstRowTableCells.get(0).setText("楼层");
            firstRowTableCells.get(1).setText("测试点数");
            firstRowTableCells.get(2).setText("RSRP>=105dbm并且SNIR>=-3db的点数");
            firstRowTableCells.get(3).setText("覆盖率%");
            StringBuilder floorNameBuilder = new StringBuilder("");
            String bestFloorName = "";
            String worstFloorName = "";
            Double bestPercent = 0d;
            Double worstPercent = 0d;

            Integer tTotalCnt = 0;
            Integer tValidCnt = 0;

            //遍历数据
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    ReportTableDataVO reportTableDataVO = list.get(i);
                    Integer totalCnt = reportTableDataVO.getTotalCnt();
                    Integer validCnt = reportTableDataVO.getValidCnt();
                    tTotalCnt = tTotalCnt + totalCnt;
                    tValidCnt = tValidCnt + validCnt;
                    Double percent = reportTableDataVO.getPercent();
                    String floorName = reportTableDataVO.getFloorName();
                    if (percent > bestPercent) {
                        bestPercent = percent;
                        bestFloorName = floorName;
                    }
                    if (percent < worstPercent) {
                        worstPercent = percent;
                        worstFloorName = floorName;
                    }
                    floorNameBuilder.append(floorName).append(",");
                    XWPFTableRow xwpfTableRow = rows.get(i + 1);
                    List<XWPFTableCell> tableCells = xwpfTableRow.getTableCells();
                    tableCells.get(0).setText(floorName);
                    tableCells.get(1).setText(totalCnt.toString());
                    tableCells.get(2).setText(validCnt.toString());
                    tableCells.get(3).setText(percent.toString());
                }
            }
            //总计数据
            XWPFTableRow totalRow = rows.get(list.size() + 1);
            List<XWPFTableCell> totalCells = totalRow.getTableCells();
            totalCells.get(0).setText("总计");
            totalCells.get(1).setText(tTotalCnt.toString());
            totalCells.get(2).setText(tValidCnt.toString());
            BigDecimal totalPercent = new BigDecimal(tValidCnt).divide(new BigDecimal(tTotalCnt), 2, BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
            totalCells.get(3).setText(totalPercent.toString());

            //插入拼图
            File pic = new File("E:\\src\\demo\\intellij_idea\\jeecg\\jeecg_wyj\\target\\jeecg\\report\\1\\pieChart.jpg");
            FileInputStream is = new FileInputStream(pic);
            XWPFParagraph pargraph = document.createParagraph();

            document.addPictureData(is, XWPFDocument.PICTURE_TYPE_JPEG);
            document.createPicture(document.getAllPictures().size() - 1, 500, 395, pargraph);
            if (is != null) {
                is.close();
            }
            document.createParagraph().createRun().setText("3.分楼层统计");

            //遍历分层列表
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    ReportTableDataVO reportTableDataVO = list.get(i);
                    Integer totalCnt = reportTableDataVO.getTotalCnt();
                    Integer validCnt = reportTableDataVO.getValidCnt();
                    Double percent = reportTableDataVO.percent;
                    Long floorId = reportTableDataVO.getBuildingFloorId();
                    String floorName = reportTableDataVO.getFloorName();
                    document.createParagraph().createRun().setText("3.1 " + floorName);
                    document.createParagraph().createRun().setText("统计");
                    XWPFTable xwpfTable = document.createTable(2, 3);
                    List<XWPFTableRow> tableRows = xwpfTable.getRows();
                    XWPFTableRow xwpfTableRow = tableRows.get(0);
                    List<XWPFTableCell> xwpfTableCells = xwpfTableRow.getTableCells();
                    xwpfTableCells.get(0).setText("测试点数");
                    xwpfTableCells.get(1).setText("RSRP>=105dbm并且SNIR>=-3db的点数");
                    xwpfTableCells.get(2).setText("覆盖率%");
                    XWPFTableRow xwpfTableRow2 = tableRows.get(1);
                    List<XWPFTableCell> xwpfTableCells2 = xwpfTableRow2.getTableCells();
                    xwpfTableCells2.get(0).setText(totalCnt.toString());
                    xwpfTableCells2.get(1).setText(validCnt.toString());
                    xwpfTableCells2.get(2).setText(percent.toString());
                    document.createParagraph().createRun().setText("RSRP分布图");
                    //插入RSRP
                    File file = new File("E:\\src\\demo\\intellij_idea\\jeecg\\jeecg_wyj\\target\\jeecg\\scanData\\" + buildingId + "\\" + floorId + "\\" + taskId + "\\MAP_RSRP.jpg");
                    is = new FileInputStream(file);
                    pargraph = document.createParagraph();
                    document.addPictureData(is, XWPFDocument.PICTURE_TYPE_JPEG);
                    document.createPicture(document.getAllPictures().size() - 1, 500, 395, pargraph);
                    //插入SINR
                    document.createParagraph().createRun().setText("SINR分布图");
                    file = new File("E:\\src\\demo\\intellij_idea\\jeecg\\jeecg_wyj\\target\\jeecg\\scanData\\" + buildingId + "\\" + floorId + "\\" + taskId + "\\MAP_SINR.jpg");
                    is = new FileInputStream(file);
                    pargraph = document.createParagraph();
                    document.addPictureData(is, XWPFDocument.PICTURE_TYPE_JPEG);
                    document.createPicture(document.getAllPictures().size() - 1, 500, 395, pargraph);
                    //插入CGI
                    document.createParagraph().createRun().setText("CGI分布图");
                    file = new File("E:\\src\\demo\\intellij_idea\\jeecg\\jeecg_wyj\\target\\jeecg\\scanData\\" + buildingId + "\\" + floorId + "\\" + taskId + "\\MAP_CGI.jpg");
                    is = new FileInputStream(file);
                    pargraph = document.createParagraph();
                    document.addPictureData(is, XWPFDocument.PICTURE_TYPE_JPEG);
                    document.createPicture(document.getAllPictures().size() - 1, 500, 395, pargraph);
                    if (is != null) {
                        is.close();
                    }
                }
            }
            document.createParagraph().createRun().setText("4.总结");
            document.createParagraph().createRun().setText("本次测试主要测试了上海恒隆广场5层裙楼" + floorNameBuilder.toString() + "。总体覆盖情况良好，总体覆盖率达到了" + totalPercent + "%。其中" + bestFloorName + "最好达到" + bestPercent + "%，" + worstFloorName + "最差为" + worstPercent + "%。");

            String downloadPath = newFilePath + "\\report.docx";


            File f = new File(downloadPath);
            OutputStream os = new FileOutputStream(f);

            document.write(os);
            if (os != null) {
                os.close();
            }
            if (opc != null) {
                opc.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("LteScanTaskServiceImpl.createWord");
    }

    /**
     * @Description: 跨行合并
     */
    private void mergeCellsVertically(XWPFTable table, int col, int fromRow, int toRow) {
        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
            if (rowIndex == fromRow) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    /**
     * @Description: 跨列合并
     */
    private void mergeCellsHorizontal(XWPFTable table, int row, int fromCell, int toCell) {
        for (int cellIndex = fromCell; cellIndex <= toCell; cellIndex++) {
            XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
            if (cellIndex == fromCell) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    public Job buildJob(Long buildingId, Long buildingFloorId, Long taskId, String basePath, String dataPath) throws KettleException {
        KettleEnvironment.init();
        String jobName = basePath + "//indoor//trans//data_load.kjb";
        JobMeta jm = new JobMeta(jobName, null);
        Job job = new Job(null, jm);
        String cid = job.getLogChannelId();
        job.setLogLevel(LogLevel.BASIC);

        job.setVariable("buildingId", buildingId.toString());
        job.setVariable("floorId", buildingFloorId.toString());
        job.setVariable("taskId", taskId.toString());
        job.setVariable("dataPath", dataPath);
        return job;
    }
}