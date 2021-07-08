package com.ms.sql.dao;

import com.ms.sql.model.Bank;
import com.ms.sql.model.Checks;
import com.ms.sql.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class BankDao {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public Bank save(Bank bank){
        entityManager.persist(bank);
        return bank;
    }

    @Transactional
    public Bank getBank(int id){
        return entityManager.find(Bank.class, id);
    }

    @Transactional
    public int deleteBank(int id){
        if (entityManager.contains(id)){
            entityManager.remove(id);
        }
        return id;
    }

    @Transactional
    public Bank getBankByQuery(int id){
        List<Bank> banks = entityManager
                .createNativeQuery("select * from BANK bank where bank.banknumber = :id", Bank.class)
                .setParameter("id", "15")
                .getResultList();
        return banks.get(0);
    }

    public Bank getBankByJDBCTemplate(int id){
        return jdbcTemplate.queryForObject("select * from BANK bank where bank.banknumber = ?",
                new Object[]{id},
                (res, count) ->
                        new Bank(res.getInt(1),
                                res.getString(2),
                                res.getString(3),
                                res.getInt(4))
        );
    }
}
