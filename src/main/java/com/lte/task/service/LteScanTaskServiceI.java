package com.lte.task.service;

import com.lte.task.entity.LteScanTaskEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface LteScanTaskServiceI extends CommonService {

    public void delete(LteScanTaskEntity entity) throws Exception;

    public Serializable save(LteScanTaskEntity entity) throws Exception;

    public void saveOrUpdate(LteScanTaskEntity entity) throws Exception;

}
