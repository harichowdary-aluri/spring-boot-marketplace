package com.marketplace.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.Services.StudentService;
import com.marketplace.dto.ResetPasswordRequest;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

  @Autowired
  private StudentService userService;

  @PostMapping("/reset")
  public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) throws Exception {
    // Call the user service to handle the password reset logic
    userService.resetPassword(request.getEmail(), request.getOtp(), request.getNewPassword(), request.getConfirmPassword());

    return ResponseEntity.ok().build();
  }
    
  @PostMapping("/sendResetOtp")
  public ResponseEntity<?> sendResetOtp(@RequestParam("email") String email) throws Exception {
    // Call the user service to handle the password reset logic
    userService.sendResetOtp(email);

    return ResponseEntity.ok().build();
  }
  
  
}

