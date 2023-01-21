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
import com.cg.entity.Dealer;
import com.cg.payload.LoginReq1;
import com.cg.service.DealerService;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/dealer")
public class DealerController {
	@Autowired
	public DealerService dealerService;


	@GetMapping("/all")
	public ResponseEntity<List<Dealer>> getAllDealers() {
	List<Dealer> l1 = dealerService.getAllDealers();
	return new ResponseEntity<List<Dealer>>(l1, HttpStatus.OK);
	}

	@GetMapping("/get/{dealerId}")
	public ResponseEntity<Object> getDealerById(@PathVariable("dealerId") Integer dealerId1)
			 {
		Dealer d1 = dealerService.getDealerById(dealerId1);
		if (d1 == null) {
			return new ResponseEntity<>("Sorry Dealer id not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(d1, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Dealer> addDealer(@RequestBody Dealer d) {
		Dealer d1 = dealerService.addDealer(d);
		return new ResponseEntity<>(d1, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Dealer> updateDealer(@RequestBody Dealer d) {
		Dealer d1 = dealerService.updateDealer(d);
		return new ResponseEntity<>(d1, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{dealerId}")
	public ResponseEntity<?> deleteDealerById(@PathVariable("dealerId") int dealerId1) {

		ResponseEntity<Object> responseEntity = null;
		dealerService.deleteDealerById(dealerId1);
		responseEntity = new ResponseEntity<>("dealer data deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	
	@PostMapping("/login")
	public ResponseEntity<Dealer> doLogin(@RequestBody LoginReq1 loginReq1) {

		Dealer dealer = dealerService.dealerLogin(loginReq1.getDealerName(), loginReq1.getPassword());

		ResponseEntity<Dealer> responseEntity = new ResponseEntity<>(dealer, HttpStatus.OK);

		return responseEntity;
	}
}
	


//	@GetMapping("/all")
//public List<Dealer> getAllDealers() {
//	return dealerService.getAllDealers();
//}

//	@GetMapping("/get/{id}")
//	public ResponseEntity<?> getDealerById(@PathVariable("id") int dealerId) {
//
//		ResponseEntity<Object> responseEntity = null;
//		Dealer dealer = dealerService.getDealerById(dealerId);
//		responseEntity = new ResponseEntity<>(dealer, HttpStatus.OK);
//		return responseEntity;
//	}
//
//	@PostMapping("/save")
//	public ResponseEntity<Dealer> saveDealer(@RequestBody Dealer dealer) {
//
//		ResponseEntity<Dealer> responseEntity = null;
//		Dealer saveDealer = dealerService.saveDealer(dealer);
//		responseEntity = new ResponseEntity<>(saveDealer, HttpStatus.CREATED);
//		return responseEntity;
//	}
//
//	@PutMapping("/update")
//	public ResponseEntity<?> updateDealer(@RequestBody Dealer dealer) {
//
//		ResponseEntity<Object> responseEntity = null;
//		Dealer updateDealer = dealerService.updateDealer(dealer);
//		responseEntity = new ResponseEntity<>(updateDealer, HttpStatus.OK);
//		return responseEntity;
//	}
//
//@DeleteMapping("/deletedealer/{dealerId}")
//public ResponseEntity<String> deleteDealerById(@PathVariable("dealerId") Integer dealerId)
//		throws DealerIdNotFoundException {
//	Boolean d1 = dealerService.deleteDealerById(dealerId);
//	if (d1 == null) {
//		return new ResponseEntity("Sorry! Dealer id not available", HttpStatus.NOT_FOUND);
//	}
//	return new ResponseEntity<String>("Dealer deleted successfully", HttpStatus.OK);
//}
////
	
////@GetMapping(path = "/DealerLogin")
//	public String dealerLogin(@PathVariable("dealerId") int dealerId, @PathVariable("dealerPassword") String dealerPassword)
//			throws DealerIdNotFoundException {
//		String u1 = dealerService.dealerLogin(userName, dealerPassword);
//		if (u1 == null)
//			throw new DealerIdNotFoundException("Invalid dealerId and dealer Password");
//		else
//			return u1;
//
//	}
//}
//	
