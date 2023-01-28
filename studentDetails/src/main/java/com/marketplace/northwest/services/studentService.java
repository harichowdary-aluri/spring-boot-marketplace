
/**
 * @Author: Your name
 * @Date:   2023-01-27 19:01:57
 * @Last Modified by:   Your name
 * @Last Modified time: 2023-01-27 19:05:06
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
}