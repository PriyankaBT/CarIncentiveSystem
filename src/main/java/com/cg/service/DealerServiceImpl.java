package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Dealer;
import com.cg.exception.AuthenticationFailureException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.DealerRepository;
//import org.springframework.transaction.annotation.Transactional;
//import org.slf4j.Logger;
//import com.cg.exception.ContactNumberAlreadyExistExcepton;
//import com.cg.exception.DealerIdNotFoundException;
//import ch.qos.logback.classic.Logger;

@Service
public class DealerServiceImpl implements DealerService {

	@Autowired
	private DealerRepository dealerRepository;

	@Override
	public Dealer addDealer(Dealer dealer) {
		Dealer savedDealer = dealerRepository.save(dealer);
		return savedDealer;
	}

	@Override
	public Dealer getDealerById(Integer dealerId) {
		Optional<Dealer> optionalDealer = dealerRepository.findById(dealerId);
		if (optionalDealer.isEmpty())
			throw new ResourceNotFoundException("Dealer Not found with id : " + dealerId);
		Dealer dealer = optionalDealer.get();
		return dealer;
	}

	@Override
	public List<Dealer> getAllDealers() {
		List<Dealer> dealer = dealerRepository.findAll();
		return dealer;
	}

	@Override
	public Dealer updateDealer(Dealer dealer) {
		Dealer updateDealer = getDealerById(dealer.getDealerId());
		updateDealer = dealerRepository.save(dealer);
		return updateDealer;
	}

	@Override
	public void deleteDealerById(Integer dealerId) {
		Dealer dealer = getDealerById(dealerId);
		dealerRepository.delete(dealer);
	}

	@Override
	public Dealer dealerLogin(String dealerName, String password) {
		Dealer dealer = dealerRepository.doDealerLogin(dealerName, password);

		if (dealer == null) {
			throw new AuthenticationFailureException("Dealername or password is incorrect");
		}

		return dealer;
	}

//	Logger logger = org.slf4j.LoggerFactory.getLogger(DealerDImpl.class);
//
//	@Transactional
//	@Override
//	public DealerDetails addDealer(DealerDetails dealer) {
//		return dealerRepo.save(dealer);
//	}
//
//	@Override
//	public DealerDetails updateDealer(DealerDetails dealer) {
//		return dealerRepo.save(dealer);
//	}
//
//	@Override
//	public DealerDetails getDealerById(Integer dealerId) throws DealerIdNotFoundException {
//		Boolean d = dealerRepo.existsById(dealerId);
//		if (d == false) {
//			throw new DealerIdNotFoundException();
//		}
//		return dealerRepo.getById(dealerId);
//	}
//
//	@Override
//	public List<DealerDetails> getAllDealer() {
//
//		return dealerRepo.findAll();
//	}
//
//	@Override
//	public boolean deleteDealerById(Integer dealerId) {
//		dealerRepo.deleteById(dealerId);
//
//		DealerDetails d1 = dealerRepo.getById(dealerId);
//		if (d1 == null) {
//			return true;
//		}
//		return false;
//	}
//	@Override
//	public DealerDetails dealerDetailsLogin(String userName, String password) {
//
//		DealerDetails dealerDetails = dealerRepo.doDealerDetailsLogin(userName, password);
//
//		if (dealerDetails == null) {
//			throw new AuthenticationFailureException("Username or password is incorrect");
//		}
//
//		return dealerDetails;
//	}
}