package com.marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TextMessageFormat {

    private String sellerPhoneNumber;
    private String studentPhoneNumber;
    private String studentName;
   
	private String productUrl;
	
	 public String getSellerPhoneNumber() {
			return sellerPhoneNumber;
		}
		public void setSellerPhoneNumber(String sellerPhoneNumber) {
			this.sellerPhoneNumber = sellerPhoneNumber;
		}
		public String getStudentPhoneNumber() {
			return studentPhoneNumber;
		}
		public void setStudentPhoneNumber(String studentPhoneNumber) {
			this.studentPhoneNumber = studentPhoneNumber;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public String getProductUrl() {
			return productUrl;
		}
		public void setProductUrl(String productUrl) {
			this.productUrl = productUrl;
		}
}
