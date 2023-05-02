package com.marketplace.Services;

import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Student;
import com.marketplace.Helpers.ClothingRequest;
import com.marketplace.Repository.ClothingRepository;
import com.marketplace.Repository.ElectronicsRepository;
import com.marketplace.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ElectronicsService {

    @Autowired
    private ElectronicsRepository repository;
    
    @Autowired
    private StudentRepository studentRepository;

    public List<Electronics> getAllElectronics(){
        return repository.findAll();
    }

    public Electronics getElectronicByID(int id){
        return repository.findById(id).orElse(null);
    }
    
    public List<Electronics> getAllElectronicsByStatus(String status) {
		System.out.println("status "+ status);
		List<Electronics> electronics = repository.findElectronicsByStatus(status);
		electronics.forEach(elec -> {
			Optional<Student> student= studentRepository.findById(elec.getStudentId());

            if(student.isPresent())
                elec.setPhoneNumber(student.get().getPhoneNumber());
		});
		return electronics;
	}

    public List<Electronics> getAllElectronicsBySub(String subcat){
        List<Electronics> all = getAllElectronics();

        return all.stream()
                .filter(elec -> elec.getSubcategory().equals(subcat))
                .collect(Collectors.toList());

    }

    public List<Electronics> saveProduct(Electronics elec)
    {
    	System.out.println("Inside the serice method "+ elec);
    	

        repository.save(elec);
        return getAllElectronics();
    }

    public Electronics saveAndUpdateProduct(Electronics updated){
        return repository.save(updated);
    }

    public List<Electronics> deleteProduct(int id){
        repository.deleteById(id);
        return repository.findAll();
    }


    public List<Electronics> getUserUploads(String studentId){
        return getAllElectronics().stream()
                .filter(elec -> elec.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }
}
