
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
@Table(name = "Car_Details")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_SEQ")
	@SequenceGenerator(sequenceName = "carId_seq", allocationSize = 1, name = "CAR_SEQ")
	
	private int carId;
	private String carCompany;
	private String carModel;
	private Long carPrice;
	private String fuelType;
	@JsonIgnore
	@OneToOne(mappedBy = "car")
	private Booking booking;

	
	public Car(int carId, String carCompany, String carModel, Long carPrice, String fuelType) {
		super();
		this.carId = carId;
		this.carCompany = carCompany;
		this.carModel = carModel;
		this.carPrice = carPrice;
		this.fuelType = fuelType;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarCompany() {
		return carCompany;
	}

	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Long getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(Long carPrice) {
		this.carPrice = carPrice;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}