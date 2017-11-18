package com.lte.building_floor.service;

import com.lte.building_floor.entity.LteBuildingFloorEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface LteBuildingFloorServiceI extends CommonService {

    void delete(LteBuildingFloorEntity entity) throws Exception;

    Serializable save(LteBuildingFloorEntity entity) throws Exception;

    void saveOrUpdate(LteBuildingFloorEntity entity) throws Exception;

    void addExportWord() throws Exception;
}
