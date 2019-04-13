package com.revature.models;

import javax.persistence.Entity;

@Entity
public class Quote {
	private long id;
	private String zipcode;
	private String vehicleClass;
	private String year;
	private String gender;
	private String age;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getVehicleClass() {
		return vehicleClass;
	}
	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((vehicleClass == null) ? 0 : vehicleClass.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quote other = (Quote) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (vehicleClass == null) {
			if (other.vehicleClass != null)
				return false;
		} else if (!vehicleClass.equals(other.vehicleClass))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Quote [id=" + id + ", zipcode=" + zipcode + ", vehicleClass=" + vehicleClass + ", year=" + year
				+ ", gender=" + gender + ", age=" + age + "]";
	}
	public Quote(long id, String zipcode, String vehicleClass, String year, String gender, String age) {
		super();
		this.id = id;
		this.zipcode = zipcode;
		this.vehicleClass = vehicleClass;
		this.year = year;
		this.gender = gender;
		this.age = age;
	}
	public Quote() {
		// TODO Auto-generated constructor stub
	}
	
	
}
	
	