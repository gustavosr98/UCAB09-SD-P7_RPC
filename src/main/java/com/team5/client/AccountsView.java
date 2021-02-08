package com.team5.client;

import java.util.List;
import java.util.Scanner;

import com.team5.entities.UserBank;
import com.team5.rmiinterfaces.RMIObject;

public class AccountsView {
  private RMIObject rmiObject;

  public AccountsView(RMIObject rmiObject) {
    this.rmiObject = rmiObject;
  }

  public void showMenu() {
    Scanner sn = new Scanner(System.in);
    boolean out = false;
    int option;

    while (!out) {
      System.out.println("\n\n");
      System.out.println("***********************************");
      System.out.println("\t Menu de cuentas: ");
      System.out.println("\t 1. Mostrar cuentas");
      System.out.println("\t 5. Salir");
      System.out.println("***********************************");
      System.out.println("\n");

      try {
        option = sn.nextInt();

        switch (option) {
          case 1:
            // List<UserBank> userBanks = rmiObject.userBankService.getAll();
            // if (userBanks.size() > 0) {
            // for (UserBank userBank : userBanks) {
            // System.out.println(userBank.getName());
            // }
            // }
            break;
          case 5:
            out = true;
            break;
          default:
            System.out.println("Opción Inválida");
        }

      } catch (Exception e) {
        System.out.println("Debes insertar un número");
        e.printStackTrace();
        sn.next();
      }
    }
    sn.close();
  }
}