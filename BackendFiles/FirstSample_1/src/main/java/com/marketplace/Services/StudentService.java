package com.marketplace.Services;
import java.util.Base64;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.Entity.Student;
import com.marketplace.Repository.ElectronicsRepository;
import com.marketplace.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired 
	StudentRepository studentRepository;
	@Autowired
	ElectronicsRepository electronicsRepo;

	@Autowired
	private PasswordResetService passwordResetService;
	
	public Student save(Student s)
	{
		return studentRepository.save(s);

	}

	public Student getStudentById(String id)
	{
		try {
			return studentRepository.findById(id).get();	
		}
		catch(Exception e)
		{
			return null;
		}

	}

	@Autowired
	private EmailService emailService;

	public void resetPassword(String email, String otp, String newPassword, String confirmPassword) throws Exception {
		Student user = studentRepository.findByEmail(email);

		// Check if the user exists and if the OTP matches
	

		// Check if the new password and confirm password match
		
		// Update the user's password and OTP in the database
		
		String encrypted_password = Base64.getEncoder().encodeToString(newPassword.getBytes());
		user.setPassword(encrypted_password);
		user.setOtp(null);
		studentRepository.save(user);

		// Send a confirmation email to the user
		emailService.sendPasswordResetConfirmation(user.getEmail());
		System.out.println("inside reset end");
	}

	
	public void sendResetOtp(String email) throws Exception {
		System.out.println("The email given is "+ email);

		Student user = studentRepository.findByEmail(email);
		
		System.out.println("The registered email id is "+ user.getEmail());

		// Check if the user exists and if the OTP matches
		if (user == null ) {
			throw new Exception("Invalid user");
		}
		// Generate a new OTP
		String otp = generateOtp();

		// Update the user's record in the database with the new OTP
		user.setOtp(otp);
		studentRepository.save(user);

		// Send the OTP to the user via email
		passwordResetService.sendPasswordResetOtp(email, otp);
	}

	private String generateOtp() {
		// Generate a random 6-digit OTP
		return String.format("%06d", new Random().nextInt(999999));
	}

}






