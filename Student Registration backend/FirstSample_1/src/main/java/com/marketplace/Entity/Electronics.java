package com.marketplace.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Electronics")
public class Electronics {

    @Id
    @GeneratedValue
    @NonNull
    private int id;
    private String productName;
    private String subCategory;
    private int quantity;
    private double price;
    private String model;
    private String dimensions;
    private int daysUsed;
    private String description;
    private String images;
    private String studentId;
    
    
	
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getId() {
		return id;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public int getDaysUsed() {
		return daysUsed;
	}
	public void setDaysUsed(int daysUsed) {
		this.daysUsed = daysUsed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public void setBrandName(String brandName) {
		// TODO Auto-generated method stub
		
	}
	
	

}
