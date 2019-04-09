package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int policy;
	private int year;
	private int make;
	private String model;
	@Column(name="coverage_type")
	private int coverageType;
	@Column(name="primary_driver")
	private int primaryDriver;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coverageType;
		result = prime * result + id;
		result = prime * result + make;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + policy;
		result = prime * result + primaryDriver;
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
		if (policy != other.policy)
			return false;
		if (primaryDriver != other.primaryDriver)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", policy=" + policy + ", year=" + year + ", make=" + make + ", model=" + model
				+ ", coverageType=" + coverageType + ", primaryDriver=" + primaryDriver + "]";
	}
	
	
	

}
