package com.syntel.apps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.syntel.apps.models.Transactions;
import com.syntel.apps.services.TransactionsService;

@RestController
public class TransactionsController {

	@Autowired
	TransactionsService txnSvc;
	
	@GetMapping(value = "/transactions/list/{merchantId}")
	public List<Transactions> getTransactionsByMerchant(@PathVariable("merchantId") String merchantId){
		return txnSvc.findByMerchantid(merchantId);
	}
		
}
