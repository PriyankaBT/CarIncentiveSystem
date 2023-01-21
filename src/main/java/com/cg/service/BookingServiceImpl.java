package com.cg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Booking;
import com.cg.entity.Car;
import com.cg.entity.Customer;
import com.cg.entity.Dealer;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.BookingRepo;
import com.cg.repository.CarRepository;
import com.cg.repository.CustomerRepository;
import com.cg.repository.DealerRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepo bookingRepo;
    
	@Autowired
	private DealerRepository dealerRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CarRepository carRepository;
	
	
	@Override
	public Booking addBooking(int dealerId,int carId,int custId,int dealerIncAmt) {
		Optional<Dealer> optionaldealer =dealerRepository.findById(dealerId);
		Optional<Car> optionalcar =carRepository.findById(carId);
		Optional<Customer> optionalcustomer =customerRepository.findById(custId);
		if(optionaldealer.isEmpty()) {
			throw new ResourceNotFoundException("Dealer not existing with Id: " +dealerId);
		}
		if(optionalcar.isEmpty()) {
			throw new ResourceNotFoundException("Car not existing with Id: " +carId);
		}
		if(optionalcustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer not existing with Id: " +custId);
		}
		Dealer dealer =optionaldealer.get();
		Car car =optionalcar.get();
		Customer customer =optionalcustomer.get();
		Booking booking =new Booking();
		booking.setDealer(dealer);
		booking.setCar(car);
		booking.setCustomer(customer);
		booking.setBookDate(LocalDate.now());
		booking.setDealerIncAmt(dealerIncAmt);
		booking.setStatus("Pending");
		return bookingRepo.save(booking);
	}

	@Override
	public List<Booking> getAllBooking() {
		return bookingRepo.findAll();
	}

	@Override
	public Booking getBookingByDealerId(Integer dealerId) {
		return bookingRepo.getById(dealerId);
	}
     @Transactional
	@Override
	public Booking editBooking(Booking booked) {
		return bookingRepo.save(booked);
	}
     
     @Override
 	public void deleteBookingId(Integer bookId) {
 		Booking  booking = getBookingByDealerId(bookId);
 		bookingRepo.delete(booking);
 	}

	@Override
	public void changeBookingStatus(String status, Integer bookId) {
		// TODO Auto-generated method stub
		 bookingRepo.changeBookingStatus(status, bookId);
	}
     
     

}