package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Booking_Details")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKING_SEQ")
	@SequenceGenerator(sequenceName = "bookId_seq", allocationSize = 1, name = "BOOKING_SEQ")
	private int bookId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dealerId")
	private Dealer dealer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custDetails", referencedColumnName = "custId")
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carDetails", referencedColumnName = "carId")
	private Car car;

	private LocalDate bookDate;

// @OneToOne(fetch = FetchType.EAGER, mappedBy = "booking_obj", cascade = CascadeType.ALL)
// private Incentive inc;

	private int dealerIncAmt;
	private String status;

	public Booking() {

	}

	public Booking(int bookId, Dealer dealer, Customer customer, Car car, LocalDate bookDate,
			int dealerIncAmt, String status) {
		super();
		this.bookId = bookId;
		this.dealer = dealer;
		this.customer = customer;
		this.car = car;
		this.bookDate = bookDate;
		this.dealerIncAmt = dealerIncAmt;
		this.status = status;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public LocalDate getBookDate() {
		return bookDate;
	}

	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}

	public int getDealerIncAmt() {
		return dealerIncAmt;
	}

	public void setDealerIncAmt(int dealerIncAmt) {
		this.dealerIncAmt = dealerIncAmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Booking [bookId=" + bookId + ", dealer=" + dealer + ", customer=" + customer + ", car=" + car
				+ ", bookDate=" + bookDate + ", dealerIncAmt=" + dealerIncAmt + ", status=" + status + "]";
	}
	

}
