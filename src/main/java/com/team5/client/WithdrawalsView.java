package com.team5.client;

import java.util.Scanner;

import com.team5.rmiinterfaces.RMIObject;

public class WithdrawalsView {
  private RMIObject rmiObject;

  public WithdrawalsView(RMIObject rmiObject) {
    this.rmiObject = rmiObject;
  }

  public void showMenu() {
    Scanner sn = new Scanner(System.in);
    boolean out = false;
    int option;

    while (!out) {
      System.out.println("\n\n");
      System.out.println("***********************************");
      System.out.println("\t Menu de transacciones: ");
      System.out.println("\t 1. Consultar cuenta");
      System.out.println("\t 2. Deposito a cuenta");
      System.out.println("\t 3. Retiro de cuenta");
      System.out.println("\t 4. Transferencia entre cuentas");
      System.out.println("\t 5. Salir");
      System.out.println("***********************************");
      System.out.println("\n");

      try {
        option = sn.nextInt();

        switch (option) {
          case 1:
            System.out.println("Has seleccionado la opcion 1");
            break;
          case 2:
            System.out.println("Has seleccionado la opcion 2");
            break;
          case 3:
            out = true;
            break;
          case 4:
            out = true;
            break;
          case 5:
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