package com.team5.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.team5.rmiinterfaces.RMIObject;

import org.graalvm.compiler.hotspot.amd64.AMD64HotSpotAddressLowering;

import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry();
      RMIObject rmiObject = (RMIObject) registry.lookup("RMIObject");
      welcomeMenu(rmiObject);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void welcomeMenu(RMIObject rmiObject) {
    OpenAccount openAccount = new OpenAccount(rmiObject);
    Scanner sn = new Scanner(System.in);
    boolean out = false;
    int option;

    while (!out) {
      System.out.println("\n\n");
      System.out.println("***********************************");
      System.out.println("\t Selecciona una opción: ");
      System.out.println("\t 1. Abrir cuenta");
      System.out.println("\t 2. Realizar transacción");
      System.out.println("\t 3. Salir");
      System.out.println("***********************************");
      System.out.println("\n");

      try {
        option = sn.nextInt();

          switch(option){
              case 1:
                  openAccount.readDocumentId();
                  break;
              case 2:
                TransactionsView transactionsView = new TransactionsView(rmiObject);
                transactionsView.showMenu();
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

      } catch (Exception e) {
        System.out.println("Debes insertar un número");
        sn.next();
      }
    }
    sn.close();
  }
}
