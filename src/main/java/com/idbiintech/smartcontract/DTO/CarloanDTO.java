package com.idbiintech.smartcontract.DTO;

import jakarta.validation.constraints.NotNull;

public class CarloanDTO {

	@NotNull(message = "carmake may not be null")
	private String carmake;
	@NotNull(message = "carmodel may not be null")
	private String carmodel;
	@NotNull(message = "carcolor may not be null")
	private String carcolor;
	@NotNull(message = "loanamt may not be null")
	private String loanamt;
	@NotNull(message = "borrowername may not be null")
	private String borrowername;
	@NotNull(message = "borroweremail may not be null")
	private String borroweremail;
	@NotNull(message = "lenderfirstname may not be null")
	private String lenderfirstname;
	@NotNull(message = "lendermiddlename may not be null")
	private String lendermiddlename;
	@NotNull(message = "lenderlastname may not be null")
	private String lenderlastname;
	@NotNull(message = "lenderemail may not be null")
	private String lenderemail;
	@NotNull(message = "phone may not be null")
	private String phone;
	@NotNull(message = "address may not be null")
	private String address;
	@NotNull(message = "state may not be null")
	private String state;
	@NotNull(message = "city may not be null")
	private String city;
	@NotNull(message = "pincode may not be null")
	private String pincode;
	@NotNull(message = "bankname may not be null")
	private String bankname;
	@NotNull(message = "accountno may not be null")
	private String accountno;
	@NotNull(message = "loancategory may not be null")
	private String loancategory;
	@NotNull(message = "loanamount may not be null")
	private String loanamount;
	@NotNull(message = "loaninterest may not be null")
	private String loaninterest;
	@NotNull(message = "loanduration may not be null")
	private String loanduration;
	@NotNull(message = "loanpurpose may not be null")
	private String loanpurpose;
	@NotNull(message = "loanproposaldate may not be null")
	private String loanproposaldate;

	public String getCarmake() {
		return carmake;
	}

	public void setCarmake(String carmake) {
		this.carmake = carmake;
	}

	public String getCarmodel() {
		return carmodel;
	}

	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}

	public String getCarcolor() {
		return carcolor;
	}

	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}

	public String getLoanamt() {
		return loanamt;
	}

	public void setLoanamt(String loanamt) {
		this.loanamt = loanamt;
	}

	public String getBorrowername() {
		return borrowername;
	}

	public void setBorrowername(String borrowername) {
		this.borrowername = borrowername;
	}

	public String getBorroweremail() {
		return borroweremail;
	}

	public void setBorroweremail(String borroweremail) {
		this.borroweremail = borroweremail;
	}

	public String getLenderfirstname() {
		return lenderfirstname;
	}

	public void setLenderfirstname(String lenderfirstname) {
		this.lenderfirstname = lenderfirstname;
	}

	public String getLendermiddlename() {
		return lendermiddlename;
	}

	public void setLendermiddlename(String lendermiddlename) {
		this.lendermiddlename = lendermiddlename;
	}

	public String getLenderlastname() {
		return lenderlastname;
	}

	public void setLenderlastname(String lenderlastname) {
		this.lenderlastname = lenderlastname;
	}

	public String getLenderemail() {
		return lenderemail;
	}

	public void setLenderemail(String lenderemail) {
		this.lenderemail = lenderemail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getLoancategory() {
		return loancategory;
	}

	public void setLoancategory(String loancategory) {
		this.loancategory = loancategory;
	}

	public String getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(String loanamount) {
		this.loanamount = loanamount;
	}

	public String getLoaninterest() {
		return loaninterest;
	}

	public void setLoaninterest(String loaninterest) {
		this.loaninterest = loaninterest;
	}

	public String getLoanduration() {
		return loanduration;
	}

	public void setLoanduration(String loanduration) {
		this.loanduration = loanduration;
	}

	public String getLoanpurpose() {
		return loanpurpose;
	}

	public void setLoanpurpose(String loanpurpose) {
		this.loanpurpose = loanpurpose;
	}

	public String getLoanproposaldate() {
		return loanproposaldate;
	}

	public void setLoanproposaldate(String loanproposaldate) {
		this.loanproposaldate = loanproposaldate;
	}

}
