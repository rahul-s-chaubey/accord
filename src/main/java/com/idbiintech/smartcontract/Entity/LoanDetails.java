package com.idbiintech.smartcontract.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="LOAN_DET")
public class LoanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LOAN_MST_ID")
	private long loanmstId;
	@Column(name="LOAN_CATEGORY")
	private String loanCategory;
	@Column(name="CUSTOMER_ID")
	private long customerId;
	@Column(name="LOAN_DET_ID")
	private long loandetId;
	@Column(name="LOAN_AMOUNT")
	private long loanAmount;
	@Column(name="LOAN_INTEREST")
	private long loanInterest;
	@Column(name="LOAN_DURATION")
	private long loanDuration;
	@Column(name="LOAN_PROPOSAL_DATE")
	private Date loanproposalDate;
	@Column(name="LOAN_PURPOSE")
	private String loanPurpose;
	@Column(name="LOAN_STATUS")
	private String loanStatus;
	@Column(name="SMARTCONTRACT_PATH")
	private String smartcontractPath;
	public long getLoanmstId() {
		return loanmstId;
	}
	public void setLoanmstId(long loanmstId) {
		this.loanmstId = loanmstId;
	}
	public String getLoanCategory() {
		return loanCategory;
	}
	public void setLoanCategory(String loanCategory) {
		this.loanCategory = loanCategory;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getLoandetId() {
		return loandetId;
	}
	public void setLoandetId(long loandetId) {
		this.loandetId = loandetId;
	}
	public long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}
	public long getLoanInterest() {
		return loanInterest;
	}
	public void setLoanInterest(long loanInterest) {
		this.loanInterest = loanInterest;
	}
	public long getLoanDuration() {
		return loanDuration;
	}
	public void setLoanDuration(long loanDuration) {
		this.loanDuration = loanDuration;
	}
	public Date getLoanproposalDate() {
		return loanproposalDate;
	}
	public void setLoanproposalDate(Date loanproposalDate) {
		this.loanproposalDate = loanproposalDate;
	}
	public String getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getSmartcontractPath() {
		return smartcontractPath;
	}
	public void setSmartcontractPath(String smartcontractPath) {
		this.smartcontractPath = smartcontractPath;
	}

	
	
	
	
	
}
