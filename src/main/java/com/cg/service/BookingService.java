package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Booking;
@Service
public interface BookingService {

	public Booking addBooking(int dealerId,int carId,int custId,int dealerIncAmt);

	public List<Booking> getAllBooking();

	public Booking getBookingByDealerId(Integer dealerId);

	public Booking editBooking(Booking booked);
	
	public void deleteBookingId(Integer bookId);
	
	public void changeBookingStatus(String status,Integer bookId);

}