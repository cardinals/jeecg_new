package com.lte.pgm_config.service.impl;
import com.lte.pgm_config.service.LtePgmConfigServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.lte.pgm_config.entity.LtePgmConfigEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("ltePgmConfigService")
@Transactional
public class LtePgmConfigServiceImpl extends CommonServiceImpl implements LtePgmConfigServiceI {

	
 	public void delete(LtePgmConfigEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(LtePgmConfigEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(LtePgmConfigEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(LtePgmConfigEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(LtePgmConfigEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(LtePgmConfigEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(LtePgmConfigEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("task_id", t.getTaskId());
		map.put("building_id", t.getBuildingId());
		map.put("building_floor_id", t.getBuildingFloorId());
		map.put("pgm_type", t.getPgmType());
		map.put("origin_x", t.getOriginX());
		map.put("origin_y", t.getOriginY());
		map.put("origin_z", t.getOriginZ());
		map.put("resolution", t.getResolution());
		map.put("negate", t.getNegate());
		map.put("occupied_thresh", t.getOccupiedThresh());
		map.put("free_thresh", t.getFreeThresh());
		map.put("pgm_width", t.getPgmWidth());
		map.put("pgm_height", t.getPgmHeight());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("update_date", t.getUpdateDate());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,LtePgmConfigEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{task_id}",String.valueOf(t.getTaskId()));
 		sql  = sql.replace("#{building_id}",String.valueOf(t.getBuildingId()));
 		sql  = sql.replace("#{building_floor_id}",String.valueOf(t.getBuildingFloorId()));
 		sql  = sql.replace("#{pgm_type}",String.valueOf(t.getPgmType()));
 		sql  = sql.replace("#{origin_x}",String.valueOf(t.getOriginX()));
 		sql  = sql.replace("#{origin_y}",String.valueOf(t.getOriginY()));
 		sql  = sql.replace("#{origin_z}",String.valueOf(t.getOriginZ()));
 		sql  = sql.replace("#{resolution}",String.valueOf(t.getResolution()));
 		sql  = sql.replace("#{negate}",String.valueOf(t.getNegate()));
 		sql  = sql.replace("#{occupied_thresh}",String.valueOf(t.getOccupiedThresh()));
 		sql  = sql.replace("#{free_thresh}",String.valueOf(t.getFreeThresh()));
 		sql  = sql.replace("#{pgm_width}",String.valueOf(t.getPgmWidth()));
 		sql  = sql.replace("#{pgm_height}",String.valueOf(t.getPgmHeight()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("lte_pgm_config",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}