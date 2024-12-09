package org.ies.bank.components;

import org.ies.bank.model.Customer;

import java.util.Scanner;

public class CustomerReader {
    private final Scanner scanner;

    public CustomerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Customer read() {
        System.out.println("Introduce tu NIF");
        String nif = scanner.nextLine();
        System.out.println("Introduce tu Nombre");
        String name = scanner.nextLine();
        System.out.println("Introduce tus Apellidos");
        String surname = scanner.nextLine();

        return new Customer(
                nif,
                name,
                surname
        );
    }
}
