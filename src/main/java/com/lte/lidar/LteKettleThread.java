package com.lte.lidar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pentaho.di.job.Job;

import com.lte.building_floor.vo.LteBuildingFloorTrail;
import com.lte.task.dao.LteTaskDao;


public class LteKettleThread implements Runnable{
	  
	private Long buildingId;
	private Long floorId;
	private Long taskId;
	private Job job;
	private String fileFolder;
	private LteTaskDao taskDao;
	public LteKettleThread(Long buildingId,Long floorId,Long taskId,Job job,String fileFolder,LteTaskDao taskDao){
		this.buildingId = buildingId;
		this.floorId = floorId;
		this.taskId = taskId;
		this.job = job;
		this.fileFolder = fileFolder;
		this.taskDao = taskDao;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//先把pgm转成txt
			//PgmToDataUtils.pgmToTxt(fileFolder);
			
			
			//再把数据导入  //王玉珏的etl工具.这里注释掉. 已经导了三层楼的数据了.
    	    //job.start();
      	    //job.waitUntilFinished();   	    
      	    //job.setFinished(true);
      	     
			Map<String,Object> paraMap = new HashMap<String,Object>();
			paraMap.put("buildingId", buildingId);
			paraMap.put("floorId", floorId);
			paraMap.put("taskId", taskId);
			List<LteBuildingFloorTrail> list =  taskDao.getAllTrail(paraMap);
			
			
      	    //pzw的画图... 
			DrawPgmImage dp = new DrawPgmImage(fileFolder,list);
			dp.draw();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
