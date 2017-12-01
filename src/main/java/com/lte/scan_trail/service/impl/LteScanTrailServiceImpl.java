package com.lte.scan_trail.service.impl;
import com.lte.scan_trail.service.LteScanTrailServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.lte.scan_trail.entity.LteScanTrailEntity;
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

@Service("lteScanTrailService")
@Transactional
public class LteScanTrailServiceImpl extends CommonServiceImpl implements LteScanTrailServiceI {

	
 	public void delete(LteScanTrailEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(LteScanTrailEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(LteScanTrailEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(LteScanTrailEntity t) throws Exception{
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
	private void doUpdateBus(LteScanTrailEntity t) throws Exception{
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
	private void doDelBus(LteScanTrailEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(LteScanTrailEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("building_id", t.getBuildingId());
		map.put("building_floor_id", t.getBuildingFloorId());
		map.put("task_id", t.getTaskId());
		map.put("trail_timestamp", t.getTrailTimestamp());
		map.put("trail_year", t.getTrailYear());
		map.put("trail_month", t.getTrailMonth());
		map.put("trail_day", t.getTrailDay());
		map.put("trail_hour", t.getTrailHour());
		map.put("trail_minute", t.getTrailMinute());
		map.put("trail_second", t.getTrailSecond());
		map.put("trail_x", t.getTrailX());
		map.put("trail_y", t.getTrailY());
		map.put("pic_x", t.getPicX());
		map.put("pic_y", t.getPicY());
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
 	public String replaceVal(String sql,LteScanTrailEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{building_id}",String.valueOf(t.getBuildingId()));
 		sql  = sql.replace("#{building_floor_id}",String.valueOf(t.getBuildingFloorId()));
 		sql  = sql.replace("#{task_id}",String.valueOf(t.getTaskId()));
 		sql  = sql.replace("#{trail_timestamp}",String.valueOf(t.getTrailTimestamp()));
 		sql  = sql.replace("#{trail_year}",String.valueOf(t.getTrailYear()));
 		sql  = sql.replace("#{trail_month}",String.valueOf(t.getTrailMonth()));
 		sql  = sql.replace("#{trail_day}",String.valueOf(t.getTrailDay()));
 		sql  = sql.replace("#{trail_hour}",String.valueOf(t.getTrailHour()));
 		sql  = sql.replace("#{trail_minute}",String.valueOf(t.getTrailMinute()));
 		sql  = sql.replace("#{trail_second}",String.valueOf(t.getTrailSecond()));
 		sql  = sql.replace("#{trail_x}",String.valueOf(t.getTrailX()));
 		sql  = sql.replace("#{trail_y}",String.valueOf(t.getTrailY()));
 		sql  = sql.replace("#{pic_x}",String.valueOf(t.getPicX()));
 		sql  = sql.replace("#{pic_y}",String.valueOf(t.getPicY()));
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
					javaInter.execute("lte_scan_trail",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}