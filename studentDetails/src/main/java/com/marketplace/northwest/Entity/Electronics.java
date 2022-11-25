/**
 * @Author: Your name
 * @Date:   2022-11-25 14:27:36
 * @Last Modified by:   Your name
 * @Last Modified time: 2022-11-25 15:44:17
 */
package com.marketplace.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

import lombok.Data;

@Data
@Entity
@Table(name = "Electronics")
public class Electronics {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ElectronicsId;
	@Column(name = "sID")
	private String sID;
	@Column(name="SubCategory")
	private String subCategory;
	@Column(name="brandName")
	private String brandName;
	@Column(name="modelName")
	private String modelName;
	@Column(name="dimensions")
	private String dimensions;
	@Column(name="daysUsed")
	private String daysUsed;
	@Column(name="description")
	private String description;
	@Column(name="qtyAvailable")
	private String qtyAvailable;
	@Column(name="price")
	private String price;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	public Integer getElectronicsId() {
		return ElectronicsId;
	}
	public void setElectronicsId(Integer electronicsId) {
		ElectronicsId = electronicsId;
	}
	public String getsID() {
		return sID;
	}
	public void setsID(String sID) {
		this.sID = sID;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQtyAvailable() {
		return qtyAvailable;
	}
	public void setQtyAvailable(String qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Electronics [ElectronicsId=" + ElectronicsId + ", sID=" + sID + ", subCategory=" + subCategory
				+ ", brandName=" + brandName + ", modelName=" + modelName + ", dimensions=" + dimensions + ", daysUsed="
				+ daysUsed + ", description=" + description + ", qtyAvailable=" + qtyAvailable + ", price=" + price
				+ ", image=" + image + "]";
	}
	


}
