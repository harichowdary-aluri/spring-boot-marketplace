package com.marketplace.Services;

import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Household;
import com.marketplace.Entity.Miscellenous;
import com.marketplace.Entity.Student;
import com.marketplace.Helpers.ClothingRequest;
import com.marketplace.Repository.ClothingRepository;
import com.marketplace.Repository.ElectronicsRepository;
import com.marketplace.Repository.MiscellenousRepository;
import com.marketplace.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MiscellenousService {

    @Autowired
    private MiscellenousRepository repository;
    
    @Autowired
    private StudentRepository studentRepository;

    public List<Miscellenous> getAllMiscellenous(){
        return repository.findAll();
    }

    public Miscellenous getMiscellenousByID(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Miscellenous> getAllOthersByStatus(String status) {
  		System.out.println("status "+ status);
  		List<Miscellenous> miscell = repository.findOthersByStatus(status);
  		miscell.forEach(misc -> {
			Optional<Student> student= studentRepository.findById(misc.getStudentId());

            if(student.isPresent())
            	misc.setPhoneNumber(student.get().getPhoneNumber());
		});
		return miscell;
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
