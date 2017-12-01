package com.lte.lidar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.lte.building_floor.vo.LteBuildingFloorTrail;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @Title DrawPgmImage.java
 * @Package com.lte.lidar
 * @Description PGM文件转换JPG图片
 * @author pangzhiwei
 * @date 2017-11-28
 * @version V1.0
 */
public class DrawPgmImage {

    /**
     * 图片-楼层
     */
    private static final String IMG_MAP_ORGINAL = "MAP_ORGINAL.jpg";

    /**
     * 图片-RSRP信号轨迹
     */
    private static final String IMG_MAP_RSRP = "MAP_RSRP.jpg";

    /**
     * 图片-SINR信号轨迹
     */
    private static final String IMG_MAP_SINR = "MAP_SINR.jpg";

    /**
     * 图片-CGI信号轨迹
     */
    private static final String IMG_MAP_CGI = "MAP_CGI.jpg";

    /**
     * 图片扩展名
     */
    private static final String IMG_EXT = "jpg";

    /**
     * 图片偏移量
     */
    private static final int IMG_OFFSET = 200;

    /**
     * 文件夹路径
     */
    private String basePath;

    /**
     * 轨迹列表数据
     */
    private List<LteBuildingFloorTrail> list;

    /**
     * 构造方法
     * @param basePath
     * @param list
     */
    public DrawPgmImage(String basePath, List<LteBuildingFloorTrail> list) {
        super();
        this.basePath = basePath;
        this.list = list;
    }

    /**
     * 画图
     * @throws Exception
     */
    public void draw() throws Exception {
        String pgmFilePath = null;
        File folder = new File(this.basePath);
        File files[] = folder.listFiles();
        for (File file : files) {
            if (file.getName().endsWith(".pgm")) {
                pgmFilePath = this.basePath + File.separator + file.getName();
                Data2DModel data = this.parsePgmFile(pgmFilePath);
                // 创建orginal图片
                String orginalImgPath = this.basePath + File.separator + IMG_MAP_ORGINAL;
                boolean isEnd = this.createImage(data.getData2D(), data.getWidth(), data.getHeight(), orginalImgPath);
                if (isEnd) {
                    this.createSinrImage(orginalImgPath);
                    this.createRsrpImage(orginalImgPath);
                    this.createCgiImage(orginalImgPath);
                }
                // 创建其他图片
                break;
            }
        }
    }

    /**
     * 解析PGM文件
     * @param pgmFilePath
     * @return
     * @throws Exception
     */
    private Data2DModel parsePgmFile(String pgmFilePath) throws Exception {
        FileInputStream f = new FileInputStream(pgmFilePath);
        Scanner scan = new Scanner(f);
        scan.nextLine();
        scan.nextLine();
        int picWidth = scan.nextInt();
        int picHeight = scan.nextInt();
        scan.nextInt();
        f.close();
        f = new FileInputStream(pgmFilePath);
        DataInputStream d = new DataInputStream(f);
        int numnewlines = 4;
        while (numnewlines > 0) {
            char c;
            do {
                c = (char) (d.readUnsignedByte());
            } while (c != '\n');
            numnewlines--;
        }
        int[][] data2D = new int[picHeight][picWidth];
        for (int row = 0; row < picHeight; row++) {
            for (int col = 0; col < picWidth; col++) {
                data2D[row][col] = d.readUnsignedByte();
            }
        }
        scan.close();
        d.close();
        f.close();

        Data2DModel data = new Data2DModel();
        data.setData2D(data2D);
        data.setWidth(picWidth);
        data.setHeight(picHeight);
        return data;
    }

    /**
     * 创建RSRP轨迹图片
     * @param orginalImgPath 楼层图片路径
     * @throws Exception
     */
    private void createRsrpImage(String orginalImgPath) throws Exception {
        File file = new File(orginalImgPath);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D g = bi.createGraphics();
        for (LteBuildingFloorTrail l : list) {
            g.setColor(this.getRSRPColor(l.getLte_rsrp())); // 字的颜色
            g.drawString("*", l.getPic_x(), l.getPic_y());
        }

        // 添加图例
        int startX = bi.getWidth() - 190;
        int startY = 40;
        int h = 20;// 字体大小和正方形的边长
        int offsetX = 40;// x轴偏移量
        int offsetY = 30;// y轴偏移量

        Font font1 = new Font("宋体", Font.BOLD, h);
        g.setColor(Color.black);
        g.setFont(font1);
        g.drawString("单位：dbm", startX, h);

        g.setColor(Color.red);
        g.fillRect(startX, startY, h, h);
        g.setColor(Color.black);
        g.setFont(font1);
        g.drawString("小于-115", startX + offsetX, h + startY);

        g.setColor(Color.yellow);
        g.fillRect(startX, offsetY + startY, h, h);
        g.setColor(Color.black);
        g.setFont(font1);
        g.drawString("-115至-105", startX + offsetX, h + offsetY + startY);

        g.setColor(Color.green);
        g.fillRect(startX, 2 * offsetY + startY, h, h);
        g.setColor(Color.black);
        g.setFont(font1);
        g.drawString("-105至-95", startX + offsetX, h + 2 * offsetY + startY);

        g.setColor(Color.blue);
        g.fillRect(startX, 3 * offsetY + startY, h, h);
        g.setColor(Color.black);
        g.setFont(font1);
        g.drawString("大于-95", startX + offsetX, h + 3 * offsetY + startY);

        g.dispose();
        String filePath = this.basePath + File.separator + IMG_MAP_RSRP;
        ImageIO.write(bi, IMG_EXT, new File(filePath));
    }

