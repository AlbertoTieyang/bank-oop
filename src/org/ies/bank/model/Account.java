package org.ies.bank.model;

import java.util.Objects;

public class Account {
    private String iban;
    private double balance;
    private Customer customer;

    public Account(String iban, double wages, Customer customer) {
        this.iban = iban;
        this.balance = wages;
        this.customer = customer;
    }
    public void deposit(double amount){
        balance += amount;
    }

    public void takeOut (double amount){
        balance -= amount;
        if (balance<amount){
            System.out.println("Dinero insuficiente");
        }
    }

    public void showInfo() {
        System.out.println("IBAN: " + iban + ", salario: " + balance + " y NIF de cliente: " + customer.getNif());
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return balance == account.balance && Objects.equals(iban, account.iban) && Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, balance, customer);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", wages=" + balance +
                ", customer=" + customer +
                '}';
    }
}