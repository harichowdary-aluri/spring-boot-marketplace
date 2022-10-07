package com.marketplace.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marketplace.*;
import com.marketplace.Entity.Student;
import com.marketplace.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired 
	       StudentRepository studentRepository;

	public Student save(Student s)
	{
		return studentRepository.save(s);
	
	}
}






