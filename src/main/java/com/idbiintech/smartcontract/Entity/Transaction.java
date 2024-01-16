package com.idbiintech.smartcontract.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="TRANSCATION")
public class  Transaction{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="TRANSCATION_ID")
	private long transcationId;
	@Column(name="LOAN_DET_ID")
	private long loandetId;
	
	
	public long getTranscationId() {
		return transcationId;
	}
	public void setTranscationId(long transcationId) {
		this.transcationId = transcationId;
	}
	public long getLoandetId() {
		return loandetId;
	}
	public void setLoandetId(long loandetId) {
		this.loandetId = loandetId;
	}
	@Override
	public String toString() {
		return "Transaction [transcationId=" + transcationId + ", loandetId=" + loandetId + ", getTranscationId()="
				+ getTranscationId() + ", getLoandetId()=" + getLoandetId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
}
