package com.ms.sql.dao;

import com.ms.sql.model.Checks;
import com.ms.sql.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CheckDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Checks save(Checks checks){
        entityManager.persist(checks);
        return checks;
    }

    @Transactional
    public Checks getChecks(int id){
        return entityManager.find(Checks.class, id);
    }

    @Transactional
    public int deleteCheck(int id){
        if (entityManager.contains(id)){
            entityManager.remove(id);
        }
        return id;
    }
}
