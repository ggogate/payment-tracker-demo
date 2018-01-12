package com.syntel.apps.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.apps.dao.CasesRepository;
import com.syntel.apps.models.Cases;
import com.syntel.apps.models.Transactions;

@Service
public class CasesService {

	@Autowired
	CasesRepository casesRepo;
	
	/*public List<Cases> getAllCases(){
		List<Cases> cases = new ArrayList<Cases>();
		Iterator<Cases> iterator = casesRepo.findAll().iterator();
		while(iterator.hasNext()){
			cases.add(iterator.next());
		}
		return cases;
	}*/

	public List<Cases> findByMerchantid(String merchantId) {
		List<Cases> cases = casesRepo.findByMerchantid(merchantId);		
		return cases;
	}

	public void create(Cases newCase) {
		casesRepo.save(newCase);		
	}
	
}
