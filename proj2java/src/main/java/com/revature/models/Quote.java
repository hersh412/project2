package com.revature.models;

import javax.persistence.Entity;

@Entity
public class Quote {
	private String zipcode;
	private String make;
	private String year;
	private String gender;
	private String age;
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Quote [zipcode=" + zipcode + ", make=" + make + ", year=" + year + ", gender=" + gender + ", age=" + age
				+ "]";
	}
	public Quote(String zipcode, String make, String year, String gender, String age) {
		super();
		this.zipcode = zipcode;
		this.make = make;
		this.year = year;
		this.gender = gender;
		this.age = age;
	}
	public Quote() {
		// TODO Auto-generated constructor stub
	}
	
	
}
	
	