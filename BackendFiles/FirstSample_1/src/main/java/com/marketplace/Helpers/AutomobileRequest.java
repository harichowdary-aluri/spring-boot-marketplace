package com.marketplace.Helpers;

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
//    private List<MultipartFile> images;
}
