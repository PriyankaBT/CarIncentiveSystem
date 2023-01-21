package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.CarAdmin;

public interface CarAdminRepo extends JpaRepository<CarAdmin,Integer>{
	
	@Query("Select c from CarAdmin c where c.userName = :uname and c.password = :upwd")
	public CarAdmin doCarAdminLogin(@Param("uname") String userName, @Param("upwd") String password);

}