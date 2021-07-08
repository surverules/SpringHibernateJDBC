package com.ms.sql.controller;

import com.ms.sql.dao.BankDao;
import com.ms.sql.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    BankDao bankDao;

    @GetMapping("/bank")
    public void addBank(){
        Bank bank = new Bank();
        bank.setBankName("BOA");
        bank.setCheckNumber(0001);
        bank.setCustomer("sachin");
        bankDao.save(bank);
    }

    @GetMapping("/getbank")
    public Bank getBank(){
        return bankDao.getBankByQuery(15);
    }

    @GetMapping("getbankjdbc")
    public Bank getBankbyJDBC(){
        return bankDao.getBankByJDBCTemplate(15);
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "say Hello .. .Service is running";
    }
}
