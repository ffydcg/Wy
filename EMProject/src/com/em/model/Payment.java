package com.em.model;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	private String paymentOwnerNo;
	private String paymentOwnerName;
	private String paymentCategory;
	private BigDecimal paymentFee;
	private String  paymentContent;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaymentOwnerNo() {
		return paymentOwnerNo;
	}
	public void setPaymentOwnerNo(String paymentOwnerNo) {
		this.paymentOwnerNo = paymentOwnerNo;
	}
	public String getPaymentOwnerName() {
		return paymentOwnerName;
	}
	public void setPaymentOwnerName(String paymentOwnerName) {
		this.paymentOwnerName = paymentOwnerName;
	}
	public String getPaymentCategory() {
		return paymentCategory;
	}
	public void setPaymentCategory(String paymentCategory) {
		this.paymentCategory = paymentCategory;
	}
	public BigDecimal getPaymentFee() {
		return paymentFee;
	}
	public void setPaymentFee(BigDecimal paymentFee) {
		this.paymentFee = paymentFee;
	}
	public String getPaymentContent() {
		return paymentContent;
	}
	public void setPaymentContent(String paymentContent) {
		this.paymentContent = paymentContent;
	}
	
}
