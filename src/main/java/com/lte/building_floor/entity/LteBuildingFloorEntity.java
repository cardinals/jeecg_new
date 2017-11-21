package com.lte.building_floor.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Entity
 * @Description: lte_building_floor
 * @date 2017-11-21 09:40:58
 */
@Entity
@Table(name = "lte_building_floor", schema = "")
@SuppressWarnings("serial")
public class LteBuildingFloorEntity implements java.io.Serializable {
    /**
     * ID
     */
    private Integer id;
    /**
     * 楼宇ID
     */
    @Excel(name = "楼宇ID", width = 15, dictTable = "pomp_building", dicCode = "building_id", dicText = "id")
    private Integer buildingId;
    /**
     * 楼层名称
     */
    @Excel(name = "楼层名称", width = 15)
    private String floorName;
    /**
     * 楼层编号
     */
    @Excel(name = "楼层编号", width = 15)
    private String floorNo;
    /**
     * 楼层属性
     */
    @Excel(name = "楼层属性", width = 15)
    private String floorProperty;
    /**
     * 楼层描述
     */
    @Excel(name = "楼层描述", width = 15)
    private String description;
    /**
     * 楼宇备注
     */
    @Excel(name = "楼宇备注", width = 15)
    private String note;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建人登录名称
     */
    private String createBy;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 更新人名称
     */
    private String updateName;
    /**
     * 更新人登录名称
     */
    private String updateBy;
    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "ID", nullable = false, length = 10)
    public Integer getId() {
        return this.id;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  楼宇ID
     */

    @Column(name = "BUILDING_ID", nullable = false, length = 10)
    public Integer getBuildingId() {
        return this.buildingId;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  楼宇ID
     */
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  楼层名称
     */

    @Column(name = "FLOOR_NAME", nullable = true, length = 100)
    public String getFloorName() {
        return this.floorName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  楼层名称
     */
    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  楼层编号
     */

    @Column(name = "FLOOR_NO", nullable = true, length = 100)
    public String getFloorNo() {
        return this.floorNo;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  楼层编号
     */
    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  楼层属性
     */

    @Column(name = "FLOOR_PROPERTY", nullable = true, length = 100)
    public String getFloorProperty() {
        return this.floorProperty;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  楼层属性
     */
    public void setFloorProperty(String floorProperty) {
        this.floorProperty = floorProperty;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  楼层描述
     */

    @Column(name = "DESCRIPTION", nullable = true, length = 5000)
    public String getDescription() {
        return this.description;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  楼层描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  楼宇备注
     */

    @Column(name = "NOTE", nullable = true, length = 1000)
    public String getNote() {
        return this.note;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  楼宇备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人名称
     */

    @Column(name = "CREATE_NAME", nullable = true, length = 100)
    public String getCreateName() {
        return this.createName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  创建人名称
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人登录名称
     */

    @Column(name = "CREATE_BY", nullable = true, length = 100)
    public String getCreateBy() {
        return this.createBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  创建人登录名称
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  创建日期
     */

    @Column(name = "CREATE_DATE", nullable = true)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  更新人名称
     */

    @Column(name = "UPDATE_NAME", nullable = true, length = 100)
    public String getUpdateName() {
        return this.updateName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  更新人名称
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  更新人登录名称
     */

    @Column(name = "UPDATE_BY", nullable = true, length = 100)
    public String getUpdateBy() {
        return this.updateBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  更新人登录名称
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  更新日期
     */

    @Column(name = "UPDATE_DATE", nullable = true)
    public Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  更新日期
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
