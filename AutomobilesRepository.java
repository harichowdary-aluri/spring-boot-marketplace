package com.marketplace.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marketplace.Entity.Automobiles;
import com.marketplace.Entity.Clothing;

@Repository
public interface AutomobilesRepository extends JpaRepository<Automobiles, Integer> {
	List<Automobiles> findByStudentId(String studentId);
	@Query("SELECT c FROM Automobiles c WHERE c.status = ?1")
	List<Automobiles> findAutomobilesByStatus(String status);
}
