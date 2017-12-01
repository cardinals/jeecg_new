package com.lte.scan_trail.entity;

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
 * @Description: lte_scan_trail
 * @author onlineGenerator
 * @date 2017-11-25 14:48:27
 * @version V1.0   
 *
 */
@Entity
@Table(name = "lte_scan_trail", schema = "")
@SuppressWarnings("serial")
public class LteScanTrailEntity implements java.io.Serializable {
	/**ID*/
	private java.lang.Integer id;
	/**楼宇ID*/
	@Excel(name="楼宇ID",width=15)
	private java.lang.Integer buildingId;
	/**楼层ID*/
	@Excel(name="楼层ID",width=15)
	private java.lang.Integer buildingFloorId;
	/**任务ID*/
	@Excel(name="任务ID",width=15)
	private java.lang.Integer taskId;
	/**时间戳*/
	@Excel(name="时间戳",width=15)
	private java.lang.Integer trailTimestamp;
	/**年*/
	@Excel(name="年",width=15)
	private java.lang.Integer trailYear;
	/**月*/
	@Excel(name="月",width=15)
	private java.lang.Integer trailMonth;
	/**日*/
	@Excel(name="日",width=15)
	private java.lang.Integer trailDay;
	/**时*/
	@Excel(name="时",width=15)
	private java.lang.Integer trailHour;
	/**分*/
	@Excel(name="分",width=15)
	private java.lang.Integer trailMinute;
	/**秒*/
	@Excel(name="秒",width=15)
	private java.lang.Integer trailSecond;
	/**x坐标*/
	@Excel(name="x坐标",width=15)
	private java.lang.Double trailX;
	/**y坐标*/
	@Excel(name="y坐标",width=15)
	private java.lang.Double trailY;
	/**x坐标*/
	@Excel(name="x坐标",width=15)
	private java.lang.Integer picX;
	/**y坐标*/
	@Excel(name="y坐标",width=15)
	private java.lang.Integer picY;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  任务ID
	 */

	@Column(name ="TASK_ID",nullable=false,length=10)
	public java.lang.Integer getTaskId(){
		return this.taskId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  任务ID
	 */
	public void setTaskId(java.lang.Integer taskId){
		this.taskId = taskId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  时间戳
	 */

	@Column(name ="TRAIL_TIMESTAMP",nullable=true,length=19)
	public java.lang.Integer getTrailTimestamp(){
		return this.trailTimestamp;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  时间戳
	 */
	public void setTrailTimestamp(java.lang.Integer trailTimestamp){
		this.trailTimestamp = trailTimestamp;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年
	 */

	@Column(name ="TRAIL_YEAR",nullable=true,length=10)
	public java.lang.Integer getTrailYear(){
		return this.trailYear;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年
	 */
	public void setTrailYear(java.lang.Integer trailYear){
		this.trailYear = trailYear;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  月
	 */

	@Column(name ="TRAIL_MONTH",nullable=true,length=10)
	public java.lang.Integer getTrailMonth(){
		return this.trailMonth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  月
	 */
	public void setTrailMonth(java.lang.Integer trailMonth){
		this.trailMonth = trailMonth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  日
	 */

	@Column(name ="TRAIL_DAY",nullable=true,length=10)
	public java.lang.Integer getTrailDay(){
		return this.trailDay;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  日
	 */
	public void setTrailDay(java.lang.Integer trailDay){
		this.trailDay = trailDay;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  时
	 */

	@Column(name ="TRAIL_HOUR",nullable=true,length=10)
	public java.lang.Integer getTrailHour(){
		return this.trailHour;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  时
	 */
	public void setTrailHour(java.lang.Integer trailHour){
		this.trailHour = trailHour;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  分
	 */

	@Column(name ="TRAIL_MINUTE",nullable=true,length=10)
	public java.lang.Integer getTrailMinute(){
		return this.trailMinute;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  分
	 */
	public void setTrailMinute(java.lang.Integer trailMinute){
		this.trailMinute = trailMinute;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  秒
	 */

	@Column(name ="TRAIL_SECOND",nullable=true,length=10)
	public java.lang.Integer getTrailSecond(){
		return this.trailSecond;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  秒
	 */
	public void setTrailSecond(java.lang.Integer trailSecond){
		this.trailSecond = trailSecond;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  x坐标
	 */

	@Column(name ="TRAIL_X",nullable=true,scale=8,length=20)
	public java.lang.Double getTrailX(){
		return this.trailX;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  x坐标
	 */
	public void setTrailX(java.lang.Double trailX){
		this.trailX = trailX;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  y坐标
	 */

	@Column(name ="TRAIL_Y",nullable=true,scale=8,length=20)
	public java.lang.Double getTrailY(){
		return this.trailY;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  y坐标
	 */
	public void setTrailY(java.lang.Double trailY){
		this.trailY = trailY;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  x坐标
	 */

	@Column(name ="PIC_X",nullable=true,length=10)
	public java.lang.Integer getPicX(){
		return this.picX;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  x坐标
	 */
	public void setPicX(java.lang.Integer picX){
		this.picX = picX;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  y坐标
	 */

	@Column(name ="PIC_Y",nullable=true,length=10)
	public java.lang.Integer getPicY(){
		return this.picY;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  y坐标
	 */
	public void setPicY(java.lang.Integer picY){
		this.picY = picY;
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
