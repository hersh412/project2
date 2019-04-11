package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="policy")
	private Policy policy;
	private int year;
	private int make;
	private String model;
	@Column(name="coverage_type")
	private int coverageType;
//	@Column(name="primary_driver")
	@OneToOne
	@JoinColumn(name="primary_driver")
	private Customer primaryDriver;
	private String vin;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMake() {
		return make;
	}

	public void setMake(int make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCoverageType() {
		return coverageType;
	}

	public void setCoverageType(int coverageType) {
		this.coverageType = coverageType;
	}

	public Customer getPrimaryDriver() {
		return primaryDriver;
	}

	public void setPrimaryDriver(Customer primaryDriver) {
		this.primaryDriver = primaryDriver;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coverageType;
		result = prime * result + id;
		result = prime * result + make;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((policy == null) ? 0 : policy.hashCode());
		result = prime * result + ((primaryDriver == null) ? 0 : primaryDriver.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		result = prime * result + year;
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
		Vehicle other = (Vehicle) obj;
		if (coverageType != other.coverageType)
			return false;
		if (id != other.id)
			return false;
		if (make != other.make)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (policy == null) {
			if (other.policy != null)
				return false;
		} else if (!policy.equals(other.policy))
			return false;
		if (primaryDriver == null) {
			if (other.primaryDriver != null)
				return false;
		} else if (!primaryDriver.equals(other.primaryDriver))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", policy=" + policy + ", year=" + year + ", make=" + make + ", model=" + model
				+ ", coverageType=" + coverageType + ", primaryDriver=" + primaryDriver + ", vin=" + vin + "]";
	}
	
	

}