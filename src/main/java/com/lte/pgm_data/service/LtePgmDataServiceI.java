package com.lte.pgm_data.service;
import com.lte.pgm_data.entity.LtePgmDataEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface LtePgmDataServiceI extends CommonService{
	
 	public void delete(LtePgmDataEntity entity) throws Exception;
 	
 	public Serializable save(LtePgmDataEntity entity) throws Exception;
 	
 	public void saveOrUpdate(LtePgmDataEntity entity) throws Exception;
 	
}
