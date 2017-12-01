package com.lte.task.service;

import com.lte.task.entity.LteScanTaskEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.Map;

public interface LteScanTaskServiceI extends CommonService {

    public void delete(LteScanTaskEntity entity) throws Exception;

    public Serializable save(LteScanTaskEntity entity) throws Exception;

    public void saveOrUpdate(LteScanTaskEntity entity) throws Exception;

	//void runTask(Long buildingId,Long buildingFloorId,Long taskId);

	void runTask(Long buildingId, Long buildingFloorId, Long taskId, String basePath);

    void createWordOld(Map<String, Object> parameterMap, String realPath) throws Exception;

    void createWord(Map<String, Object> parameterMap, String realPath) throws Exception;

}
