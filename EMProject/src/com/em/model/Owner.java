package com.em.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="owner")
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	private String ownerName;
	private String ownerTel;
	private String ownerHouseInfo;
	private Date  ownerCheckinDate;
	private String ownerHouseArea;
	private String ownerNo;
	private String ownerIdCard;
	private String ownerHouseType;
	private String ownerPeopleNum;
	public String getOwnerIdCard() {
		return ownerIdCard;
	}
	public void setOwnerIdCard(String ownerIdCard) {
		this.ownerIdCard = ownerIdCard;
	}
	public String getOwnerHouseType() {
		return ownerHouseType;
	}
	public void setOwnerHouseType(String ownerHouseType) {
		this.ownerHouseType = ownerHouseType;
	}
	public String getOwnerPeopleNum() {
		return ownerPeopleNum;
	}
	public void setOwnerPeopleNum(String ownerPeopleNum) {
		this.ownerPeopleNum = ownerPeopleNum;
	}
	public String getOwnerNo() {
		return ownerNo;
	}
	public void setOwnerNo(String ownerNo) {
		this.ownerNo = ownerNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerTel() {
		return ownerTel;
	}
	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}
	public String getOwnerHouseInfo() {
		return ownerHouseInfo;
	}
	public void setOwnerHouseInfo(String ownerHouseInfo) {
		this.ownerHouseInfo = ownerHouseInfo;
	}
	public Date getOwnerCheckinDate() {
		return ownerCheckinDate;
	}
	public void setOwnerCheckinDate(Date ownerCheckinDate) {
		this.ownerCheckinDate = ownerCheckinDate;
	}
	public String getOwnerHouseArea() {
		return ownerHouseArea;
	}
	public void setOwnerHouseArea(String ownerHouseArea) {
		this.ownerHouseArea = ownerHouseArea;
	}
	

}
