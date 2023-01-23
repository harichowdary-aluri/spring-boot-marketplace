
/**
 * @Author: Your name
 * @Date:   2022-09-30 09:36:13
 * @Last Modified by:   Your name
 * @Last Modified time: 2023-01-22 13:48:47
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.*;
import com.marketplace.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
