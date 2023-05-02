package com.marketplace.Helpers;

import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Miscellenous;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiscellenousRequest {

    private Miscellenous miscellenous;
//    private List<MultipartFile> images;
}
