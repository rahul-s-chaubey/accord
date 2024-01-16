package com.idbiintech.smartcontract.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CUSTOMER_MASTER_AUDIT")
public class CustomerMasterAudit {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID")
	private long customerId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="MIDDLE_NAME")
	private String middleName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="STATE")
	private String state;
	@Column(name="CITY")
	private String city;
	@Column(name="PINCODE")
	private long pincode;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="GENDER")
	private String gender;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "CustomerMasterAudit [customerId=" + customerId + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", state=" + state + ", city=" + city + ", pincode=" + pincode
				+ ", address=" + address + ", gender=" + gender + ", getCustomerId()=" + getCustomerId()
				+ ", getFirstName()=" + getFirstName() + ", getMiddleName()=" + getMiddleName() + ", getLastName()="
				+ getLastName() + ", getState()=" + getState() + ", getCity()=" + getCity() + ", getPincode()="
				+ getPincode() + ", getAddress()=" + getAddress() + ", getGender()=" + getGender() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
