package com.marketplace.Helpers;

import com.marketplace.Entity.Household;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseholdRequest {

    private Household household;
//    private List<MultipartFile> images;
}
