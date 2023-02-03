
/**
 * @Author: Your name
 * @Date:   2023-01-27 19:01:57
 * @Last Modified by:   Your name
 * @Last Modified time: 2023-02-03 10:15:17
 */

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.marketplace.*;
import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Student;
import com.marketplace.Repository.ElectronicsRepository;
import com.marketplace.Repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ElectronicsRepository electronicsRepo;

    public Student save(Student s) {
        return studentRepository.save(s);

    }

    public void saveElectronicsToDB(MultipartFile file, String sID, String subCategory, String modelName,
            String brandName, String dimensions, String daysUsed,
            String description, String qtyAvailable, String price) {
        Electronics etr = new Electronics();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a valid file");
        }
        try {
            etr.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        etr.setsID(sID);
        etr.setSubCategory(subCategory);
        etr.setModelName(modelName);
        etr.setBrandName(brandName);
        etr.setDimensions(dimensions);
        etr.setDaysUsed(daysUsed);
        etr.setDescription(description);
        etr.setQtyAvailable(qtyAvailable);
        etr.setPrice(price);

        electronicsRepo.save(etr);
    }

    public Electronics findByElectronicId(Integer id) {
        return electronicsRepo.findById(id).orElse(null);
    }
}