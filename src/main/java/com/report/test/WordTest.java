package com.report.test;

import com.report.util.PoiUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordTest {
    @Test
    public void test1() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", "adsfasdfasf");
        String filePath = "E:\\报告模板v2.docx";
//        String filePath = "E:\\1.docx";
        PoiUtil.testTemplateWrite(filePath, params);
    }

    @Test
    public void test2() throws Exception {
        String str = "报告日期:${reportDate}";
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.find();
        System.out.println("b = " + b);
    }
}
