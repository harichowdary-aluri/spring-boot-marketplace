package com.marketplace.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marketplace.Entity.Clothing;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Integer>{

	List<Clothing> findByStudentId(String studentId);
	
	//@Query("SELECT c FROM Clothing c WHERE c.status = ?1")
	
	//@Query("SELECT c, s.phoneNumber FROM Clothing c JOIN Student s ON c.studentId = s.sID WHERE c.status=?1")
	@Query("SELECT c FROM Clothing c WHERE c.status = ?1")
	List<Clothing> findClothesByStatus(String status);
	

}