    /**
     * 创建SINR轨迹图片
     * @param orginalImgPath 楼层图片路径
     * @throws Exception
     */
    private void createSinrImage(String orginalImgPath) throws Exception {
        File file = new File(orginalImgPath);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D g = bi.createGraphics();
        for (LteBuildingFloorTrail l : list) {
            g.setColor(this.getSINRColor(l.getLte_sinr())); // 字的颜色
            g.drawString("*", l.getPic_x(), l.getPic_y());
        }

        // 添加图例
        int startX = bi.getWidth() - 190;
        int startY = 40;
        int h = 20;// 字体大小和正方形的边长
        int offsetX = 40;// x轴偏移量
        int offsetY = 30;// y轴偏移量

        Font font1 = new Font("宋体", Font.BOLD, h);
        g.setColor(Color.black);
        g.setFont(font1);
        g.drawString("单位：db", startX, h);

        g.setColor(Color.red);
        g.fillRect(startX, startY, h, h);
        g.setColor(Color.black);
        g.setFont(font1);
        g.drawString("小于-3", startX + offsetX, h + startY);

        g.setColor(Color.yellow);
        g.fillRect(startX, offsetY + startY, h, h);
        g.setColor(Color.black);
        g.setFont(font1);
        g.drawString("-3至0", startX + offsetX, h + offsetY + startY);

        g.setColor(Color.green);
        g.fillRect(startX, 2 * offsetY + startY, h, h);
        g.setColor(Color.black);
        g.setFont(font1);
        g.drawString("大于0", startX + offsetX, h + 2 * offsetY + startY);

        g.dispose();
        String filePath = this.basePath + File.separator + IMG_MAP_SINR;
        ImageIO.write(bi, IMG_EXT, new File(filePath));
    }

    /**
     * 创建CGI轨迹图片
     * @param orginalImgPath 楼层图片路径
     * @throws Exception
     */
    private void createCgiImage(String orginalImgPath) throws Exception {
        File file = new File(orginalImgPath);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D g = bi.createGraphics();
        Map<String, Color> map = new HashMap<String, Color>();
        for (LteBuildingFloorTrail l : list) {
            Color c = new Color(l.getLte_cgi());
            g.setColor(c); // 字的颜色
            g.drawString("*", l.getPic_x(), l.getPic_y());

            map.put(String.valueOf(l.getLte_cgi()), c);
        }

        // 添加图例
        int startX = bi.getWidth() - 190;
        int startY = 40;
        int h = 20;// 字体大小和正方形的边长
        int offsetX = 40;// x轴偏移量
        int offsetY = 30;// y轴偏移量

        Font font1 = new Font("宋体", Font.BOLD, h);
        int i = 0;
        for (Map.Entry<String, Color> e : map.entrySet()) {

            g.setColor(e.getValue());
            g.fillRect(startX, startY + i * offsetY, h, h);
            g.setColor(Color.black);
            g.setFont(font1);
            g.drawString(e.getKey(), startX + offsetX, startY + h + i * offsetY);
            i++;
        }
        g.dispose();
        String filePath = this.basePath + File.separator + IMG_MAP_CGI;
        ImageIO.write(bi, IMG_EXT, new File(filePath));
    }

    /**
     * 创建图片
     * @param data2D 图片二位数组
     * @param width 图片宽
     * @param height 图片高
     * @param orginalImgPath 图片保存路径
     * @return
     * @throws Exception
     */
    private boolean createImage(int[][] data2D, int width, int height, String orginalImgPath) throws Exception {
        try {
            // 宽度 高度
            BufferedImage bimage = new BufferedImage(width + IMG_OFFSET, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bimage.createGraphics();
            g.fillRect(0, 0, width + IMG_OFFSET, height); // 画一个矩形
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // 去除锯齿(当设置的字体过大的时候,会出现锯齿)
            for (int i = 0; i < data2D.length; i++) {
                for (int j = 0; j < data2D[i].length; j++) {
                    try {
                        Integer iColor = Integer.valueOf(data2D[i][j]);
                        Color c = new Color(iColor, iColor, iColor);
                        g.setColor(c); // 字的颜色
                        g.drawString("*", j, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            // 在指定坐标除添加文字
            g.dispose();
            FileOutputStream out = new FileOutputStream(orginalImgPath); // 指定输出文件
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage);
            param.setQuality(50f, true);
            encoder.encode(bimage, param); // 存盘
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("文件绘制出错");
        }
        return true;
    }

    /**
     * 小于-115dbm的用红色 -115dbm-105dbm之间用黄色 -105dbm-95dbm之间用浅绿色 大于等于-95dbm用深绿色
     * @param signalLevel
     * @return
     */
    private Color getRSRPColor(int signalLevel) {
        if (signalLevel < -115) {
            return Color.red;
        } else if (signalLevel < -105) {
            return Color.yellow;
        } else if (signalLevel < -95) {
            return Color.green;
        } else {
            return Color.blue;
        }
    }

    /**
     * 小于-3db的用红色，-3db~0db之间用黄色，大于等于0db用深绿色
     * @param signalLevel
     * @return
     */
    private Color getSINRColor(int signalLevel) {
        if (signalLevel < -3) {
            return Color.red;
        } else if (signalLevel < 0) {
            return Color.yellow;
        } else {
            return Color.green;
        }
    }

    /**
     * 内部类-存储解析PGM文件的数据
     */
    private class Data2DModel {

        private int[][] data2D;

        private int width;

        private int height;

        public int[][] getData2D() {
            return data2D;
        }

        public void setData2D(int[][] data2D) {
            this.data2D = data2D;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
