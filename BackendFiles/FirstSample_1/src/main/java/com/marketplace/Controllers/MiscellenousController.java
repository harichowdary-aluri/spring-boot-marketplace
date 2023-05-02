package com.marketplace.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Miscellenous;
import com.marketplace.Helpers.serv.AWSS3Service;
import com.marketplace.Services.ClothingService;
import com.marketplace.Services.ElectronicsService;
import com.marketplace.Services.MiscellenousService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.amazonaws.services.clouddirectory.model.BatchWriteExceptionType.ResourceNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/miscellenous")
public class MiscellenousController {

    @Autowired
    private MiscellenousService service;

    @Autowired
    private AWSS3Service s3service;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/miscellenous")
    public List<Miscellenous> getAllMiscellenous(){
        //return service.getAllMiscellenous();
    	return service.getAllOthersByStatus("Available");
    }

	/*
	 * @GetMapping("/sub/{subCat}") public List<Miscellenous>
	 * getBySubCategories(@PathVariable String subCat){ return
	 * service.getAllMiscellenousBySub(subCat); }
	 */

    @GetMapping("/product/{productId}")
    public Miscellenous getByMiscellenousID(@PathVariable int productId){
        return service.getMiscellenousByID(productId);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Miscellenous> createMiscellenous(@RequestParam(required=true, value="miscellenous") String jsondata, @RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
        String images = s3service.getImageLinks(files);
        System.out.println("jsondata" + jsondata);
        Miscellenous userData = objectMapper.readValue(jsondata, Miscellenous.class);
        System.out.println("extracted data add product electronics");
        userData.setImages(images);
        return service.saveProduct(userData);
    }

    @PutMapping("/updateMisc")
    public Miscellenous updateMiscellenous(@RequestBody Miscellenous updatedMisc){
    	updatedMisc.setImages(service.getMiscellenousByID(updatedMisc.getId()).getImages());
        return service.saveAndUpdateProduct(updatedMisc);
    }

    @RequestMapping(value = "/updateProductImages/{id}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Miscellenous updateMiscellenousImages(@PathVariable int id,@RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
    	Miscellenous misc = service.getMiscellenousByID(id);
    	misc.setImages(s3service.getImageLinks(files));
    	//misc.setImages(misc.getImages()+s3service.getImageLinks(files));
        return service.saveAndUpdateProduct(misc);
    }

    @DeleteMapping("/deleteImages/{productId}")
    public Miscellenous deleteProductImages(@PathVariable("productId") int productId,@RequestParam("filename") String filename){
    	Miscellenous misc = service.getMiscellenousByID(productId);
//        System.out.println(filename);
//        System.out.println("----------------------------");
        String images = misc.getImages();
//        System.out.println("----------------------------");
//        System.out.println(images);
        try {
            s3service.deleteFile(filename.substring(filename.lastIndexOf("/") + 1));
            String newImages = images.replace(filename+" ", "");
//            System.out.println(filename.substring(filename.lastIndexOf("/") + 1));
//            System.out.println("----------------------------------");
            misc.setImages(newImages);
            return service.saveAndUpdateProduct(misc);
        }
        catch (Exception e){
            return null;
        }

    }

    @DeleteMapping("/delete/{productId}")
    public List<Miscellenous> deleteProduct(@PathVariable int productId){
        String[] images = service.getMiscellenousByID(productId).getImages().split(" ");
        for(String s:images){
            if(s.length()>1){
                s3service.deleteFile(s);
            }
        }
        return service.deleteProduct(productId);
    }
}



