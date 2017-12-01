package com.lte.task.vo;

public class ReportTableDataVO {
	public Integer totalCnt;
	public Long buildingFloorId;
	public Integer validCnt;
	public String floorName;
	public Double percent;
	public Integer getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(Integer totalCnt) {
		this.totalCnt = totalCnt;
	}
	public Long getBuildingFloorId() {
		return buildingFloorId;
	}
	public void setBuildingFloorId(Long buildingFloorId) {
		this.buildingFloorId = buildingFloorId;
	}
	public Integer getValidCnt() {
		return validCnt;
	}
	public void setValidCnt(Integer validCnt) {
		this.validCnt = validCnt;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	
	
}
