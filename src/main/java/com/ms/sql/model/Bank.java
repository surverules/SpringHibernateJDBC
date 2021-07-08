package com.ms.sql.model;



import javax.persistence.*;

@Entity
@Table(name = "BANK")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "banknumber")
    int bankNumber;

    @Column(name = "bankname")
    String bankName;

    @Column(name = "customer")
    String customer;

    @Column(name = "checknumber")
    int checkNumber;

    public Bank() {
    }

    public Bank(int bankNumber, String bankName, String customer, int checkNumber) {
        this.bankNumber = bankNumber;
        this.bankName = bankName;
        this.customer = customer;
        this.checkNumber = checkNumber;
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }
}
