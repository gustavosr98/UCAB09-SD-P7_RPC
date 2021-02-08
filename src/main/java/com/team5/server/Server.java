package com.team5.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.team5.rmiinterfaces.RMIObject;

public class Server {
  public static void main(String[] args) throws Exception {
    try {
      RMIObjectImpl comp = new RMIObjectImpl();
      RMIObject stub = (RMIObject) UnicastRemoteObject.exportObject(comp, 0);
      Registry registry = LocateRegistry.getRegistry();
      registry.rebind("RMIObject", stub);

      printRunningMessage();
      new Server().hold();
    } catch (RemoteException ex) {
      ex.printStackTrace();
    }
  }

  private static void printRunningMessage() {
    System.out.println("\n\n\n");
    System.out.println("***********************************");
    System.out.println("\t SERVER IS RUNNING");
    System.out.println("***********************************");
    System.out.println("\n\n\n");
  }

  synchronized void hold() throws InterruptedException {
    wait();
  }
}
