package com.marketplace.Repository;

import com.marketplace.Entity.Household;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, Integer>{
	List<Household> findByStudentId(String studentId);
	
	@Query("SELECT c FROM Household c WHERE c.status = ?1")
	List<Household> findHouseholdByStatus(String status);
}
