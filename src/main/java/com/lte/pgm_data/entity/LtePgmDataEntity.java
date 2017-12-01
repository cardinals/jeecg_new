package com.lte.pgm_data.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: lte_pgm_data
 * @author onlineGenerator
 * @date 2017-11-25 14:49:19
 * @version V1.0   
 *
 */
@Entity
@Table(name = "lte_pgm_data", schema = "")
@SuppressWarnings("serial")
public class LtePgmDataEntity implements java.io.Serializable {
	/**ID*/
	private java.lang.Integer id;
	/**pgm编号*/
	@Excel(name="pgm编号",width=15)
	private java.lang.Integer pgmConfigId;
	/**任务编号*/
	@Excel(name="任务编号",width=15)
	private java.lang.Integer taskId;
	/**楼宇ID*/
	@Excel(name="楼宇ID",width=15)
	private java.lang.Integer buildingId;
	/**楼层ID*/
	@Excel(name="楼层ID",width=15)
	private java.lang.Integer buildingFloorId;
	/**每一行数据*/
	@Excel(name="每一行数据",width=15)
	private java.lang.String pgmData;
	/**创建人名称*/
	@Excel(name="创建人名称",width=15)
	private java.lang.String createName;
	/**创建人登录名称*/
	@Excel(name="创建人登录名称",width=15)
	private java.lang.String createBy;
	/**创建日期*/
	@Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**更新人名称*/
	@Excel(name="更新人名称",width=15)
	private java.lang.String updateName;
	/**更新人登录名称*/
	@Excel(name="更新人登录名称",width=15)
	private java.lang.String updateBy;
	/**更新日期*/
	@Excel(name="更新日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date updateDate;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name ="ID",nullable=false,length=10)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  ID
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  pgm编号
	 */

	@Column(name ="PGM_CONFIG_ID",nullable=false,length=10)
	public java.lang.Integer getPgmConfigId(){
		return this.pgmConfigId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  pgm编号
	 */
	public void setPgmConfigId(java.lang.Integer pgmConfigId){
		this.pgmConfigId = pgmConfigId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  任务编号
	 */

	@Column(name ="TASK_ID",nullable=true,length=10)
	public java.lang.Integer getTaskId(){
		return this.taskId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  任务编号
	 */
	public void setTaskId(java.lang.Integer taskId){
		this.taskId = taskId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  楼宇ID
	 */

	@Column(name ="BUILDING_ID",nullable=false,length=10)
	public java.lang.Integer getBuildingId(){
		return this.buildingId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  楼宇ID
	 */
	public void setBuildingId(java.lang.Integer buildingId){
		this.buildingId = buildingId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  楼层ID
	 */

	@Column(name ="BUILDING_FLOOR_ID",nullable=false,length=10)
	public java.lang.Integer getBuildingFloorId(){
		return this.buildingFloorId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  楼层ID
	 */
	public void setBuildingFloorId(java.lang.Integer buildingFloorId){
		this.buildingFloorId = buildingFloorId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  每一行数据
	 */

	@Column(name ="PGM_DATA",nullable=true,length=65535)
	public java.lang.String getPgmData(){
		return this.pgmData;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  每一行数据
	 */
	public void setPgmData(java.lang.String pgmData){
		this.pgmData = pgmData;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=100)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=100)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=100)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
}
