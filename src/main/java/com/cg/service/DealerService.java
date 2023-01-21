package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Dealer;

@Service
public interface DealerService {

	public Dealer addDealer(Dealer dealer);

	public Dealer updateDealer(Dealer dealer);

	public Dealer getDealerById(Integer dealerId);

	public List<Dealer> getAllDealers();

	public void deleteDealerById(Integer dealerId);
	
	public Dealer dealerLogin(String dealerName, String password);



}