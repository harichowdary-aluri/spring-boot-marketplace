package com.productregistration.Service;

import com.productregistration.Entity.*;
import com.productregistration.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService{
    @Autowired
    private ProductRepository productrepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ElectronicRepository electronicRepository;

    @Autowired
    private ClothingRepository clothingRepository;
    @Override
    public void saveProduct(Product product) {
        productrepository.save(product);
    }

    @Override
    public void saveProduct(Clothing clothing) { clothingRepository.save(clothing); }
    @Override
    public void saveImage(ImageModel imageModel) {
        imageRepository.save(imageModel);
    }
    @Override
    public void saveProduct(Electronics electronics) { electronicRepository.save(electronics); }
    @Override
    public void saveProduct(HouseHoldUtility householdutility) { HouseHoldRepository.save(householdutility); }
    public List<Product> getAllProducts()
    {
      return(List<Product>) productrepository.findAll();
    }

}
