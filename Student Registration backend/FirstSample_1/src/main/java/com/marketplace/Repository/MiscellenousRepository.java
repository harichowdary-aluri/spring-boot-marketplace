package com.marketplace.Repository;


import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Miscellenous;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiscellenousRepository extends JpaRepository<Miscellenous, Integer>{
	List<Miscellenous> findByStudentId(String studentId);
}
