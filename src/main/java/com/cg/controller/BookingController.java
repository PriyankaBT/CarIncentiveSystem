package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Booking;
import com.cg.payload.BookingReq;
//import com.cg.exception.ErrorMessages;
import com.cg.service.BookingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/book")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@PostMapping("/addbook")
	public ResponseEntity<Booking> addBooking(@RequestBody  BookingReq bookedReq) {
		Booking b1 = bookingService.addBooking(bookedReq.getDealerId(),bookedReq.getCarId(),bookedReq.getCustId(),bookedReq.getDealerIncAmt());
		return new ResponseEntity<>(b1, HttpStatus.OK);
	}

	@GetMapping("/getallbooking")
	public ResponseEntity<List<Booking>> getAllBooking() {
		List<Booking> list = bookingService.getAllBooking();
		return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
	}

	// getby booking is working but dealer id not working

	@GetMapping("/getbyid/{bookId}")
	public ResponseEntity<Object> getBookingByDealerId(@PathVariable("bookId") Integer dealerId) {
		Booking a = bookingService.getBookingByDealerId(dealerId);
		if (a == null) {
			return new ResponseEntity<>("Sorry Dealer id not found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(a, HttpStatus.OK);

	}

	@PutMapping("/editstatus/{bookId}/{status}")
	public ResponseEntity<String> changeBookingStatus(@PathVariable Integer bookId,@PathVariable String status) {
		 bookingService.changeBookingStatus(status,bookId);
		return new ResponseEntity<>("Status Updated !", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<?> deleteBookingId(@PathVariable("bookId") Integer bookId) {

		ResponseEntity<Object> responseEntity = null;
		bookingService.deleteBookingId(bookId);
		responseEntity = new ResponseEntity<>("Booking data deleted successfully", HttpStatus.OK);
		return responseEntity;
	}
	
	
}
