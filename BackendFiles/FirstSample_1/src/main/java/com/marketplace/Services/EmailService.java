package com.marketplace.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  @Autowired
  private JavaMailSender mailSender;

  public void sendPasswordResetOtp(String to, String otp) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject("Password Reset OTP");
    message.setText("Your password reset OTP is " + otp);
    mailSender.send(message);
  }

  public void sendPasswordResetConfirmation(String to) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject("Password Reset Confirmation");
    message.setText("Your password has been reset successfully.");
    mailSender.send(message);
  }
}
