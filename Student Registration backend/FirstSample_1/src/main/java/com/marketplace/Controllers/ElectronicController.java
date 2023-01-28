package com.marketplace.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.Entity.Electronics;

import com.marketplace.Helpers.serv.AWSS3Service;
import com.marketplace.Services.ElectronicService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.amazonaws.services.clouddirectory.model.BatchWriteExceptionType.ResourceNotFoundException;

@RestController
@RequestMapping("/electronics")
public class ElectronicController {

    @Autowired
    private ElectronicService service;

    @Autowired
    private AWSS3Service s3service;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/Electronics")
    public List<Electronics> getAllElectronics(){
        return service.getAllElectronics();
    }

    @GetMapping("/sub/{subCat}")
    public List<Electronics> getBySubCategories(@PathVariable String subCat){
        return service.getAllElectronicsBySub(subCat);
    }

    @GetMapping("/product/{productId}")
    public Electronics getByElectronicsID(@PathVariable int productId){
        return service.getElectronicsByID(productId);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Electronics> createElectronics(@RequestParam(required=true, value="Electronics") String jsondata, @RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
        String images = s3service.getImageLinks(files);
        Electronics userData = objectMapper.readValue(jsondata, Electronics.class);
        userData.setImages(images);
        return service.saveProduct(userData);
    }

    @PutMapping("/updateElectronics")
    public Electronics updateElectronics(@RequestBody Electronics updatedElectronics){
        updatedElectronics.setImages(service.getElectronicsByID(updatedElectronics.getId()).getImages());
        return service.saveAndUpdateProduct(updatedElectronics);
    }

    @RequestMapping(value = "/updateProductImages/{id}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Electronics updateElectronicsImages(@PathVariable int id,@RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
        Electronics auto = service.getElectronicsByID(id);
        auto.setImages(auto.getImages()+s3service.getImageLinks(files));
        return service.saveAndUpdateProduct(auto);
    }

    @DeleteMapping("/deleteImages/{productId}")
    public Electronics deleteProductImages(@PathVariable("productId") int productId,@RequestParam("filename") String filename){
        Electronics auto = service.getElectronicsByID(productId);
//        System.out.println(filename);
//        System.out.println("----------------------------");
        String images = auto.getImages();
//        System.out.println("----------------------------");
//        System.out.println(images);
        try {
            s3service.deleteFile(filename.substring(filename.lastIndexOf("/") + 1));
            String newImages = images.replace(filename+" ", "");
//            System.out.println(filename.substring(filename.lastIndexOf("/") + 1));
//            System.out.println("----------------------------------");
            auto.setImages(newImages);
            return service.saveAndUpdateProduct(auto);
        }
        catch (Exception e){
            return null;
        }

    }

    @DeleteMapping("/delete/{productId}")
    public List<Electronics> deleteProduct(@PathVariable int productId){
        String[] images = service.getElectronicsByID(productId).getImages().split(" ");
        for(String s:images){
            if(s.length()>1){
                s3service.deleteFile(s);
            }
        }
        return service.deleteProduct(productId);
    }
}



