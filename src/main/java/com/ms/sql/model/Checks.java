package com.ms.sql.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Checks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int checkNumber;
    double checkAmount;
    String payeeName;
    String bankName;

    public Checks() {
    }

    public Checks(int checkNumber, double checkAmount, String payeeName, String bankName) {
        this.checkNumber = checkNumber;
        this.checkAmount = checkAmount;
        this.payeeName = payeeName;
        this.bankName = bankName;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    public double getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(double checkAmount) {
        this.checkAmount = checkAmount;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "Checks{" +
                "checkNumber=" + checkNumber +
                ", checkAmount=" + checkAmount +
                ", payeeName='" + payeeName + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
