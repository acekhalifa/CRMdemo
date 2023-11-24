package com.projectcrm.service;

import com.projectcrm.entity.Customer;
import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public void deleteCustomer(int id);
    public void saveCustomer(Customer customer);
    public Customer getCustomer(int id);
}
