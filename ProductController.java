package com.productregistration.Controller;

import com.productregistration.Entity.*;
import com.productregistration.Repository.ClothingRepository;
import com.productregistration.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
public class ProductController {

    @Autowired
    private ProductService productservice;
    @GetMapping
     public String display()
     {

         return "Hello World!";
     }
    public String display3()
    {

        return "Hello World!";
    }
    @GetMapping("/display")
    public String display1()
    {
        return " This is the sample display";

    }

    @PostMapping(value = "/ProductRegistration",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> saveProduct( @RequestParam String productName,
                                               @RequestParam String Quantity_available,
                                               @RequestParam String price,
                                               @RequestParam String category,
                                               @RequestParam String modelNO,
                                               @RequestParam String noOfDaysUsed,
                                               @RequestParam String yearOfProductSold,
                                               @RequestPart(name = "imageFile", required = false) List<MultipartFile> files) {
        try{
//            Set<ImageModel> images = uploadImage(file);
            Product product = new Product();
            product.setProductName(productName);
            product.setQuantity_available(Integer.parseInt(Quantity_available));
            product.setPrice(Integer.parseInt(price));
            product.setCategory(category);
            product.setModelNO(modelNO);
            product.setNoOfDaysUsed(noOfDaysUsed);
            product.setYearOfProductSold(Integer.parseInt(yearOfProductSold));

            productservice.saveProduct(product);

            // Save images to image table
            if(files.size()>0) {
                for(MultipartFile file: files) {
                    ImageModel imageModel = new ImageModel();
                    imageModel.setName(file.getOriginalFilename());
                    imageModel.setPicByte(file.getBytes());
                    imageModel.setType(file.getContentType());

                    // save
                    productservice.saveImage(imageModel);
                }
            }

            return new ResponseEntity<>("Your ProductRegistration process has been successfully completed"
                    + productName , HttpStatus.OK);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }
    @PostMapping("/clothing")
    public String createClothing(@Valid @RequestBody Clothing clothing) {
        productservice.saveProduct(clothing);
        return "clothing saved succesfully";
    }
    @PostMapping("/electronic")
    public String createElectronic(@Valid @RequestBody Electronics electronic) {
        productservice.saveProduct(electronic);
        return "electronics  saved succesfully";
    }
    @PostMapping("/households")
    public String createhousehold(@Valid @RequestBody HouseHoldUtility householdutility) {
        productservice.saveProduct(householdutility);
        return "HouseHold  saved succesfully";
    }
  @GetMapping("/getAllProducts")
    public List<Product> getAllProducts()
  {
        return productservice.getAllProducts();
  }
    @GetMapping("/getting")
    public String fuck()
    {
        return "getting fuck";
    }


}
