package com.syntel.apps.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.syntel.apps.models.Transactions;

public interface TransactionsRepository extends CrudRepository<Transactions, String>{
	@Query(value="SELECT * FROM transactions T where T.merchantid = ?1", nativeQuery=true)
	List<Transactions> findByMerchantid(@Param("merchantid") String Merchantid);
}
