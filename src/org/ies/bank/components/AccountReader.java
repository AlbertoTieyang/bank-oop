package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class AccountReader {
    private final Scanner scanner;
    private final CustomerReader customerReader;

    public AccountReader(Scanner scanner, CustomerReader customerReader) {
        this.scanner = scanner;
        this.customerReader = customerReader;
    }

    public Account read() {
        System.out.println("Introduce el IBAN de tu cuenta");
        String iban = scanner.nextLine();

        System.out.println("Introduce tu salario");
        double wages = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Introduce los datos del cliente");
        Customer customer = customerReader.read();

        return new Account(
                iban,
                wages,
                customer
        );
    }
}
