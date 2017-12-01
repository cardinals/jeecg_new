package com.lte.task.dao;

import java.util.List;
import java.util.Map;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;

import com.lte.building_floor.vo.LteBuildingFloorTrail;
import com.lte.task.vo.ReportPieDataVO;
import com.lte.task.vo.ReportTableDataVO;

@MiniDao
public interface LteTaskDao {

    

    @ResultType(LteBuildingFloorTrail.class)
    List<LteBuildingFloorTrail> getAllTrail(@Param("paraMap") Map<String,Object> paraMap);
    
    @ResultType(ReportTableDataVO.class)
    List<ReportTableDataVO> getReportTable(@Param("paraMap") Map<String,Object> paraMap);
    
    @ResultType(ReportPieDataVO.class)
    List<ReportPieDataVO> getReportPie(@Param("paraMap") Map<String,Object> paraMap);
}
