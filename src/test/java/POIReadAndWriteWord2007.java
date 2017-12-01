import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * 使用POI，读取word 2007，并实现修改文本内容，在指定位置插入图片，替换表格中的文本内容，并写回到word中
 *
 * @author 付程俊
 */
public class POIReadAndWriteWord2007 {

    public static void main(String[] args) {
        /** 源文件的路径，注：只支持word2007，或许还支持word 2010，其他待测试 */
        String filePath = "E:\\test\\报告模板v2.docx";
        String newFilePath = "E:\\test\\" + UUID.randomUUID().toString() + ".docx";
        copyFile(filePath, newFilePath);
        String tips = POIReadAndWriteWord2007.readwriteWord(newFilePath);
        System.out.println("tips = " + tips);
    }

    /**
     * 读取并操作word2007中的内容
     */
    public static String readwriteWord(String filePath) {
        File isExist = new File(filePath);
        /** 判断源文件是否存在 */
        if (!isExist.exists()) {
            return "源文件不存在！";
        }
        CustomXWPFDocument document;
        try {
            /** 打开word2007的文件 */
            OPCPackage opc = POIXMLDocument.openPackage(filePath);
            document = new CustomXWPFDocument(opc);
            document.createParagraph().createRun().setText("1.简介");
            // TODO: 2017/12/1 添加简介
            document.createParagraph().createRun().setText("description");

            document.createParagraph().createRun().setText("2.整体情况统计");
            XWPFTable table = document.createTable(5, 4);
            List<XWPFTableRow> rows = table.getRows();
            XWPFTableRow firstRow = rows.get(0);
            List<XWPFTableCell> firstRowTableCells = firstRow.getTableCells();
            firstRowTableCells.get(0).setText("楼层");
            firstRowTableCells.get(1).setText("测试点数");
            firstRowTableCells.get(2).setText("RSRP>=105dbm并且SNIR>=-3db的点数");
            firstRowTableCells.get(3).setText("覆盖率%");
            //遍历数据
            // TODO: 2017/12/1 遍历填充整体情况表格数据
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

            String downloadPath = "E:\\test\\replace2.docx";

            File f = new File(downloadPath);
            OutputStream os = new FileOutputStream(f);

            document.write(os);
            if (os != null) {
                os.close();
            }
            if (opc != null) {
                opc.close();
            }
            return "文件转换成功！路径为：" + downloadPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    /**
     * 复制文件的方法
     */
    public static void copyFile(String oldPath, String newPath) {
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
}
