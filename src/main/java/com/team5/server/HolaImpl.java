package com.team5.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.team5.rmiinterfaces.Hola;

public class HolaImpl implements Hola {
  @Override
  public String saluda() throws RemoteException {
    return "Hola a todos";
  }
}
