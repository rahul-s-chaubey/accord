package com.idbiintech.smartcontract.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CUSTOMER_DET_AUDIT")
public class CustomerDetailAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CUSTOMER_DTL_ID")
	private long customerdtlId;
	@Column(name="CUSTOMER_ID")
	private long customerId;
	@Column(name="BANK")
	private String bank;
	@Column(name="ACCOUNT_NO")
	private long accountNo;
	@Column(name="PAN_NO")
	private long panNo;
	@Column(name="SOL_ID")
	private long solId;
	public long getCustomerdtlId() {
		return customerdtlId;
	}
	public void setCustomerdtlId(long customerdtlId) {
		this.customerdtlId = customerdtlId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public long getPanNo() {
		return panNo;
	}
	public void setPanNo(long panNo) {
		this.panNo = panNo;
	}
	public long getSolId() {
		return solId;
	}
	public void setSolId(long solId) {
		this.solId = solId;
	}
	@Override
	public String toString() {
		return "CustomerDetailAudit [customerdtlId=" + customerdtlId + ", customerId=" + customerId + ", bank=" + bank
				+ ", accountNo=" + accountNo + ", panNo=" + panNo + ", solId=" + solId + ", getCustomerdtlId()="
				+ getCustomerdtlId() + ", getCustomerId()=" + getCustomerId() + ", getBank()=" + getBank()
				+ ", getAccountNo()=" + getAccountNo() + ", getPanNo()=" + getPanNo() + ", getSolId()=" + getSolId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
