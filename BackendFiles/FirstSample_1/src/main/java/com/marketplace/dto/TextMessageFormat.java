package com.marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextMessageFormat {

    private long sellerPhoneNumber;
    private long studentPhoneNumber;
    private String studentName;
    private String productUrl;
}
