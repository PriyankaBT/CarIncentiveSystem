package com.cg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Dealer_Details")
public class Dealer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEALER_SEQ")
	@SequenceGenerator(sequenceName = "dealerId_seq", allocationSize = 1, name = "DEALER_SEQ")
	
	private int dealerId;
	private String dealerName;
	private Long dealerContact;
	private String dealerMailid;
	private String dealerAddress;
	private String password;
	@JsonIgnore
	@OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
	private List<Booking> bookings;

	public Dealer() {

	}

	public Dealer(int dealerId, String dealerName, Long dealerContact, String dealerMailid, String dealerAddress,
			String password) {
		super();
		this.dealerId = dealerId;
		this.dealerName = dealerName;
		this.dealerContact = dealerContact;
		this.dealerMailid = dealerMailid;
		this.dealerAddress = dealerAddress;
		this.password = password;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public Long getDealerContact() {
		return dealerContact;
	}

	public void setDealerContact(Long dealerContact) {
		this.dealerContact = dealerContact;
	}

	public String getDealerMailid() {
		return dealerMailid;
	}

	public void setDealerMailid(String dealerMailid) {
		this.dealerMailid = dealerMailid;
	}

	public String getDealerAddress() {
		return dealerAddress;
	}

	public void setDealerAddress(String dealerAddress) {
		this.dealerAddress = dealerAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "DealerDetails [dealerId=" + dealerId + ",dealerName=" + dealerName + ", dealerContact=" + dealerContact
				+ ", dealerMailid=" + dealerMailid + ", dealerAddress=" + dealerAddress + ", password="
				+ password + ", bookings=" + bookings + "]";
	}

}