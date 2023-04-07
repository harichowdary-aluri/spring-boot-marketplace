package com.marketplace.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Miscellenous;

@Repository
public interface MiscellenousRepository extends JpaRepository<Miscellenous, Integer>{

	List<Miscellenous> findByStudentId(String studentId);
	@Query("SELECT c FROM Miscellenous c WHERE c.status = ?1")
	List<Miscellenous> findMiscellenousByStatus(String status);

}
