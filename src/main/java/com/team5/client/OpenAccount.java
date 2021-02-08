package com.team5.client;

import com.team5.entities.UserBank;
import com.team5.entities.Account;

import com.team5.rmiinterfaces.RMIObject;

import java.util.Scanner;

public class OpenAccount {
    private RMIObject rmiObject;

    public OpenAccount(RMIObject rmiObject) {
        this.rmiObject = rmiObject;
    }

    public boolean readDocumentId() {
        Scanner sn = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Escribe tu documento de identidad: ");
        System.out.println("\n");
        try {
            int id = sn.nextInt();

            boolean userBank = rmiObject.existUser(id);

            if (userBank) {
                return this.searchAccounts(id);
            } else {
                return this.createUser(id);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Debes escribir un número");
            return false;
        }
    }

    public boolean createUser(int id) {
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

            rmiObject.createUser(id, name, username, password);

            return this.createAccount(id);
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false;
        }
    }

    public boolean searchAccounts(int id) {
        try {
            int cant = rmiObject.findAccounts(id); 
            if (cant == 3) {
                System.out.println("Ya posee el número máximo de cuentas = 3");
                return false;
            } else {
                return this.validateUser(id);
            }
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false;
        }
    }

    public boolean validateUser(int id) {
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

            if (rmiObject.validateUser(id, username, password)) {
                return this.createAccount(id);
            } else {
                System.out.println("Credenciales inválidas");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false;
        }
    }

    public boolean createAccount(int userBankId) {
        try {
            Scanner sn = new Scanner(System.in);
            System.out.println("\n\n");
            System.out.println("Escribe la cantidad inicial con la que deseas abrir la cuenta: ");
            System.out.println("\n");
            float amount = sn.nextFloat();

            int id = rmiObject.createAccount(amount, userBankId);

            System.out.println("Cuenta creada exitosamente: " + id);

            return true;
        } catch (Exception e) {
            System.out.println("Datos inválidos");
            return false;
        }
    }
}