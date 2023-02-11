package com.marketplace.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.Entity.Automobiles;
import com.marketplace.Entity.Clothing;
import com.marketplace.Helpers.serv.AWSS3Service;
import com.marketplace.Services.AutomobileService;
import com.marketplace.Services.ClothingService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.amazonaws.services.clouddirectory.model.BatchWriteExceptionType.ResourceNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/automobiles")
public class AutomobilesController {

    @Autowired
    private AutomobileService service;

    @Autowired
    private AWSS3Service s3service;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/automobiles")
    public List<Automobiles> getAllAutomobiles(){
        return service.getAllAutomobiles();
    }

    @GetMapping("/sub/{subCat}")
    public List<Automobiles> getBySubCategories(@PathVariable String subCat){
        return service.getAllAutomobilesBySub(subCat);
    }

    @GetMapping("/product/{productId}")
    public Automobiles getByAutomobileID(@PathVariable int productId){
        return service.getAutomobileByID(productId);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Automobiles> createAutomobile(@RequestParam(required=true, value="automobiles") String jsondata, @RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
        String images = s3service.getImageLinks(files);
        Automobiles userData = objectMapper.readValue(jsondata, Automobiles.class);
        userData.setImages(images);
        return service.saveProduct(userData);
    }

    @PutMapping("/updateAutomobile")
    public Automobiles updateAutomobile(@RequestBody Automobiles updatedAutomobile){
    	updatedAutomobile.setImages(service.getAutomobileByID(updatedAutomobile.getId()).getImages());
        return service.saveAndUpdateProduct(updatedAutomobile);
    }

    @RequestMapping(value = "/updateProductImages/{id}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Automobiles updateAutomobileImages(@PathVariable int id,@RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
    	Automobiles automobile = service.getAutomobileByID(id);
    	automobile.setImages(automobile.getImages()+s3service.getImageLinks(files));
        return service.saveAndUpdateProduct(automobile);
    }

    @DeleteMapping("/deleteImages/{productId}")
    public Automobiles deleteProductImages(@PathVariable("productId") int productId,@RequestParam("filename") String filename){
        Automobiles automobile = service.getAutomobileByID(productId);
//        System.out.println(filename);
//        System.out.println("----------------------------");
        String images = automobile.getImages();
//        System.out.println("----------------------------");
//        System.out.println(images);
        try {
            s3service.deleteFile(filename.substring(filename.lastIndexOf("/") + 1));
            String newImages = images.replace(filename+" ", "");
//            System.out.println(filename.substring(filename.lastIndexOf("/") + 1));
//            System.out.println("----------------------------------");
            automobile.setImages(newImages);
            return service.saveAndUpdateProduct(automobile);
        }
        catch (Exception e){
            return null;
        }

    }

    @DeleteMapping("/delete/{productId}")
    public List<Automobiles> deleteProduct(@PathVariable int productId){
        String[] images = service.getAutomobileByID(productId).getImages().split(" ");
        for(String s:images){
            if(s.length()>1){
                s3service.deleteFile(s);
            }
        }
        return service.deleteProduct(productId);
    }
}



