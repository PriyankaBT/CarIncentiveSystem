
package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Incentive_Details")
public class Incentive {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int incId; // one to one mapping
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookId", referencedColumnName = "bookId")
	private Booking bookingObj;
	private Long dealerInc;
	private String status;

	public Incentive() {
	}

	public Incentive(int incId, Booking bookingObj, Long dealerInc, String status) {
		super();
		this.incId = incId;
		this.bookingObj = bookingObj;
		this.dealerInc = dealerInc;
		this.status = status;
	}

	public int getIncId() {
		return incId;
	}

	public void setIncId(int incId) {
		this.incId = incId;
	}

	public Booking getBookingObj() {
		return bookingObj;
	}

	public void setBookingObj(Booking bookingObj) {
		this.bookingObj = bookingObj;
	}

	public Long getDealerInc() {
		return dealerInc;
	}

	public void setDealerInc(Long dealerInc) {
		this.dealerInc = dealerInc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Incentive [incId=" + incId + ", bookingObj=" + bookingObj + ", dealerInc=" + dealerInc + ", status="
				+ status + "]";
	}

}
