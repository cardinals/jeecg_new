package com.lte.building.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: lte_building
 * @author onlineGenerator
 * @date 2017-11-18 15:59:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "lte_building", schema = "")
@SuppressWarnings("serial")
public class LteBuildingEntity implements java.io.Serializable {
	/**ID*/

	private Integer id;
	/**楼宇名称*/
    @Excel(name="楼宇名称",width=15)
		
	private String buildingName;
	/**楼宇编号*/
    @Excel(name="楼宇编号",width=15)
		
	private String buildingNo;
	/**楼宇类型*/
    @Excel(name="楼宇类型",width=15)
		
	private String buildingType;
	/**楼宇属性*/
    @Excel(name="楼宇属性",width=15)
		
	private String buildingProperty;
	/**楼宇描述*/
    @Excel(name="楼宇描述",width=15)
		
	private String description;
	/**楼宇备注*/
    @Excel(name="楼宇备注",width=15)
		
	private String note;
	/**创建人名称*/

	private String createName;
	/**创建人登录名称*/

	private String createBy;
	/**创建日期*/

	private Date createDate;
	/**更新人名称*/

	private String updateName;
	/**更新人登录名称*/

	private String updateBy;
	/**更新日期*/

	private Date updateDate;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID",nullable=false,length=10)
	public Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  ID
	 */
	public void setId(Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇名称
	 */
	@Column(name ="BUILDING_NAME",nullable=true,length=100)
	public String getBuildingName(){
		return this.buildingName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇名称
	 */
	public void setBuildingName(String buildingName){
		this.buildingName = buildingName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇编号
	 */
	@Column(name ="BUILDING_NO",nullable=true,length=100)
	public String getBuildingNo(){
		return this.buildingNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇编号
	 */
	public void setBuildingNo(String buildingNo){
		this.buildingNo = buildingNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇类型
	 */
	@Column(name ="BUILDING_TYPE",nullable=true,length=100)
	public String getBuildingType(){
		return this.buildingType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇类型
	 */
	public void setBuildingType(String buildingType){
		this.buildingType = buildingType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇属性
	 */
	@Column(name ="BUILDING_PROPERTY",nullable=true,length=100)
	public String getBuildingProperty(){
		return this.buildingProperty;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇属性
	 */
	public void setBuildingProperty(String buildingProperty){
		this.buildingProperty = buildingProperty;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇描述
	 */
	@Column(name ="DESCRIPTION",nullable=true,length=5000)
	public String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇描述
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇备注
	 */
	@Column(name ="NOTE",nullable=true,length=1000)
	public String getNote(){
		return this.note;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇备注
	 */
	public void setNote(String note){
		this.note = note;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=100)
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	@Column(name ="CREATE_BY",nullable=true,length=100)
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=100)
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
}
