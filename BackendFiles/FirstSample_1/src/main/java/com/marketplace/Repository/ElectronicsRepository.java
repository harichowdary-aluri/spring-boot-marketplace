package com.marketplace.Repository;


import com.marketplace.Entity.Electronics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicsRepository extends JpaRepository<Electronics, Integer>{
	List<Electronics> findByStudentId(String studentId);
	
	@Query("SELECT e FROM Electronics e WHERE e.status = ?1")
	List<Electronics> findElectronicsByStatus(String status);
}
