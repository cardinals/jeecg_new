package com.lte.building_floor.service;

import com.lte.building_floor.entity.LteBuildingFloorEntity;
import com.lte.building_floor.vo.LteBuildingFloorVo;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface LteBuildingFloorServiceI extends CommonService {

    void delete(LteBuildingFloorEntity entity) throws Exception;

    Serializable save(LteBuildingFloorEntity entity) throws Exception;

    void saveOrUpdate(LteBuildingFloorEntity entity) throws Exception;

    List<Map<String, String>> getAll();

    List<LteBuildingFloorEntity> getEntityAll();

    MiniDaoPage<LteBuildingFloorEntity> getAllEntities(@Param("LteBuildingFloorEntity") LteBuildingFloorEntity lteBuildingFloorEntity, @Param("page") int page, @Param("rows") int rows);

    List<LteBuildingFloorVo> getVoAll();

    MiniDaoPage<LteBuildingFloorVo> getAllVos(@Param("lteBuildingFloorVo") LteBuildingFloorVo lteBuildingFloorVo, @Param("page") int page, @Param("rows") int rows);

}
