package org.ies.bank.components;

import org.ies.bank.model.Bank;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run(){
        Bank bank = bankReader.read();
        int option;
        do {
            option = chooseOption();
            if(option ==1){
                bank.showAccount();
            } else if (option==2) {
                System.out.println("Introduce un IBAN");
                String iban = scanner.nextLine();
                bank.showIbanAccount(iban);
            } else if (option==3) {
                System.out.println("Introduce un NIF");
                String nif = scanner.nextLine();
                bank.findIban(nif);
            } else if (option==4) {
                System.out.println("Introduce el IBAN de la cuenta");
                String iban = scanner.nextLine();
                System.out.println("Introduce la cantidad de dinero que desea ingresar");
                double amount = scanner.nextInt();
                scanner.nextLine();
                bank.addMoney(iban, amount);
            } else if (option == 5) {
                System.out.println("Introduce el IBAN de la cuenta");
                String iban = scanner.nextLine();
                System.out.println("Introduce la cantidad de dinero que desea retirar");
                double amount = scanner.nextInt();
                scanner.nextLine();
                bank.takeOut(iban, amount);
            }   else if (option == 6) {
            System.out.println("Introduce el NIF del cliente:");
            String nif = scanner.nextLine();

            int customerAccountsNumber = bank.countCustomerAccounts(nif);
            System.out.println("El cliente tiene " + customerAccountsNumber + " cuentas.");
        } else if (option == 7) {
            System.out.println("Introduce el IBAN:");
            String iban = scanner.nextLine();

            bank.showAccountCustomer(iban);
        }

        } while (option <8);
    }
    private int chooseOption(){
        int option;
        do {
            System.out.println("Elige una de las opciones");
            System.out.println("1. Mostrar las cuenta de banco");
            System.out.println("2. Mostrar los datos de la cuenta");
            System.out.println("3. Mostrar los datos de la cuenta de un cliente");
            System.out.println("4. Ingresar dinero en la cuenta");
            System.out.println("5. Sacar dinero de la cuenta");
            System.out.println("6. Salir");
            option = scanner.nextInt();
            scanner.nextLine();
        }while(option<1 || option >6);

        return option;
    }

}
