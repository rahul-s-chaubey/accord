package com.idbiintech.smartcontract.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="LOAN_MASTER")
public class LoanMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LOAN_MST_ID")
	private long loanmstId;
	@Column(name="LOAN_CATEGORY")
	private String loanCategory;
	@Column(name="ISACTIVE")
	private char isActive;
	@Column(name="LOAN_INTEREST")
	private long loanInterest;
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
	public char getIsActive() {
		return isActive;
	}
	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}
	public long getLoanInterest() {
		return loanInterest;
	}
	public void setLoanInterest(long loanInterest) {
		this.loanInterest = loanInterest;
	}
	@Override
	public String toString() {
		return "LoanMaster [loanmstId=" + loanmstId + ", loanCategory=" + loanCategory + ", isActive=" + isActive
				+ ", loanInterest=" + loanInterest + ", getLoanmstId()=" + getLoanmstId() + ", getLoanCategory()="
				+ getLoanCategory() + ", getIsActive()=" + getIsActive() + ", getLoanInterest()=" + getLoanInterest()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	
	
}
