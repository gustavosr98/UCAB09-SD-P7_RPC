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
      //System.out.println( "The return value from the server is: " + comp.saluda() );
    } catch (Exception e) {
      System.err.println( "Exception while trying to echo:" );
      e.printStackTrace();
    }
  }

  private static void printRunningMessage(){
    System.out.println("\n\n\n");
    System.out.println("***********************************");
    System.out.println("\t CLIENT IS RUNNING");
    System.out.println("***********************************");
    System.out.println("\n\n\n");
  }

  private static void welcomeMenu(RMIObject rmiObject) {
    OpenAccount openAccount = new OpenAccount();
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
            option = sn.nextInt();

            switch(option){
                case 1:
                    openAccount.readDocumentId(rmiObject);
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
