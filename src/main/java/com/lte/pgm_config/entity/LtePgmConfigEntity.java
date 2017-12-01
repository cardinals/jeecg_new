package com.lte.pgm_config.entity;

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
 * @Description: lte_pgm_config
 * @author onlineGenerator
 * @date 2017-11-25 14:48:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "lte_pgm_config", schema = "")
@SuppressWarnings("serial")
public class LtePgmConfigEntity implements java.io.Serializable {
	/**ID*/
	private java.lang.Integer id;
	/**ID*/
	@Excel(name="ID",width=15)
	private java.lang.Integer taskId;
	/**ID*/
	@Excel(name="ID",width=15)
	private java.lang.Integer buildingId;
	/**ID*/
	@Excel(name="ID",width=15)
	private java.lang.Integer buildingFloorId;
	/**pgm类型*/
	@Excel(name="pgm类型",width=15)
	private java.lang.String pgmType;
	/**pgm分辨率*/
	@Excel(name="pgm分辨率",width=15)
	private java.lang.Double originX;
	/**原点x*/
	@Excel(name="原点x",width=15)
	private java.lang.Double originY;
	/**原点y*/
	@Excel(name="原点y",width=15)
	private java.lang.Double originZ;
	/**原点z*/
	@Excel(name="原点z",width=15)
	private java.lang.Double resolution;
	/**negate*/
	@Excel(name="negate",width=15)
	private java.lang.Double negate;
	/**occupied_thresh*/
	@Excel(name="occupied_thresh",width=15)
	private java.lang.Double occupiedThresh;
	/**free_thresh*/
	@Excel(name="free_thresh",width=15)
	private java.lang.Double freeThresh;
	/**pgm宽*/
	@Excel(name="pgm宽",width=15)
	private java.lang.Integer pgmWidth;
	/**pgm高*/
	@Excel(name="pgm高",width=15)
	private java.lang.Integer pgmHeight;
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
	 *@return: java.lang.Integer  ID
	 */

	@Column(name ="TASK_ID",nullable=false,length=10)
	public java.lang.Integer getTaskId(){
		return this.taskId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  ID
	 */
	public void setTaskId(java.lang.Integer taskId){
		this.taskId = taskId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  ID
	 */

	@Column(name ="BUILDING_ID",nullable=false,length=10)
	public java.lang.Integer getBuildingId(){
		return this.buildingId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  ID
	 */
	public void setBuildingId(java.lang.Integer buildingId){
		this.buildingId = buildingId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  ID
	 */

	@Column(name ="BUILDING_FLOOR_ID",nullable=false,length=10)
	public java.lang.Integer getBuildingFloorId(){
		return this.buildingFloorId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  ID
	 */
	public void setBuildingFloorId(java.lang.Integer buildingFloorId){
		this.buildingFloorId = buildingFloorId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  pgm类型
	 */

	@Column(name ="PGM_TYPE",nullable=true,length=100)
	public java.lang.String getPgmType(){
		return this.pgmType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  pgm类型
	 */
	public void setPgmType(java.lang.String pgmType){
		this.pgmType = pgmType;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  pgm分辨率
	 */

	@Column(name ="ORIGIN_X",nullable=true,scale=10,length=20)
	public java.lang.Double getOriginX(){
		return this.originX;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  pgm分辨率
	 */
	public void setOriginX(java.lang.Double originX){
		this.originX = originX;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  原点x
	 */

	@Column(name ="ORIGIN_Y",nullable=true,scale=10,length=20)
	public java.lang.Double getOriginY(){
		return this.originY;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  原点x
	 */
	public void setOriginY(java.lang.Double originY){
		this.originY = originY;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  原点y
	 */

	@Column(name ="ORIGIN_Z",nullable=true,scale=10,length=20)
	public java.lang.Double getOriginZ(){
		return this.originZ;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  原点y
	 */
	public void setOriginZ(java.lang.Double originZ){
		this.originZ = originZ;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  原点z
	 */

	@Column(name ="RESOLUTION",nullable=true,scale=10,length=20)
	public java.lang.Double getResolution(){
		return this.resolution;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  原点z
	 */
	public void setResolution(java.lang.Double resolution){
		this.resolution = resolution;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  negate
	 */

	@Column(name ="NEGATE",nullable=true,scale=10,length=20)
	public java.lang.Double getNegate(){
		return this.negate;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  negate
	 */
	public void setNegate(java.lang.Double negate){
		this.negate = negate;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  occupied_thresh
	 */

	@Column(name ="OCCUPIED_THRESH",nullable=true,scale=10,length=20)
	public java.lang.Double getOccupiedThresh(){
		return this.occupiedThresh;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  occupied_thresh
	 */
	public void setOccupiedThresh(java.lang.Double occupiedThresh){
		this.occupiedThresh = occupiedThresh;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  free_thresh
	 */

	@Column(name ="FREE_THRESH",nullable=true,scale=10,length=20)
	public java.lang.Double getFreeThresh(){
		return this.freeThresh;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  free_thresh
	 */
	public void setFreeThresh(java.lang.Double freeThresh){
		this.freeThresh = freeThresh;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  pgm宽
	 */

	@Column(name ="PGM_WIDTH",nullable=true,length=10)
	public java.lang.Integer getPgmWidth(){
		return this.pgmWidth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  pgm宽
	 */
	public void setPgmWidth(java.lang.Integer pgmWidth){
		this.pgmWidth = pgmWidth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  pgm高
	 */

	@Column(name ="PGM_HEIGHT",nullable=true,length=10)
	public java.lang.Integer getPgmHeight(){
		return this.pgmHeight;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  pgm高
	 */
	public void setPgmHeight(java.lang.Integer pgmHeight){
		this.pgmHeight = pgmHeight;
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
