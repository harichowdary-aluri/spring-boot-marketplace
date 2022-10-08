package com.marketplace.Entity;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "student")
public class Student implements Persistable<String>{
	@Id
	@Column(name = "sID")
	private String sID;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="phoneNumber")
	private String phoneNumber;
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="zip")
	private String zip;
	
	public Student(String sID, String firstName, String lastName, String password,String email, String phoneNumber, String address,
			String city, String state, String zip) {
		super();
		this.sID = sID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password= password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getsID() {
		return sID;
	}


	public void setsID(String sID) {
		this.sID = sID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password= password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return sID;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		return "Student [sID=" + sID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + "]";
	}
	
	
}



