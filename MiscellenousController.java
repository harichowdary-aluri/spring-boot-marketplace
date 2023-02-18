/**
 * @Author: Your name
 * @Date:   2023-02-17 19:50:39
 * @Last Modified by:   Your name
 * @Last Modified time: 2023-02-17 20:09:59
 */
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
    public List<Miscellenous> getAllMiscellenous() {
        return service.getAllMiscellenous();
    }

    /*
     * @GetMapping("/sub/{subCat}") public List<Miscellenous>
     * getBySubCategories(@PathVariable String subCat){ return
     * service.getAllMiscellenousBySub(subCat); }
     */

    @GetMapping("/product/{productId}")
    public Miscellenous getByMiscellenousID(@PathVariable int productId) {
        return service.getMiscellenousByID(productId);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Miscellenous> createMiscellenous(@RequestParam(required = true, value = "miscellenous") String jsondata,
            @RequestParam("images") MultipartFile[] files) throws JsonProcessingException {
        String images = s3service.getImageLinks(files);
        System.out.println("jsondata" + jsondata);
        Miscellenous userData = objectMapper.readValue(jsondata, Miscellenous.class);
        System.out.println("extracted data add product electronics");
        userData.setImages(images);
        return service.saveProduct(userData);
    }

    @PutMapping("/updateMisc")
    public Miscellenous updateMiscellenous(@RequestBody Miscellenous updatedMisc) {
        updatedMisc.setImages(service.getMiscellenousByID(updatedMisc.getId()).getImages());
        return service.saveAndUpdateProduct(updatedMisc);
    }
}