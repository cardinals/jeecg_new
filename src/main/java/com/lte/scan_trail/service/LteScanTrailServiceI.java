package com.lte.scan_trail.service;
import com.lte.scan_trail.entity.LteScanTrailEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface LteScanTrailServiceI extends CommonService{
	
 	public void delete(LteScanTrailEntity entity) throws Exception;
 	
 	public Serializable save(LteScanTrailEntity entity) throws Exception;
 	
 	public void saveOrUpdate(LteScanTrailEntity entity) throws Exception;
 	
}
