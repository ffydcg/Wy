package com.em.model;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="repair")
public class Repair {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    private String repairOwnerNo;
    private String repairOwnerName;
    private String repairContent;
    private BigDecimal  repairFee;
    private String repairFeeStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRepairOwnerNo() {
		return repairOwnerNo;
	}
	public void setRepairOwnerNo(String repairOwnerNo) {
		this.repairOwnerNo = repairOwnerNo;
	}
	public String getRepairOwnerName() {
		return repairOwnerName;
	}
	public void setRepairOwnerName(String repairOwnerName) {
		this.repairOwnerName = repairOwnerName;
	}
	public String getRepairContent() {
		return repairContent;
	}
	public void setRepairContent(String repairContent) {
		this.repairContent = repairContent;
	}
	public BigDecimal getRepairFee() {
		return repairFee;
	}
	public void setRepairFee(BigDecimal repairFee) {
		this.repairFee = repairFee;
	}
	public String getRepairFeeStatus() {
		return repairFeeStatus;
	}
	public void setRepairFeeStatus(String repairFeeStatus) {
		this.repairFeeStatus = repairFeeStatus;
	}
    
    
}
