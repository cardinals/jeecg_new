package com.jeecg.demo.service;

import com.jeecg.demo.entity.LteBuildingEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface LteBuildingServiceI extends CommonService {

    public void delete(LteBuildingEntity entity) throws Exception;

    public Serializable save(LteBuildingEntity entity) throws Exception;

    public void saveOrUpdate(LteBuildingEntity entity) throws Exception;

}
