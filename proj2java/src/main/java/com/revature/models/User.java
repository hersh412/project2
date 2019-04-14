package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="\"user\"")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userid", updatable=false, nullable=false)
	private int id;
	private String email;
	private String password;
	private int userconf;
	@Column(name="first_name")
	private String fName;
	@Column(name="last_name")
	private String lName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	@Column(name = "is_male")
	private boolean gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserconf() {
		return userconf;
	}

	public void setUserconf(int userconf) {
		this.userconf = userconf;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id &&
				userconf == user.userconf &&
				gender == user.gender &&
				Objects.equals(email, user.email) &&
				Objects.equals(password, user.password) &&
				Objects.equals(fName, user.fName) &&
				Objects.equals(lName, user.lName) &&
				Objects.equals(address1, user.address1) &&
				Objects.equals(address2, user.address2) &&
				Objects.equals(city, user.city) &&
				Objects.equals(state, user.state) &&
				Objects.equals(zip, user.zip);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email, password, userconf, fName, lName, address1, address2, city, state, zip, gender);
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", userconf=" + userconf +
				", fName='" + fName + '\'' +
				", lName='" + lName + '\'' +
				", address1='" + address1 + '\'' +
				", address2='" + address2 + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zip='" + zip + '\'' +
				", gender=" + gender +
				'}';
	}
}
