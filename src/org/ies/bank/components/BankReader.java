package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankReader {
    private final Scanner scanner;
    private final AccountReader accountReader;

    public BankReader(Scanner scanner, AccountReader accountReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
    }

    public Bank read() {
        System.out.println("Introduce el nombre del banco");
        String bankName = scanner.nextLine();

        System.out.println("Introduce cuantas cuentas se van a introducir");
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n <= 0) {
            System.out.println("Número no válido, introduce otro");
            n = scanner.nextInt();
            scanner.nextLine();
        }
        Account[] account = new Account[n];
        for (int i = 0; i < account.length; i++) {
            account[i] = accountReader.read();
        }
        return new Bank(
                bankName,
                account
        );
    }
}
