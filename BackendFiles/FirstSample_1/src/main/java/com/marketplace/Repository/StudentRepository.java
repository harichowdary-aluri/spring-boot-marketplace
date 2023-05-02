package com.marketplace.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.*;
import com.marketplace.Entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,String>
{
	Student findByEmail(String email);

}



