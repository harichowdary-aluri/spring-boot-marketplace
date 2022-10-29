package com.productregistration.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class HouseHoldUtility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subCategory;
    private String product_name;
    private String noOfDaysUsed;
    private int price;
    private int QuantityAvailable;
    private String description;
}
