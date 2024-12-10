package org.ies.bank.model;

import java.util.Objects;

public class Account {
    private String iban;
    private double balance;
    private Customer customer;

        this.iban = iban;
        this.customer = customer;
    }
    public void deposit(double amount){
        balance += amount;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, balance, customer);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", customer=" + customer +
                '}';
    }
}
