package com.marketplace.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetService {
	 @Autowired
	  private EmailService emailService;

	  public void sendPasswordResetOtp(String to, String otp) {
	    // Call the sendPasswordResetOtp method in the emailService
	    emailService.sendPasswordResetOtp(to, otp);
	  }


}
