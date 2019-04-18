package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.User;

public interface CustomerDao {
	public Customer getCustomer(int id);
	public void saveCustomer(Customer customer);
	public void updateCustomer(int id, Customer customer);
	public void deleteCustomer(int id);

}
