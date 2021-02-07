package com.team5.client;

import com.team5.entities.UserBank;
import com.team5.entities.Account;

public class OpenAccount {
    public boolean readDocumentId() {
        Scanner sn = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Escribe tu documento de identidad: ");
        System.out.println("\n");
        try {
            int documentId = sn.nextLine();

            UserBank userBank = openAccount.findUserByDocumentId(documentId)

            if (userBank == null) {
                return this.createUser()
            } else {
                return this.searchAccounts(userBank)
            }

        } catch (Exception e) {
            System.out.println("Debes escribir un número");
            return false
        }
    }

    public boolean createUser() {
        try {
            Scanner sn = new Scanner(System.in);
            System.out.println("\n\n");
            System.out.println("Escribe tu nombre: ");
            System.out.println("\n");
            String name = sn.nextLine();

            System.out.println("\n\n");
            System.out.println("Escribe tu nombre de usuario: ");
            System.out.println("\n");
            String username = sn.nextLine();

            System.out.println("\n\n");
            System.out.println("Escribe tu contraseña: ");
            System.out.println("\n");
            String password = sn.nextLine();

            int id = openAccount.createUser(name, username, password);

            UserBank userBank = openAccount.findUserByDocumentId(id)

            return this.createAccount(userBank)
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false
        }
    }

    public boolean searchAccounts(UserBank userBank) {
        try {
            int cant = openAccount.findAccounts(userBank.getDocumentId()); 
            if (cant == 3) {
                System.out.println("Ya posee el número máximo de cuentas = 3");
                return false
            } else {
                this.validateUser(userBank)
            }
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false
        }
    }

    public boolean validateUser(UserBank userBank) {
        try {
            Scanner sn = new Scanner(System.in);
            System.out.println("\n\n");
            System.out.println("Escribe tu nombre de usuario: ");
            System.out.println("\n");
            String username = sn.nextLine();

            System.out.println("\n\n");
            System.out.println("Escribe tu contraseña: ");
            System.out.println("\n");
            String password = sn.nextLine();

            if (Objects.equals(username, userBank.getUsername()) && Objects.equals(password, userBank.getPassword())) {
                return this.createAccount(userBank)
            } else {
                System.out.println("Credenciales inválidas");
                return false
            }
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false
        }
    }

    public boolean createAccount(UserBank userBank) {
        try {
            Scanner sn = new Scanner(System.in);
            System.out.println("\n\n");
            System.out.println("Escribe la cantidad inicial con la que deseas abrir la cuenta: ");
            System.out.println("\n");
            String amount = sn.nextLine();

            int id = openAccount.createAccount(amount, userBank);

            System.out.println("Cuenta creada exitosamente: " + id);

            return true;
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false
        }
    }
}