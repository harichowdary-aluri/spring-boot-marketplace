package com.marketplace.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Automobiles")
public class Automobiles {

    @Id
    @GeneratedValue
    @NotNull
    private int id;
    private String subcategory;
    private String productName;
    private String companyName;
    private double price;
    private String modelName;
    private String capacity;
    private String daysUsed;
    private int qtyAvailable;
    private String description;
    private String images;
    private String studentId;
	public int getId() {
		return id;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	public String getDaysUsed() {
		return daysUsed;
	}
	public void setDaysUsed(String daysUsed) {
		this.daysUsed = daysUsed;
	}
	public int getQtyAvailable() {
		return qtyAvailable;
	}
	public void setQtyAvailable(int qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
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
	@Override
	public String toString() {
		return "Automobiles [id=" + id + ", subcategory=" + subcategory + ", productName=" + productName
				+ ", companyName=" + companyName + ", price=" + price + ", modelName=" + modelName + ", capacity="
				+ capacity+" daysUsed=" + daysUsed + ", qtyAvailable=" + qtyAvailable
				+ ", description=" + description + ", images=" + images + ", studentId=" + studentId + "]";
	}
	
	
}

