package com.revature.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date dob;
	private String occupation;
	@OneToOne
	@JoinColumn(name="id")
	private int state;
	@Column(name="dl_issue_date")
	private Date dlIssueDate;
	@Column(name="dl_expiry_date")
	private Date dlExpiryDate;
	
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getDlIssueDate() {
		return dlIssueDate;
	}
	public void setDlIssueDate(Date dlIssueDate) {
		this.dlIssueDate = dlIssueDate;
	}
	public Date getDlExpiryDate() {
		return dlExpiryDate;
	}
	public void setDlExpiryDate(Date dlExpiryDate) {
		this.dlExpiryDate = dlExpiryDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dlExpiryDate == null) ? 0 : dlExpiryDate.hashCode());
		result = prime * result + ((dlIssueDate == null) ? 0 : dlIssueDate.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + id;
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + state;
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
		Customer other = (Customer) obj;
		if (dlExpiryDate == null) {
			if (other.dlExpiryDate != null)
				return false;
		} else if (!dlExpiryDate.equals(other.dlExpiryDate))
			return false;
		if (dlIssueDate == null) {
			if (other.dlIssueDate != null)
				return false;
		} else if (!dlIssueDate.equals(other.dlIssueDate))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (id != other.id)
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (state != other.state)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", dob=" + dob + ", occupation=" + occupation + ", state=" + state
				+ ", dlIssueDate=" + dlIssueDate + ", dlExpiryDate=" + dlExpiryDate + "]";
	}
	
	
	
	
	
	

}
