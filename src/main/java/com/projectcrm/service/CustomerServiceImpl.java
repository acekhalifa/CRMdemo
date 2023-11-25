package com.projectcrm.service;

import com.projectcrm.dao.CustomerDAO;
import com.projectcrm.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    @Override
    public List<Customer> getCustomers(int sortKey) {
        return customerDAO.getCustomers(sortKey);
    }

    @Transactional
    @Override
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        var customer = customerDAO.getCustomer(id);
        return customer;
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

}
