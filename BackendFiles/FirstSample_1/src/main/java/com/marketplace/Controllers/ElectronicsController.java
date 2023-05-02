package com.marketplace.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Helpers.serv.AWSS3Service;
import com.marketplace.Services.ClothingService;
import com.marketplace.Services.ElectronicsService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import static com.amazonaws.services.clouddirectory.model.BatchWriteExceptionType.ResourceNotFoundException;

//@CrossOrigin("*")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/electronics")
public class ElectronicsController {

    @Autowired
    private ElectronicsService service;

    @Autowired
    private AWSS3Service s3service;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/electronics")
    public List<Electronics> getAllElectronics(){
        //return service.getAllElectronics();
    	return service.getAllElectronicsByStatus("Available");
    }
    
    @GetMapping("/sub/{subCat}")
    public List<Electronics> getBySubCategories(@PathVariable String subCat){
        return service.getAllElectronicsBySub(subCat);
    }

    @GetMapping("/product/{productId}")
    public Electronics getByElectronicID(@PathVariable int productId){
        return service.getElectronicByID(productId);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Electronics> createElectronics(@RequestParam(required=true, value="electronics") String jsondata, @RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
    	
        String images = s3service.getImageLinks(files);
        System.out.println("jsondata" + jsondata);
        Electronics userData = objectMapper.readValue(jsondata, Electronics.class);
        System.out.println("extracted data add product electronics");
        userData.setImages(images);
        return service.saveProduct(userData);
    }

    @PutMapping("/updateElec")
    public Electronics updateElectronics(@RequestBody Electronics updatedElec){
    	updatedElec.setImages(service.getElectronicByID(updatedElec.getId()).getImages());
        return service.saveAndUpdateProduct(updatedElec);
    }

    @RequestMapping(value = "/updateProductImages/{id}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Electronics updateElectronicImages(@PathVariable int id,@RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
        Electronics elec = service.getElectronicByID(id);
        System.out.println("Inside the images update");
        elec.setImages(s3service.getImageLinks(files));
        //elec.setImages(elec.getImages()+s3service.getImageLinks(files));
        return service.saveAndUpdateProduct(elec);
    }

    @DeleteMapping("/deleteImages/{productId}")
    public Electronics deleteProductImages(@PathVariable("productId") int productId,@RequestParam("filename") String filename){
        Electronics elec = service.getElectronicByID(productId);
//        System.out.println(filename);
//        System.out.println("----------------------------");
        String images = elec.getImages();
//        System.out.println("----------------------------");
//        System.out.println(images);
        try {
            s3service.deleteFile(filename.substring(filename.lastIndexOf("/") + 1));
            String newImages = images.replace(filename+" ", "");
//            System.out.println(filename.substring(filename.lastIndexOf("/") + 1));
//            System.out.println("----------------------------------");
            elec.setImages(newImages);
            return service.saveAndUpdateProduct(elec);
        }
        catch (Exception e){
            return null;
        }

    }

    @DeleteMapping("/delete/{productId}")
    public List<Electronics> deleteProduct(@PathVariable int productId){
        String[] images = service.getElectronicByID(productId).getImages().split(" ");
        for(String s:images){
            if(s.length()>1){
                s3service.deleteFile(s);
            }
        }
        return service.deleteProduct(productId);
    }
    
    
    public List<Electronics> getAllElectronicsByStatus(@RequestParam("status") String status){
        return service.getAllElectronicsByStatus(status);
    }
}



