package com.marketplace.Services;

import com.marketplace.Entity.Clothing;
import com.marketplace.Helpers.ClothingRequest;
import com.marketplace.Repository.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothingService {

    @Autowired
    private ClothingRepository repository;

    public List<Clothing> getAllClothes(){
        return repository.findAll();
    }

    public Clothing getClothByID(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Clothing> getAllClothesBySub(String subcat){
        List<Clothing> all = getAllClothes();
       // List<Clothing> filteredList = new ArrayList<>();

		
		  return all.stream() .filter(cloth -> cloth.getSubcategory().equals(subcat))
		  .collect(Collectors.toList());
		 
        
		/*
		 * for(Clothing cloth: all) { if(cloth.getSubcategory().equals(subcat)) {
		 * filteredList.add(cloth); } }
		 * 
		 * return filteredList;
		 */
    }
