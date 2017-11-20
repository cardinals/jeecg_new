package com.lte.task.entity;

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
 * @Description: lte_scan_task
 * @date 2017-11-20 13:41:06
 */
@Entity
@Table(name = "lte_scan_task", schema = "")
@SuppressWarnings("serial")
public class LteScanTaskEntity implements java.io.Serializable {
    /**
     * ID
     */

    private Integer id;
    /**
     * 楼宇ID
     */
    @Excel(name = "楼宇ID", width = 15)

    private Integer buildingId;
    /**
     * 任务名称
     */
    @Excel(name = "任务名称", width = 15)

    private String taskName;
    /**
     * 任务编号
     */
    @Excel(name = "任务编号", width = 15)

    private String taskNo;
    /**
     * 任务状态
     */
    @Excel(name = "任务状态", width = 15)

    private Integer taskStatus;
    /**
     * 报告状态
     */
    @Excel(name = "报告状态", width = 15)

    private Integer reportStatus;
    /**
     * 任务备注
     */
    @Excel(name = "任务备注", width = 15)

    private String note;
    /**
     * 创建人名称
     */
    @Excel(name = "创建人名称", width = 15)

    private String createName;
    /**
     * 创建人登录名称
     */
    @Excel(name = "创建人登录名称", width = 15)

    private String createBy;
    /**
     * 创建日期
     */
    @Excel(name = "创建日期", width = 15, format = "yyyy-MM-dd")

    private Date createDate;
    /**
     * 更新人名称
     */
    @Excel(name = "更新人名称", width = 15)

    private String updateName;
    /**
     * 更新人登录名称
     */
    @Excel(name = "更新人登录名称", width = 15)

    private String updateBy;
    /**
     * 更新日期
     */
    @Excel(name = "更新日期", width = 15, format = "yyyy-MM-dd")

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
     * @return: java.lang.String  任务名称
     */
    @Column(name = "TASK_NAME", nullable = true, length = 100)
    public String getTaskName() {
        return this.taskName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  任务编号
     */
    @Column(name = "TASK_NO", nullable = true, length = 100)
    public String getTaskNo() {
        return this.taskNo;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  任务编号
     */
    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  任务状态
     */
    @Column(name = "TASK_STATUS", nullable = false, length = 10)
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  任务状态
     */
    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  报告状态
     */
    @Column(name = "REPORT_STATUS", nullable = false, length = 10)
    public Integer getReportStatus() {
        return this.reportStatus;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  报告状态
     */
    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  任务备注
     */
    @Column(name = "NOTE", nullable = true, length = 1000)
    public String getNote() {
        return this.note;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  任务备注
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
