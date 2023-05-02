package com.marketplace.Repository;


import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Integer>{
	List<Clothing> findByStudentId(String studentId);

	@Query("SELECT c FROM Clothing c WHERE c.status = ?1")
	List<Clothing> findClothesByStatus(String status);
}
