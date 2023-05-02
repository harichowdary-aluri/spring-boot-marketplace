package com.marketplace.Services;

import com.marketplace.Entity.Automobiles;
import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Student;
import com.marketplace.Helpers.ClothingRequest;
import com.marketplace.Repository.AutomobilesRepository;
import com.marketplace.Repository.ClothingRepository;
import com.marketplace.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutomobileService {

    @Autowired
    private AutomobilesRepository repository;
    @Autowired
    private StudentRepository studentRepository;

    public List<Automobiles> getAllAutomobiles(){
        return repository.findAll();
    }

    public Automobiles getAutomobileByID(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Automobiles> getAllAutomobilesBySub(String subcat){
        List<Automobiles> all = getAllAutomobiles();

        return all.stream()
                .filter(auto -> auto.getSubcategory().equals(subcat))
                .collect(Collectors.toList());

    }
    
    public List<Automobiles> getAllAutomobilesByStatus(String status) {
		System.out.println("status "+ status);
		List<Automobiles> automobiles = repository.findAutomobilesByStatus(status);
	    automobiles.forEach(auto -> {
			Optional<Student> student= studentRepository.findById(auto.getStudentId());

            if(student.isPresent())
            	auto.setPhoneNumber(student.get().getPhoneNumber());
		});
		return automobiles;
	}

    public List<Automobiles> saveProduct(Automobiles auto)
    {
    	System.out.println("Inside the serice method "+ auto);
    	

        repository.save(auto);
        return getAllAutomobiles();
    }

    public Automobiles saveAndUpdateProduct(Automobiles updated){
        return repository.save(updated);
    }

    public List<Automobiles> deleteProduct(int id){
        repository.deleteById(id);
        return repository.findAll();
    }


    public List<Automobiles> getUserUploads(String studentId){
        return getAllAutomobiles().stream()
                .filter(auto -> auto.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }
}
