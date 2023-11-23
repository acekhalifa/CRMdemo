package com.projectcrm.dao;

import com.projectcrm.entity.Customer;
import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
    public Customer getCustomer(int id);
}
