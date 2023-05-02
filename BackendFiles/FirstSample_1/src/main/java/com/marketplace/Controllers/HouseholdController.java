package com.marketplace.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Household;
import com.marketplace.Helpers.serv.AWSS3Service;
import com.marketplace.Services.ClothingService;
import com.marketplace.Services.ElectronicsService;
import com.marketplace.Services.HouseholdService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.amazonaws.services.clouddirectory.model.BatchWriteExceptionType.ResourceNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/household")
public class HouseholdController {

    @Autowired
    private HouseholdService service;

    @Autowired
    private AWSS3Service s3service;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/household")
    public List<Household> getAllHouseholds(){
        //return service.getAllHousehold();
    	return service.getAllHouseholdByStatus("Available");
    }

    @GetMapping("/sub/{subCat}")
    public List<Household> getBySubCategories(@PathVariable String subCat){
        return service.getAllHouseholdBySub(subCat);
    }

    @GetMapping("/product/{productId}")
    public Household getByHouseholdID(@PathVariable int productId){
        return service.getHouseholdByID(productId);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Household> createHousehold(@RequestParam(required=true, value="household") String jsondata, @RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
        String images = s3service.getImageLinks(files);
        System.out.println("jsondata" + jsondata);
        Household userData = objectMapper.readValue(jsondata, Household.class);
        System.out.println("extracted data add product electronics");
        userData.setImages(images);
        return service.saveProduct(userData);
    }

    @PutMapping("/updateHousehold")
    public Household updateHousehold(@RequestBody Household updatedHouse){
    	updatedHouse.setImages(service.getHouseholdByID(updatedHouse.getId()).getImages());
        return service.saveAndUpdateProduct(updatedHouse);
    }

    @RequestMapping(value = "/updateProductImages/{id}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Household updateHouseholdImages(@PathVariable int id,@RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
        Household house = service.getHouseholdByID(id);
        house.setImages(s3service.getImageLinks(files));
       // house.setImages(house.getImages()+s3service.getImageLinks(files));
        return service.saveAndUpdateProduct(house);
    }

    @DeleteMapping("/deleteImages/{productId}")
    public Household deleteProductImages(@PathVariable("productId") int productId,@RequestParam("filename") String filename){
        Household house = service.getHouseholdByID(productId);
//        System.out.println(filename);
//        System.out.println("----------------------------");
        String images = house.getImages();
//        System.out.println("----------------------------");
//        System.out.println(images);
        try {
            s3service.deleteFile(filename.substring(filename.lastIndexOf("/") + 1));
            String newImages = images.replace(filename+" ", "");
//            System.out.println(filename.substring(filename.lastIndexOf("/") + 1));
//            System.out.println("----------------------------------");
            house.setImages(newImages);
            return service.saveAndUpdateProduct(house);
        }
        catch (Exception e){
            return null;
        }

    }

    @DeleteMapping("/delete/{productId}")
    public List<Household> deleteProduct(@PathVariable int productId){
        String[] images = service.getHouseholdByID(productId).getImages().split(" ");
        for(String s:images){
            if(s.length()>1){
                s3service.deleteFile(s);
            }
        }
        return service.deleteProduct(productId);
    }
    
    public List<Household> getAllHouseholdByStatus(@RequestParam("status") String status){
        return service.getAllHouseholdByStatus(status);
    }
}



