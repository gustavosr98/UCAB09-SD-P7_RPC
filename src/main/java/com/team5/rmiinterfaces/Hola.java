package com.team5.rmiinterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hola extends Remote {
  public String saluda() throws RemoteException;
}
