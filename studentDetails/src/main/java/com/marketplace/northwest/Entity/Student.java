package com.marketplace.northwest.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    
	private String SId;
	private String FirstName;
	private String LastName;
	private Long PhoneNo;
	private String Emailid;
	private String Address;
	private String City;
	private String State;
	private int zip;

}
