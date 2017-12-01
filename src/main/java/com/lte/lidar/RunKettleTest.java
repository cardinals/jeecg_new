package com.lte.lidar;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.logging.LogLevel;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;

public class RunKettleTest {
	public static void main(String[] args) {
		try {
			String jobName = "E://work//workspace//jeecg//jeecg//src//main//webapp//indoor//trans//data_load.kjb";
			Long buildingId = 1L;
			Long floorId = 7L;
			Long taskId = 1L;
			String fileFolder = "E://work//workspace//jeecg//jeecg//src//main//webapp//scanData//"+buildingId+"//"+floorId+"//"+taskId;
			KettleEnvironment.init();
    	    JobMeta jm = new JobMeta(jobName,null);
    	    Job job = new Job(null,jm);
    	    String cid = job.getLogChannelId();
    	    job.setLogLevel(LogLevel.BASIC);
    	    
    	    job.setVariable("buildingId", buildingId.toString());
    	    job.setVariable("floorId",floorId.toString());
    	    job.setVariable("taskId",taskId.toString());
    	    job.setVariable("dataPath",fileFolder);
//			LteKettleThread lt = new LteKettleThread(buildingId, floorId, taskId, job,fileFolder);
//			Thread taskThread = new Thread(lt);
//			taskThread.start();
			System.out.println("任务Id:"+cid);
			System.out.println("任务已经开始,请稍后导出报告!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
