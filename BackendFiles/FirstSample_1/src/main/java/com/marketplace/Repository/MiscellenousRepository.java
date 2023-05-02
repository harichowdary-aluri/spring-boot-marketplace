package com.marketplace.Repository;


import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Household;
import com.marketplace.Entity.Miscellenous;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MiscellenousRepository extends JpaRepository<Miscellenous, Integer>{
	List<Miscellenous> findByStudentId(String studentId);
	@Query("SELECT c FROM Miscellenous c WHERE c.status = ?1")
	List<Miscellenous> findOthersByStatus(String status);
	
}
