package com.em.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="complainer")
public class Complainer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
	private String comOwnerName;
	private String comAccepter;
	private String comOwnerNo;
	private Date  comDate;
	private Date  handleDate;
	private String comContent;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComOwnerName() {
		return comOwnerName;
	}
	public void setComOwnerName(String comOwnerName) {
		this.comOwnerName = comOwnerName;
	}
	public String getComAccepter() {
		return comAccepter;
	}
	public void setComAccepter(String comAccepter) {
		this.comAccepter = comAccepter;
	}
	public String getComOwnerNo() {
		return comOwnerNo;
	}
	public void setComOwnerNo(String comOwnerNo) {
		this.comOwnerNo = comOwnerNo;
	}
	public Date getComDate() {
		return comDate;
	}
	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}
	public Date getHandleDate() {
		return handleDate;
	}
	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	
}
