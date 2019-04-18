package com.revature.models;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="auth")
public class Auth {
	@Transient
	private String email;
	@Transient
	private String password;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="valid_key")
	private String key;
	@Column(name="time_stamp")
	private Timestamp timeStamp;
	//also know as userConf in User model -- different name same entity. 
	@Column(name="auth_level")
	private int authLevel;
	
	public Auth(String key, Timestamp timeStamp, int authLevel) {
		super();
		this.key = key;
		this.timeStamp = timeStamp;
		this.authLevel = authLevel;
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
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public int getAuthLevel() {
		return authLevel;
	}
	public void setAuthLevel(int authLevel) {
		this.authLevel = authLevel;
	}
	/*
	 * Hashcode and equals + toString 
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authLevel;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
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
		Auth other = (Auth) obj;
		if (authLevel != other.authLevel)
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Auth [email=" + email + ", password=" + password + ", key=" + key + ", timeStamp=" + timeStamp
				+ ", authLevel=" + authLevel + "]";
	}
	
	/*
	 * Constructors
	 */
	
	
	public Auth(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public Auth() {
		super();
		// TODO Auto-generated constructor stub
	}
}
