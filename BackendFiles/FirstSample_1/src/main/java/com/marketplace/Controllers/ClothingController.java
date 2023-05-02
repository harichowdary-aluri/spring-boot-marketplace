package com.marketplace.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Helpers.serv.AWSS3Service;
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
@RequestMapping("/clothing")
public class ClothingController {

    @Autowired
    private ClothingService service;

    @Autowired
    private AWSS3Service s3service;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/clothes")
    public List<Clothing> getAllClothes(){
        //return service.getAllClothes();
    	return service.getAllClothesByStatus("Available");
    }
    
    public List<Clothing> getAllClothesByStatus(@RequestParam("status") String status){
        return service.getAllClothesByStatus(status);
    }

    @GetMapping("/sub/{subCat}")
    public List<Clothing> getBySubCategories(@PathVariable String subCat){
        return service.getAllClothesBySub(subCat);
    }

    @GetMapping("/product/{productId}")
    public Clothing getByClothID(@PathVariable int productId){
        return service.getClothByID(productId);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Clothing> createClothing(@RequestParam(required=true, value="clothing") String jsondata, @RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
        String images = s3service.getImageLinks(files);
        Clothing userData = objectMapper.readValue(jsondata, Clothing.class);
        userData.setImages(images);
        return service.saveProduct(userData);
    }

    @PutMapping("/updateCloth")
    public Clothing updateClothing(@RequestBody Clothing updatedCloth){
        updatedCloth.setImages(service.getClothByID(updatedCloth.getId()).getImages());
        return service.saveAndUpdateProduct(updatedCloth);
    }

    @RequestMapping(value = "/updateProductImages/{id}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Clothing updateClothingImages(@PathVariable int id,@RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
        Clothing cloth = service.getClothByID(id);
        cloth.setImages(s3service.getImageLinks(files));
        //cloth.setImages(cloth.getImages()+s3service.getImageLinks(files));
        return service.saveAndUpdateProduct(cloth);
    }

    @DeleteMapping("/deleteImages/{productId}")
    public Clothing deleteProductImages(@PathVariable("productId") int productId,@RequestParam("filename") String filename){
        Clothing cloth = service.getClothByID(productId);
//        System.out.println(filename);
//        System.out.println("----------------------------");
        String images = cloth.getImages();
//        System.out.println("----------------------------");
//        System.out.println(images);
        try {
            s3service.deleteFile(filename.substring(filename.lastIndexOf("/") + 1));
            String newImages = images.replace(filename+" ", "");
//            System.out.println(filename.substring(filename.lastIndexOf("/") + 1));
//            System.out.println("----------------------------------");
            cloth.setImages(newImages);
            return service.saveAndUpdateProduct(cloth);
        }
        catch (Exception e){
            return null;
        }

    }

    @DeleteMapping("/delete/{productId}")
    public List<Clothing> deleteProduct(@PathVariable int productId){
        String[] images = service.getClothByID(productId).getImages().split(" ");
        for(String s:images){
            if(s.length()>1){
                s3service.deleteFile(s);
            }
        }
        return service.deleteProduct(productId);
    }
    
    
}



