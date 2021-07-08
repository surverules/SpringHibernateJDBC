package com.ms.sql.dao;

import com.ms.sql.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CustomerDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Customer save(Customer customer){
        entityManager.persist(customer);
        return customer;
    }

    @Transactional
    public Customer getCustomer(int id){
        return entityManager.find(Customer.class, id);
    }

    @Transactional
    public int deleteCustomer(int id){
        if (entityManager.contains(id)){
            entityManager.remove(id);
        }
        return id;
    }

    @Transactional
    public Customer getCustomerByQuery(int id){
        List<Customer> customer = entityManager
                .createQuery("select cust from customer cust where cust.id = ?")
                .setParameter(1, 1)
                .getResultList();

        return customer.get(0);
    }
}
