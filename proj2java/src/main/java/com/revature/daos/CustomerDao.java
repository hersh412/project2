package com.revature.daos;

import com.revature.models.Customer;

public interface CustomerDao {
    Customer getCustomer(int id);

    void saveCustomer(Customer customer);

    void updateCustomer(int id, Customer customer);

    void deleteCustomer(int id);

}
