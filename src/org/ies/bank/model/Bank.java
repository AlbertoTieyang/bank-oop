package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String nameBank;
    private Account[] accounts;

    public Bank(String nameBank, Account[] accounts) {
        this.nameBank = nameBank;
        this.accounts = accounts;
    }

    public void showAccount() {
        for (var account : accounts) {
            account.showInfo();
        }
    }

    public String showIbanAccount(String iban) {
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                System.out.println("información de la cuenta: " + account.getIban() + account.getBalance());
            }
        }
        return null;
    }
    public int countCustomerAccounts(String nif) {
        int count = 0;
        for (var account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                count++;
            }
        }
        return count;
    }
    public void showAccountCustomer(String iban) {
        var account = findAccount(iban);
        if (account == null) {
            System.out.println("La cuenta no existe");
        } else {
            account.getCustomer().showInfo();
        }
    }

    public void showNif(String nif){
        for (var account: accounts){
            if (account.getCustomer().getNif().equals(nif)){
                account.showInfo();
            }
        }
    }
    public void addMoney(String iban, double amount){
        var account = findAccount(iban);
        if(account != null){
            account.deposit(amount);
        }else{
            System.out.println("Cuenta no encontrada");
        }
    }

    public void takeOut (String iban, double amount){
        var account = findAccount(iban);
        if(account != null){
            account.takeOut(amount);
        }else{
            System.out.println("Cuenta no encontrada");
        }
    }


    public Account findAccount(String iban){
        for(var account: accounts){
            if(account.getIban().equals(iban)){
                return account;
            }
        }
        return null;
    }
    public String getNameBank() {
        return nameBank;
    }

    public int findIban(String nif){
        int count = 0;
        for(var account: accounts){
            if(account.getCustomer().getNif().equals(nif)){
                ++count;
            }
        }
        return count;
    }

    public Customer infoCustomer (String iban){
        var account = findAccount(iban);
        if(account == null){
            return null;
        }
        else {
            account.getCustomer();
        }
        return null;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(nameBank, bank.nameBank) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameBank, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "nameBank='" + nameBank + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
