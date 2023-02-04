package com.marketplace.Services;

import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Household;
import com.marketplace.Helpers.ClothingRequest;
import com.marketplace.Repository.ClothingRepository;
import com.marketplace.Repository.ElectronicsRepository;
import com.marketplace.Repository.HouseholdRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseholdService {

    @Autowired
    private HouseholdRepository repository;

    public List<Household> getAllHousehold(){
        return repository.findAll();
    }

    public Household getHouseholdByID(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Household> getAllHouseholdBySub(String subcat){
        List<Household> all = getAllHousehold();

        return all.stream()
                .filter(house -> house.getSubcategory().equals(subcat))
                .collect(Collectors.toList());

    }

    public List<Household> saveProduct(Household house)
    {
    	System.out.println("Inside the serice method "+ house);
    	

        repository.save(house);
        return getAllHousehold();
    }

    public Household saveAndUpdateProduct(Household updated){
        return repository.save(updated);
    }

    public List<Household> deleteProduct(int id){
        repository.deleteById(id);
        return repository.findAll();
    }


    public List<Household> getUserUploads(String studentId){
        return getAllHousehold().stream()
                .filter(house -> house.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }
}
