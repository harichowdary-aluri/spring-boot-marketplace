package com.marketplace.Controllers;

import com.marketplace.Helpers.serv.AWSS3Service;
import com.marketplace.Services.ClothingService;
import com.marketplace.Services.ElectronicsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private AWSS3Service s3Service;

    @Autowired
    private ClothingService clothingService;
    
    @Autowired
    private ElectronicsService electronicService;

//    @Autowired
//    private anotherService anotherService;

    @DeleteMapping("/delete/{filename}")
    public ResponseEntity<String> deleteFile(@PathVariable String filename){
        return new ResponseEntity<>(s3Service.deleteFile(filename), HttpStatus.OK);
    }

    @GetMapping("/myuploads/{studentId}")
    public List<Object> getMyUploads(@PathVariable String studentId){

        List<Object> uploads = new ArrayList<>();

        uploads.addAll(clothingService.getUserUploads(studentId));

        return uploads;

    }


}
