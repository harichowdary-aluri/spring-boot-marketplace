package com.marketplace.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.Services.AdsPageService;
import com.marketplace.dto.AdsPageItems;

@CrossOrigin("*")
@RestController
@RequestMapping("/ads")
public class AdsPageController {
	
	@Autowired
	private AdsPageService adsPageService;

    @GetMapping("/{studentId}")
    public AdsPageItems getAdsByStudentId(@PathVariable String studentId){
        return adsPageService.fetchAdsByStudentId(studentId);
    }
}
