package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Customer_Details")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "custId_seq", allocationSize = 1, name = "CUST_SEQ")
	
	private int custId;
	private String custName;
	private Long custContactNo;
	private String custAddress;
	@JsonIgnore
	@OneToOne(mappedBy="customer")
	private Booking booking;
	
	
	public Customer(int custId, String custName, Long custContactNo, String custAddress) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custContactNo = custContactNo;
		this.custAddress = custAddress;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Long getCustContactNo() {
		return custContactNo;
	}
	public void setCustContactNo(Long custContactNo) {
		this.custContactNo = custContactNo;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	

}
