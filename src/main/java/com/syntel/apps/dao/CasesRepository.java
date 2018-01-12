package com.syntel.apps.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.syntel.apps.models.Cases;
import com.syntel.apps.models.Transactions;

public interface CasesRepository extends CrudRepository<Cases, String>{
	@Query(value="SELECT * FROM cases C where C.merchantid = ?1", nativeQuery=true)
	List<Cases> findByMerchantid(@Param("merchantid") String Merchantid);
}
