package com.lte.lidar;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PgmToDataUtils {
	/*
	 *处理.pgm文件, 在filePath下面生成一个对应的txt文件
	 * 
	 */
	public static void pgmToTxt(String filePath) throws IOException {
		System.out.println(filePath);
		File folder = new File(filePath);
		File files[] = folder.listFiles();
		for(File file:files){
			if(file.getName().endsWith(".pgm")){
				File pmgData = new File(filePath+"//pgm.data");
				if(!pmgData.exists()){
					pmgData.createNewFile();
				}
				
				FileWriter pgmDataWriter = new FileWriter(pmgData);
				
				
				FileInputStream fileInputStream = new FileInputStream(file);
				Scanner scan = new Scanner(fileInputStream);
				scan.nextLine();
				scan.nextLine();
				
				int picWidth = scan.nextInt();
				int picHeight = scan.nextInt();
				int maxvalue = scan.nextInt();
				fileInputStream.close();

				 // Now parse the file as binary data
				 fileInputStream = new FileInputStream(file);
				 DataInputStream dis = new DataInputStream(fileInputStream);

				 // look for 4 lines (i.e.: the header) and discard them
				 int numnewlines = 4;
				 while (numnewlines > 0) {
				     char c;
				     do {
				         c = (char)(dis.readUnsignedByte());
				     } while (c != '\n');
				     numnewlines--;
				 }

				 // read the image data
				 int[][] data2D = new int[picHeight][picWidth];
				 for (int row = 0; row < picHeight; row++) {
				     for (int col = 0; col < picWidth; col++) {
				         data2D[row][col] = dis.readUnsignedByte();
				         pgmDataWriter.write(data2D[row][col] + " ");
				         //System.out.print(data2D[row][col] + " ");
				     }
				     pgmDataWriter.write("\r");
				 }
				 pgmDataWriter.close();
				 scan.close();
				 dis.close();
			}
			
		}
		
		
	}
}
 