package com.lte.building_floor.dao;

import com.jeecg.demo.entity.JeecgDemoEntity;
import com.lte.building_floor.entity.LteBuildingFloorEntity;
import com.lte.building_floor.vo.LteBuildingFloorVo;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import java.util.List;
import java.util.Map;

@MiniDao
public interface LteBuildingFloorDao {

    @Sql("SELECT * FROM lte_building_floor WHERE 1 = 1")
    List<Map<String, String>> getAll();

    @Sql("SELECT * FROM lte_building_floor WHERE 1 = 1")
    List<LteBuildingFloorEntity> getEntityAll();

    @ResultType(LteBuildingFloorVo.class)
    MiniDaoPage<LteBuildingFloorEntity> getAllEntities(@Param("LteBuildingFloorEntity") LteBuildingFloorEntity lteBuildingFloorEntity, @Param("page") int page, @Param("rows") int rows);

    @Sql(
            "SELECT lbf.*,lb.building_name\n" +
                    "FROM lte_building_floor lbf\n" +
                    "  LEFT JOIN lte_building lb ON lb.id = lbf.building_id\n" +
                    "WHERE 1 = 1"
    )
    List<LteBuildingFloorVo> getVoAll();

    @ResultType(LteBuildingFloorVo.class)
    MiniDaoPage<LteBuildingFloorVo> getAllVos(@Param("lteBuildingFloorVo") LteBuildingFloorVo lteBuildingFloorVo, @Param("page") int page, @Param("rows") int rows);
}
