package com.report.util;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.*;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PoiUtil {

    public static void testTemplateWrite(String filePath, Map<String, Object> params) throws Exception {

        InputStream is = new FileInputStream(filePath);
        XWPFDocument doc = new XWPFDocument(is);
        //替换段落里面的变量
        replaceInPara(doc, params);
        //替换表格里面的变量
        replaceInTable(doc, params);
        String uuid = UUID.randomUUID().toString();
        OutputStream os = new FileOutputStream("E:\\export\\" + uuid + ".docx");
        doc.write(os);
        close(os);
        close(is);
    }

    /**
     * 替换段落里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    private static void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            replaceInPara(para, params);
        }
    }

    /**
     * 替换段落里面的变量
     *
     * @param para   要替换的段落
     * @param params 参数
     */
    private static void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        List<XWPFRun> runs;
        String paragraphText = para.getParagraphText();
        System.out.println("paragraphText = " + paragraphText);
        if (paragraphText.equalsIgnoreCase("${table}")) {
            XWPFDocument xdoc = para.getDocument();
            XWPFTable xTable = xdoc.createTable(5, 3);
            String bgColor="111111";
            CTTbl ttbl = xTable.getCTTbl();
            CTTblPr tblPr = ttbl.getTblPr() == null ? ttbl.addNewTblPr() : ttbl.getTblPr();
            CTTblWidth tblWidth = tblPr.isSetTblW() ? tblPr.getTblW() : tblPr.addNewTblW();
            tblWidth.setW(new BigInteger("8600"));
            tblWidth.setType(STTblWidth.DXA);
            setCellText(xdoc, getCellHight(xTable, 0, 0), "序号",bgColor,1000);
            setCellText(xdoc, getCellHight(xTable, 0, 1), "阶段",bgColor,3800);
            setCellText(xdoc, getCellHight(xTable, 0, 2), "计划工作任务",bgColor,3800);
            int number=0;
            for(int i=1;i<5;i++){
                number++;
                setCellText(xdoc, getCellHight(xTable, number,0), number+"",bgColor,1000);
                setCellText(xdoc, getCellHight(xTable, number,1), "階段名稱",bgColor,3800);
                setCellText(xdoc, getCellHight(xTable, number,2), "任務名稱",bgColor,3800);
            }
        }
        Matcher matcher = matcher(paragraphText);
        if (matcher.find()) {
            String group = matcher.group(1);
            String replaceStr = (String) params.get(group);
            runs = para.getRuns();
            int size = runs.size();
            for (int i = 0; i < size; i++) {
                para.removeRun(0);
            }
            para.insertNewRun(0).setText(replaceStr);
        }
    }

    //设置表格高度
    public static XWPFTableCell getCellHight(XWPFTable xTable,int rowNomber,int cellNumber){
        XWPFTableRow row = null;
        row = xTable.getRow(rowNomber);
        row.setHeight(100);
        XWPFTableCell cell = null;
        cell = row.getCell(cellNumber);
        return cell;
    }

    public static void setCellText(XWPFDocument xDocument, XWPFTableCell cell,
                                    String text, String bgcolor, int width) {
        CTTc cttc = cell.getCTTc();
        CTTcPr cellPr = cttc.addNewTcPr();
        cellPr.addNewTcW().setW(BigInteger.valueOf(width));
        XWPFParagraph pIO =cell.addParagraph();
        cell.removeParagraph(0);
        XWPFRun rIO = pIO.createRun();
        rIO.setFontFamily("微软雅黑");
        rIO.setColor("000000");
        rIO.setFontSize(12);
        rIO.setText(text);
    }

    /**
     * 替换表格里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    private static void replaceInTable(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
            for (XWPFTableRow row : rows) {
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        replaceInPara(para, params);
                    }
                }
            }
        }
    }

    /**
     * 正则匹配字符串
     *
     * @param str
     * @return
     */
    public static Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }

    /**
     * 关闭输入流
     *
     * @param is
     */
    private static void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     *
     * @param os
     */
    private static void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

