package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Dealer;

@Repository

public interface DealerRepository extends JpaRepository<Dealer, Integer> {
	@Query("Select d from Dealer d where d.dealerName = :dname and d.password = :pwd")
	public Dealer doDealerLogin(@Param("dname") String dealerName, @Param("pwd") String password);

}