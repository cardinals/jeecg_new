package com.lte.lidar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author pangzhiwei
 * @version V1.0
 * @Title DrawPieImage.java
 * @Package com.demo.jfreechart
 * @Description 使用Jfreechart画饼图
 * @date 2017-11-29
 */
public class DrawPieImage {

    /**
     * 文件夹路径
     */
    private String basePath;

    /**
     * 饼图标题
     */
    private String title;

    /**
     * 饼图数据
     */
    private Map<String, Integer> dataMap;

    /**
     * 默认宽500
     */
    private int width = 700;

    /**
     * 默认高600
     */
    private int height = 600;

    /**
     * 构造方法
     *
     * @param basePath 文件存放路径
     * @param title    饼图标题
     * @param dataMap  饼图数据
     */
    public DrawPieImage(String basePath, String title, Map<String, Integer> dataMap) {
        super();
        this.basePath = basePath;
        this.title = title;
        this.dataMap = dataMap;
    }

    /**
     * 构造方法
     *
     * @param basePath 文件存放路径
     * @param title    饼图标题
     * @param dataMap  饼图数据
     * @param width    宽
     * @param height   高
     */
    public DrawPieImage(String basePath, String title, Map<String, Integer> dataMap, int width, int height) {
        super();
        this.basePath = basePath;
        this.title = title;
        this.dataMap = dataMap;
        this.width = width;
        this.height = height;
    }

    /**
     * 画饼图
     *
     * @throws Exception
     */
    public void draw() throws Exception {
        JFreeChart chart = ChartFactory.createPieChart(this.title, initData(), true, true, false);
        // 通过JFreeChart 对象获得
        PiePlot pieplot = (PiePlot) chart.getPlot();

        // 没有数据的时候显示的内容
        pieplot.setNoDataMessage("无数据可供显示！");

        // 获得一个DecimalFormat对象，主要是设置小数问题,表示小数点后保留两位。
        DecimalFormat df = new DecimalFormat("0.00%");

        // 获得一个NumberFormat对象
        NumberFormat nf = NumberFormat.getNumberInstance();

        // 获得StandardPieSectionLabelGenerator对象,生成的格式，{0}表示section名，{1}表示section的值，{2}表示百分比。可以自定义
        StandardPieSectionLabelGenerator sp = new StandardPieSectionLabelGenerator("{0}:{2}", nf, df);

        // 设置饼图显示百分比
        pieplot.setLabelGenerator(sp);

        // 定义标题中文字体
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(new Font("宋体", Font.BOLD, 20));

        // 定义图书中文字体
        LegendTitle legend = chart.getLegend();
        if (legend != null) {
            legend.setItemFont(new Font("宋体", Font.BOLD, 20));
        }

        // 定义图标数据
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("宋体", Font.BOLD, 15));

        File pieChart = new File(this.basePath + File.separator + "pieChart.jpg");
        ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
    }

    /**
     * 创建饼图数据
     *
     * @return
     */
    private DefaultPieDataset initData() {
        DefaultPieDataset dpd = new DefaultPieDataset(); // 建立一个默认的饼图
        for (Entry<String, Integer> e : dataMap.entrySet()) {
            dpd.setValue(e.getKey(), e.getValue());
        }
        return dpd;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Integer> dataMap = new HashMap<>();
        dataMap.put("覆盖不达标", 25); // 输入数据
        dataMap.put("覆盖达标", 100 - 25);
        new DrawPieImage("E://", "覆盖率", dataMap).draw();
    }
}
