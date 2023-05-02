package com.marketplace.Services;

import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Student;
import com.marketplace.Helpers.ClothingRequest;
import com.marketplace.Repository.ClothingRepository;
import com.marketplace.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClothingService {

    @Autowired
    private ClothingRepository repository;
    @Autowired
    private StudentRepository studentRepository;

    public List<Clothing> getAllClothes(){
        return repository.findAll();
    }

    public Clothing getClothByID(int id){
    	return repository.findById(id).orElse(null);
        //return repository.findById(id).orElse(null);
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

    public List<Clothing> saveProduct(Clothing cloth)
    {
    	System.out.println("Inside the serice method "+ cloth);
    	

        repository.save(cloth);
        return getAllClothes();
    }

    public Clothing saveAndUpdateProduct(Clothing updated){
        return repository.save(updated);
    }

    public List<Clothing> deleteProduct(int id){
        repository.deleteById(id);
        return repository.findAll();
    }

    public List<Clothing> getAllClothesByStatus(String status) {
		System.out.println("status "+ status);
		List<Clothing> clothes = repository.findClothesByStatus(status);
		clothes.forEach(cloth -> {
			Optional<Student> student= studentRepository.findById(cloth.getStudentId());

            if(student.isPresent())
                cloth.setPhoneNumber(student.get().getPhoneNumber());
		});
		return clothes;
	}

    public List<Clothing> getUserUploads(String studentId){
        return getAllClothes().stream()
                .filter(cloth -> cloth.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }
}
