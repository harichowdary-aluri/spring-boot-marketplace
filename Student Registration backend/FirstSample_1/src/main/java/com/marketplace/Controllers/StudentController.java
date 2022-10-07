package com.marketplace.Controllers;
import com.marketplace.*;
import com.marketplace.Entity.Student;
import com.marketplace.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {
	@Autowired 
	       StudentService studentservice;
	

	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:8080")
	public String registerUser(@RequestBody Student newStudent)
	{
		System.out.println("Student object is "+ newStudent);
	   studentservice.save(newStudent); 
		return "Student Registered";
	}
	
	@RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
	
}
