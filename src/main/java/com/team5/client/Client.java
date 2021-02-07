package com.team5.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.team5.rmiinterfaces.Hola;

public class Client {
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry();
      Hola comp = (Hola) registry.lookup("Hola");
      System.out.println( "The return value from the server is: " + comp.saluda() );
    } catch (Exception e) {
      System.err.println( "Exception while trying to echo:" );
      e.printStackTrace();
    }
  }
}
