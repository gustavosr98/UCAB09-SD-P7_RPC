package com.team5.server;

import java.rmi.RemoteException;

import com.team5.rmiinterfaces.Hola;

public class HolaImpl implements Hola {
  public HolaImpl() {
  }

  public String saluda() throws RemoteException {
    return "Hola a todos";
  }
}
