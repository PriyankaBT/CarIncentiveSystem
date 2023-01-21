package com.cg.payload;

public class BookingReq {
	
	private int dealerId;
	private int carId;
	private int custId;
	private int dealerIncAmt;
	public int getDealerId() {
		return dealerId;
	}
	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getDealerIncAmt() {
		return dealerIncAmt;
	}
	public void setDealerIncAmt(int dealerIncAmt) {
		this.dealerIncAmt = dealerIncAmt;
	}
	

}
