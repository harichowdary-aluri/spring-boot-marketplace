
/**
 * @Author: Kiran Kumar Gundapuneni
 * @Date:   2023-03-03 11:36:48
 * @Last Modified by:   Your name
 * @Last Modified time: 2023-03-03 11:40:57
 */

import com.marketplace.Entity.Automobiles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomobileRequest {

    private Automobiles automobiles;
    // private List<MultipartFile> images;
}
