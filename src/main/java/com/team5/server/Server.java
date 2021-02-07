package com.team5.server;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.team5.entities.Person;
import com.team5.rmiinterfaces.Hola;


public class Server {
  
  public static void main( String[] args ) throws Exception, RemoteException, AlreadyBoundException {
    try {
      Remote comp = new HolaImpl();
      Registry registry = LocateRegistry.getRegistry();
      Hola stub = (Hola) UnicastRemoteObject.exportObject(comp, 1099);
      
      registry.rebind("objetoHola", stub);
    } catch (RemoteException ex) {
      ex.printStackTrace();
      return;
    }
    printRunningMessage();
  }

  private static void printRunningMessage(){
    System.out.println("\n\n\n");
    System.out.println("***********************************");
    System.out.println("\t SERVER IS RUNNING");
    System.out.println("***********************************");
    System.out.println("\n\n\n");
  }
}
