package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="demerit")
public class Demerit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//I added a commented out line in the customer class which will also include a set of demerits for each customer. This will likley be the ideal way to access 
	// demerit information, as far as I underatnd it this will save us form having to build a demeric controller
	// and angular model and service... 
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	private int type;
	private String vin;
	private String explaniation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getExplaniation() {
		return explaniation;
	}
	public void setExplaniation(String explaniation) {
		this.explaniation = explaniation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((explaniation == null) ? 0 : explaniation.hashCode());
		result = prime * result + id;
		result = prime * result + type;
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
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
		Demerit other = (Demerit) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (explaniation == null) {
			if (other.explaniation != null)
				return false;
		} else if (!explaniation.equals(other.explaniation))
			return false;
		if (id != other.id)
			return false;
		if (type != other.type)
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Demerit [id=" + id + ", customer=" + customer + ", type=" + type + ", vin=" + vin + ", explaniation="
				+ explaniation + "]";
	}
	public Demerit() {
		// TODO Auto-generated constructor stub
	}

	

}
