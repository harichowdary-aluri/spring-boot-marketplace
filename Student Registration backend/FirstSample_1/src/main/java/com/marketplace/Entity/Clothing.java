package com.marketplace.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Clothing")
public class Clothing {

    @Id
    @GeneratedValue
    @NotNull
    private int id;
    private String subcategory;
    private String productName;
    private String size;
    private String colour;
    private double price;
    private String daysUsed;
    private int qtyAvailable;
    private String images;
    private String description;
    private String studentId;
    private String status;
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	@Override
	public String toString() {
		return "Clothing [id=" + id + ", subcategory=" + subcategory + ", productName=" + productName + ", size=" + size
				+ ", colour=" + colour + ", price=" + price + ", daysUsed=" + daysUsed + ", qtyAvailable="
				+ qtyAvailable + ", images=" + images + ", studentId=" + studentId + "]";
	}
	
    
    

}
