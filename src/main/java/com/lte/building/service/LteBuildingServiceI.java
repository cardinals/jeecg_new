package com.lte.building.service;

import com.lte.building.entity.LteBuildingEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface LteBuildingServiceI extends CommonService {

    void delete(LteBuildingEntity entity) throws Exception;

    Serializable save(LteBuildingEntity entity) throws Exception;

    void saveOrUpdate(LteBuildingEntity entity) throws Exception;

}
