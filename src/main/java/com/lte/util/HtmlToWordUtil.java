package com.lte.util;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class HtmlToWordUtil {

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
            InputStreamReader isr = new InputStreamReader(new FileInputStream(sourceFile), "GB2312");
            BufferedReader br = new BufferedReader(isr);
            while (br.ready()) {
                htmlSb.append(br.readLine());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // HTML文件字符串
        String htmlStr = htmlSb.toString();
        return htmlStr;
    }

    public static void htmlToWord2(String content, File targetFile) throws Exception {
        InputStream is = new ByteArrayInputStream(content.getBytes("GBK"));
        OutputStream os = new FileOutputStream(targetFile);
        inputStreamToWord(is, os);
    }

    /**
     * 把is写入到对应的word输出流os中
     * 不考虑异常的捕获，直接抛出
     *
     * @param is
     * @param os
     * @throws IOException
     */
    public static void inputStreamToWord(InputStream is, OutputStream os) throws IOException {
        POIFSFileSystem fs = new POIFSFileSystem();
        //对应于org.apache.poi.hdf.extractor.WordDocument
        fs.createDocument(is, "WordDocument");
        fs.writeFilesystem(os);
        os.close();
        is.close();
    }
}
