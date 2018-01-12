package com.syntel.apps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.syntel.apps.models.Cases;
import com.syntel.apps.services.CasesService;

@RestController
public class CasesController {
	
	@Autowired
	CasesService casesSvc;
	

	/*@GetMapping("/cases/list")
	public List<Cases> list(){
		return (List<Cases>)casesSvc.getAllCases();
	}*/
	
	@GetMapping(value = "/cases/list/{merchantId}")
	public List<Cases> getCasesByMerchant(@PathVariable("merchantId") String merchantId){
		return casesSvc.findByMerchantid(merchantId);
	}

	@RequestMapping(value = "/cases/create", 
			method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void  newCase(@RequestBody Cases newCase){
		casesSvc.create(newCase);
		System.out.println("created..");
	}
}
