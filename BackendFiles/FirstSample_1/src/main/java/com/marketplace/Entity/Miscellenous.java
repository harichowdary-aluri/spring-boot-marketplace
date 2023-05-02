package com.marketplace.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Miscellenous")
public class Miscellenous {

	    @Id
	    @GeneratedValue
	    @NotNull
	    private int id;
	    private String productName;
	    private double price;
	    private String daysUsed;
	    private int qtyAvailable;
	    private String description;
	    private String images;
	    private String studentId;
	    private String status;
	    private String phoneNumber;
	   
	    
	    public String getStatus()
	    {
	    	return status;
	    }
	    
	    public String getPhoneNumber()
	    {
	    	return phoneNumber;
	    }
	    public void setPhoneNumber(String phoneNumber)
	    {
	    	this.phoneNumber= phoneNumber;
	    }
	    public void setStatus(String status)
	    {
	    	this.status= status;
	    }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
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

		@Override
		public String toString() {
			return "Miscellenous [id=" + id + ", productName=" + productName + ", price=" + price + ", daysUsed="
					+ daysUsed + ", qtyAvailable=" + qtyAvailable + ", description=" + description + ", images="
					+ images + ", studentId=" + studentId + ", status=" + status + ", phoneNumber=" + phoneNumber + "]";
		}
	
	    
	    
}