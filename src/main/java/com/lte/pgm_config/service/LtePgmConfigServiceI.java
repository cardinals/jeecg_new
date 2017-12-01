package com.lte.pgm_config.service;
import com.lte.pgm_config.entity.LtePgmConfigEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface LtePgmConfigServiceI extends CommonService{
	
 	public void delete(LtePgmConfigEntity entity) throws Exception;
 	
 	public Serializable save(LtePgmConfigEntity entity) throws Exception;
 	
 	public void saveOrUpdate(LtePgmConfigEntity entity) throws Exception;
 	
}
