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
@Table(name = "Electronics")
public class Electronics {

	    @Id
	    @GeneratedValue
	    @NotNull
	    private int id;
	    private int sID;
	    private String subcategory;
	    private String productName;
	    private String modelName;
	    private double price;
	    private String dimensions;
	    private String daysUsed;
	    private int qtyAvailable;
	    private String description;
	    private String images;
	    private String studentId;
	    private String phoneNumber;
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
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getModelName() {
			return modelName;
		}
		public void setModelName(String modelName) {
			this.modelName = modelName;
		}
		public double getPrice() {
			return price;
		}
		
		public String getPhoneNumber()
		{
			return phoneNumber;
		}
		
		public void setPhoneNumber(String phoneNumber)
		{
			this.phoneNumber= phoneNumber;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDimensions() {
			return dimensions;
		}
		public void setDimensions(String dimensions) {
			this.dimensions = dimensions;
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
			return "Electronics [id=" + id + ", sID=" + sID + ", subcategory=" + subcategory + ", productName="
					+ productName + ", modelName=" + modelName + ", price=" + price + ", dimensions=" + dimensions
					+ ", daysUsed=" + daysUsed + ", qtyAvailable=" + qtyAvailable + ", description=" + description
					+ ", images=" + images + ", studentId=" + studentId + ", phoneNumber=" + phoneNumber + ", status="
					+ status + "]";
		}
		public int getsID() {
			return sID;
		}
		public void setsID(int sID) {
			this.sID = sID;
		}
	    
	    
	    
	    
}
