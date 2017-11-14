package com.report.util;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class PoiUtil2 {

    public static void convertHtml(InputStream inputStream, HttpServletRequest request) throws Exception {
        HWPFDocument wordDocument = new HWPFDocument(inputStream);
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches,
                                      float heightInches) {
                return suggestedName;
            }
        });
        wordToHtmlConverter.processDocument(wordDocument);
        Document htmlDocument = wordToHtmlConverter.getDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(out);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        out.close();
        String content = out.toString("utf-8");
//        checkFile(content);
//		checkFile(new String(out.toByteArray()));
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 文件名称
        String fileName = uuid;
        String picRealPathDir = "E:\\export\\";
        // 根据真实路径创建目录
        File picSaveFile = new File(picRealPathDir);
        if (!picSaveFile.exists()) {
            picSaveFile.mkdirs();
        }

        writeFile(content, picRealPathDir + uuid + ".doc");

    }

    public static void writeFile(String content, String path) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            File file = new File(path);
            fos = new FileOutputStream(file);
            bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
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

    public static String localHtmlTOString(String filePath) throws IOException {
//		BufferedReader bis = new BufferedReader(new FileReader(filePath));
        BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));
        StringBuffer sBuffer = new StringBuffer();
        String temp;
        while ((temp = bis.readLine()) != null) {
            if (!temp.trim().equals("")) {
                sBuffer.append(temp).append("\n"); //读完每行后换行
            }
        }
        // 释放资源
        bis.close();
        return sBuffer.toString();
    }

    public static HSSFWorkbook getExcelTemplate(String templateAbsPath) {
        HSSFWorkbook book = null;
        try {
            byte[] bookbyte = getFileInput(templateAbsPath);
            ByteArrayInputStream bais = new ByteArrayInputStream(bookbyte);
            book = new HSSFWorkbook(bais);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }

    public static byte[] getFileInput(String templateAbsPath) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(templateAbsPath);
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();

            byte[] readin = new byte[512];
            int length = 0;
            while ((length = fileInputStream.read(readin)) > 0) {
                baos.write(readin, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new byte[0];
    }

}

