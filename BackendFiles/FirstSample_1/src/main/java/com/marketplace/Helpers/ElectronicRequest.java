package com.marketplace.Helpers;

import com.marketplace.Entity.Electronics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectronicRequest {

    private Electronics electronics;
//    private List<MultipartFile> images;
}
