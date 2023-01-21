package com.cg.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Booking;

@Transactional
@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

	@Modifying
	@Query("update Booking b set b.status = :bstatus where b.bookId = :bId")
	void changeBookingStatus(@Param("bstatus") String status,@Param("bId") Integer bId);
}
