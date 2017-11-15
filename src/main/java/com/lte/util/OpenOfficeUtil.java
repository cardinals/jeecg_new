package com.lte.util;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OpenOfficeUtil {

    private static final Logger logger = Logger.getLogger(OpenOfficeUtil.class);

    /**
     * 文档转换
     *
     * @param sourceFile 需要转换的word文档
     * @param targetFile 转换之后html的存放路径
     * @return 转换之后的html文件
     */
    public static File convert(File sourceFile, File targetFile) {
        // 创建Openoffice连接
        OpenOfficeConnection con = new SocketOpenOfficeConnection(8100);
        try {
            // 连接
            con.connect();
            // 创建转换器
            DocumentConverter converter = new OpenOfficeDocumentConverter(con);
            // 转换文档问html
            converter.convert(sourceFile, targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭openoffice连接
            if (con != null) {
                con.disconnect();
            }
        }
        return targetFile;
    }

    /**
     * 将文件转换成html文件，并且获取html文件代码。
     *
     * @param sourceFile 需要转换的文档
     * @return 转换成功的html代码
     */
    public static String toHtmlString(File sourceFile) {
        // 获取html文件流
        StringBuffer htmlSb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile)));
            while (br.ready()) {
                htmlSb.append(br.readLine());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // HTML文件字符串
        String htmlStr = htmlSb.toString();
        // 返回经过清洁的html文本
        return clearFormat(htmlStr, sourceFile.getPath());
    }

    /**
     * 清除一些不需要的html标记
     *
     * @param htmlStr 带有复杂html标记的html语句
     * @return 去除了不需要html标记的语句
     */
    protected static String clearFormat(String htmlStr, String docImgPath) {
        // 获取body内容的正则
        String bodyReg = "<BODY .*</BODY>";
        Pattern bodyPattern = Pattern.compile(bodyReg);
        Matcher bodyMatcher = bodyPattern.matcher(htmlStr);
        if (bodyMatcher.find()) {
            // 获取BODY内容，并转化BODY标签为DIV
            htmlStr = bodyMatcher.group().replaceFirst("<BODY", "<DIV")
                    .replaceAll("</BODY>", "</DIV>");
        }
        // 调整图片地址
        htmlStr = htmlStr.replaceAll("<IMG SRC=\"", "<IMG SRC=\"" + docImgPath
                + "/");
        // 把<P></P>转换成</div></div>保留样式
        // content = content.replaceAll("(<P)([^>]*>.*?)(<\\/P>)",
        // "<div$2</div>");
        // 把<P></P>转换成</div></div>并删除样式
        htmlStr = htmlStr.replaceAll("(<P)([^>]*)(>.*?)(<\\/P>)", "<p$3</p>");
        // 删除不需要的标签
        htmlStr = htmlStr
                .replaceAll(
                        "<[/]?(font|FONT|span|SPAN|xml|XML|del|DEL|ins|INS|meta|META|[ovwxpOVWXP]:\\w+)[^>]*?>",
                        "");
        // 删除不需要的属性
        htmlStr = htmlStr
                .replaceAll(
                        "<([^>]*)(?:lang|LANG|class|CLASS|style|STYLE|size|SIZE|face|FACE|[ovwxpOVWXP]:\\w+)=(?:'[^']*'|\"\"[^\"\"]*\"\"|[^>]+)([^>]*)>",
                        "<$1$2>");
        return htmlStr;
    }

    /**
     * 写文件
     * @param content
     * @param path
     */
    public static void writeFile(String content, String path) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            File file = new File(path);
            fos = new FileOutputStream(file);
             bw = new BufferedWriter(new OutputStreamWriter(fos, "GB2312"));
//            bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
            bw.write(content);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fos != null)
                    fos.close();
            } catch (IOException ie) {
            }
        }
    }
}