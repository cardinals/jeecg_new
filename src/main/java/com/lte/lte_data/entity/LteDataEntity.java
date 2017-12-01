package com.lte.lte_data.entity;

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
 * @Description: lte_data
 * @author onlineGenerator
 * @date 2017-11-25 14:49:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "lte_data", schema = "")
@SuppressWarnings("serial")
public class LteDataEntity implements java.io.Serializable {
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
	/**CGI字符串*/
	@Excel(name="CGI字符串",width=15)
	private java.lang.String lteCgiNo;
	/**CGI*/
	@Excel(name="CGI",width=15)
	private java.lang.Integer lteCgi;
	/**RSRP指标*/
	@Excel(name="RSRP指标",width=15)
	private java.lang.Integer lteRsrp;
	/**SINR指标*/
	@Excel(name="SINR指标",width=15)
	private java.lang.Integer lteSinr;
	/**时间戳*/
	@Excel(name="时间戳",width=15)
	private java.lang.Integer dataTimestamp;
	/**年*/
	@Excel(name="年",width=15)
	private java.lang.Integer dataYear;
	/**月*/
	@Excel(name="月",width=15)
	private java.lang.Integer dataMonth;
	/**日*/
	@Excel(name="日",width=15)
	private java.lang.Integer dataDay;
	/**时*/
	@Excel(name="时",width=15)
	private java.lang.Integer dataHour;
	/**分*/
	@Excel(name="分",width=15)
	private java.lang.Integer dataMinute;
	/**秒*/
	@Excel(name="秒",width=15)
	private java.lang.Integer dataSecond;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  CGI字符串
	 */

	@Column(name ="LTE_CGI_NO",nullable=true,length=100)
	public java.lang.String getLteCgiNo(){
		return this.lteCgiNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  CGI字符串
	 */
	public void setLteCgiNo(java.lang.String lteCgiNo){
		this.lteCgiNo = lteCgiNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  CGI
	 */

	@Column(name ="LTE_CGI",nullable=true,length=10)
	public java.lang.Integer getLteCgi(){
		return this.lteCgi;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  CGI
	 */
	public void setLteCgi(java.lang.Integer lteCgi){
		this.lteCgi = lteCgi;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  RSRP指标
	 */

	@Column(name ="LTE_RSRP",nullable=true,length=10)
	public java.lang.Integer getLteRsrp(){
		return this.lteRsrp;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  RSRP指标
	 */
	public void setLteRsrp(java.lang.Integer lteRsrp){
		this.lteRsrp = lteRsrp;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  SINR指标
	 */

	@Column(name ="LTE_SINR",nullable=true,length=10)
	public java.lang.Integer getLteSinr(){
		return this.lteSinr;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  SINR指标
	 */
	public void setLteSinr(java.lang.Integer lteSinr){
		this.lteSinr = lteSinr;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  时间戳
	 */

	@Column(name ="DATA_TIMESTAMP",nullable=true,length=19)
	public java.lang.Integer getDataTimestamp(){
		return this.dataTimestamp;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  时间戳
	 */
	public void setDataTimestamp(java.lang.Integer dataTimestamp){
		this.dataTimestamp = dataTimestamp;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年
	 */

	@Column(name ="DATA_YEAR",nullable=true,length=10)
	public java.lang.Integer getDataYear(){
		return this.dataYear;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年
	 */
	public void setDataYear(java.lang.Integer dataYear){
		this.dataYear = dataYear;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  月
	 */

	@Column(name ="DATA_MONTH",nullable=true,length=10)
	public java.lang.Integer getDataMonth(){
		return this.dataMonth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  月
	 */
	public void setDataMonth(java.lang.Integer dataMonth){
		this.dataMonth = dataMonth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  日
	 */

	@Column(name ="DATA_DAY",nullable=true,length=10)
	public java.lang.Integer getDataDay(){
		return this.dataDay;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  日
	 */
	public void setDataDay(java.lang.Integer dataDay){
		this.dataDay = dataDay;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  时
	 */

	@Column(name ="DATA_HOUR",nullable=true,length=10)
	public java.lang.Integer getDataHour(){
		return this.dataHour;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  时
	 */
	public void setDataHour(java.lang.Integer dataHour){
		this.dataHour = dataHour;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  分
	 */

	@Column(name ="DATA_MINUTE",nullable=true,length=10)
	public java.lang.Integer getDataMinute(){
		return this.dataMinute;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  分
	 */
	public void setDataMinute(java.lang.Integer dataMinute){
		this.dataMinute = dataMinute;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  秒
	 */

	@Column(name ="DATA_SECOND",nullable=true,length=10)
	public java.lang.Integer getDataSecond(){
		return this.dataSecond;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  秒
	 */
	public void setDataSecond(java.lang.Integer dataSecond){
		this.dataSecond = dataSecond;
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
