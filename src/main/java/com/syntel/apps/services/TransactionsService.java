package com.syntel.apps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.apps.dao.TransactionsRepository;
import com.syntel.apps.models.Transactions;

@Service
public class TransactionsService {

	@Autowired
	TransactionsRepository txnRepo;
	
	public List<Transactions> findByMerchantid(String mrchntId){
		List<Transactions> txns = txnRepo.findByMerchantid(mrchntId);		
		return txns;
	}
}
