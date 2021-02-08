package com.team5.client;

import java.util.Scanner;

import com.team5.rmiinterfaces.RMIObject;

public class TransactionsView {
  private RMIObject rmiObject;

  public TransactionsView(RMIObject rmiObject) {
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
            AccountsView accountsView = new AccountsView(rmiObject);
            accountsView.showMenu();
            break;
          case 2:
            DepositsView depositsView = new DepositsView(rmiObject);
            depositsView.showMenu();
            break;
          case 3:
            WithdrawalsView withdrawalsView = new WithdrawalsView(rmiObject);
            withdrawalsView.showMenu();
            break;
          case 4:
            TransfersView TransfersView = new TransfersView(rmiObject);
            TransfersView.showMenu();
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
    sn.close();
  }
}