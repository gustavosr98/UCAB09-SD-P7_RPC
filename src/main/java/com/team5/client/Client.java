package com.team5.client;

import java.util.Scanner;

public class Client {
  public static void main( String[] args ) throws Exception {
    printRunningMessage();
  }

  private static void printRunningMessage(){
    System.out.println("\n\n\n");
    System.out.println("***********************************");
    System.out.println("\t CLIENT IS RUNNING");
    System.out.println("***********************************");
    System.out.println("\n\n\n");
  }

  public void welcomeMenu() {
    Scanner sn = new Scanner(System.in);
    boolean out = false;
    int option;

    while(!out) {
        System.out.println("\n\n");
        System.out.println("***********************************");
        System.out.println("\t Selecciona una opción: ");
        System.out.println("\t 1. Abrir cuenta");
        System.out.println("\t 2. Realizar transacción");
        System.out.println("\t 3. Salir");
        System.out.println("***********************************");
        System.out.println("\n");

        try {
            option = sn.nextLine();

            switch(option){
                case 1:
                    OpenAccount openAccount = openAccount.readDocumentId()
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    break;
                case 3:
                    out = true;
                    break;
                default:
                    System.out.println("Opción Inválida");
            }

        } catch (Exception e) {
            System.out.println("Debes insertar un número");
            sn.next();
        }
    }
  }
}
