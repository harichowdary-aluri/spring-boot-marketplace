/**
 * @Author: Your name
 * @Date:   2023-03-17 18:24:52
 * @Last Modified by:   Your name
 * @Last Modified time: 2023-03-17 18:29:00
 */
package com.marketplace.Helpers;

import com.marketplace.Entity.Clothing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothingRequest {

    private Clothing clothing;
//    private List<MultipartFile> images;
}
