package com.marketplace.Services;

import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Miscellenous;
import com.marketplace.Helpers.ClothingRequest;
import com.marketplace.Repository.ClothingRepository;
import com.marketplace.Repository.ElectronicsRepository;
import com.marketplace.Repository.MiscellenousRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MiscellenousService {

    @Autowired
    private MiscellenousRepository repository;

    public List<Miscellenous> getAllMiscellenous(){
        return repository.findAll();
    }

    public Miscellenous getMiscellenousByID(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Miscellenous> saveProduct(Miscellenous misc)
    {
    	System.out.println("Inside the serice method "+ misc);
    	

        repository.save(misc);
        return getAllMiscellenous();
    }

    public Miscellenous saveAndUpdateProduct(Miscellenous updated){
        return repository.save(updated);
    }

    public List<Miscellenous> deleteProduct(int id){
        repository.deleteById(id);
        return repository.findAll();
    }


    public List<Miscellenous> getUserUploads(String studentId){
        return getAllMiscellenous().stream()
                .filter(misc -> misc.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }
}
