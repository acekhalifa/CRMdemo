package com.projectcrm.dao;

import com.projectcrm.entity.Customer;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        var session = sessionFactory.getCurrentSession();
        var query = session.createQuery("from Customer order by lastName", Customer.class);
        var customers = query.getResultList();
        return customers;
    }
//Objects.isNull(session.find(Customer.class, customer.getId()))
    @Override
    public void saveCustomer(Customer customer) {
        var session = sessionFactory.getCurrentSession();
        var temp = session.find(Customer.class, customer.getId());
        if (temp == null) {
            session.persist(customer);
        } else {
            session.merge(customer);
        }
    }

    @Override
    public Customer getCustomer(int id) {
        var session = sessionFactory.getCurrentSession();
        var customer= session.find(Customer.class, id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        var session = sessionFactory.getCurrentSession();
        var query = session.createMutationQuery("from customer where id:=customerId");
        query.setParameter("customerId", id);
        int r = query.executeUpdate();
        System.out.println("Query executed. Row affected == " + r);
    }

}
