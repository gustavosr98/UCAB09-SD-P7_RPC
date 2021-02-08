package com.team5.client;

import com.team5.entities.UserBank;
import com.team5.entities.Account;

import com.team5.rmiinterfaces.RMIObject;

import java.util.Scanner;

public class OpenAccount {
    public boolean readDocumentId(RMIObject rmiObject) {
        Scanner sn = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Escribe tu documento de identidad: ");
        System.out.println("\n");
        try {
            int documentId = sn.nextInt();

            UserBank userBank = rmiObject.openAccount.findUserByDocumentId(documentId);

            if (userBank == null) {
                return this.createUser(rmiObject);
            } else {
                return this.searchAccounts(rmiObject, userBank);
            }

        } catch (Exception e) {
            System.out.println("Debes escribir un número");
            return false;
        }
    }

    public boolean createUser(RMIObject rmiObject) {
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

            int id = rmiObject.openAccount.createUser(name, username, password);

            UserBank userBank = rmiObject.openAccount.findUserByDocumentId(id);

            return this.createAccount(rmiObject, userBank);
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false;
        }
    }

    public boolean searchAccounts(RMIObject rmiObject, UserBank userBank) {
        try {
            int cant = rmiObject.openAccount.findAccounts(userBank.getDocumentId()); 
            if (cant == 3) {
                System.out.println("Ya posee el número máximo de cuentas = 3");
                return false;
            } else {
                return this.validateUser(rmiObject, userBank);
            }
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false;
        }
    }

    public boolean validateUser(RMIObject rmiObject, UserBank userBank) {
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

            if (username.equals(userBank.getUsername()) && password.equals(userBank.getPassword())) {
                return this.createAccount(rmiObject, userBank);
            } else {
                System.out.println("Credenciales inválidas");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false;
        }
    }

    public boolean createAccount(RMIObject rmiObject, UserBank userBank) {
        try {
            Scanner sn = new Scanner(System.in);
            System.out.println("\n\n");
            System.out.println("Escribe la cantidad inicial con la que deseas abrir la cuenta: ");
            System.out.println("\n");
            float amount = sn.nextFloat();

            int id = rmiObject.openAccount.createAccount(amount, userBank);

            System.out.println("Cuenta creada exitosamente: " + id);

            return true;
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false;
        }
    }
}