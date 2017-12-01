package com.lte.lte_data.service;
import com.lte.lte_data.entity.LteDataEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface LteDataServiceI extends CommonService{
	
 	public void delete(LteDataEntity entity) throws Exception;
 	
 	public Serializable save(LteDataEntity entity) throws Exception;
 	
 	public void saveOrUpdate(LteDataEntity entity) throws Exception;
 	
}
