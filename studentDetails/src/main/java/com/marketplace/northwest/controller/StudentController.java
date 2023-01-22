/**
 * @Author: Your name
 * @Date:   2022-09-30 09:36:13
 * @Last Modified by:   Your name
 * @Last Modified time: 2023-01-22 13:36:34
 */
package com.marketplace.northwest.controller;

import org.apache.catalina.connector.Response;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
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
    public String registerUser(@RequestBody Student newStudent) {
        System.out.println("Student object is " + newStudent);
        studentservice.save(newStudent);
        return "Student Registered";
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @PostMapping("/Electronics")
    public String saveProduct(@RequestParam("file") MultipartFile file,
            @RequestParam("sid") String sID,
            @RequestParam("subCategory") String subCategory,
            @RequestParam("modelName") String modelName,
            @RequestParam("brandName") String brandName,
            @RequestParam("dimensions") String dimensions,
            @RequestParam("modelName") String daysUsed,
            @RequestParam("description") String description,
            @RequestParam("qtyAvailable") String qtyAvailable,
            @RequestParam("price") String price)

    {
        studentservice.saveElectronicsToDB(file, sID, subCategory, modelName, brandName,
                dimensions, daysUsed, description, qtyAvailable, price);
        return "Product Saved to Database Successfully";
    }
}
