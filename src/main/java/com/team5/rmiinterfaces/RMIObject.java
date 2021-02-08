package com.team5.rmiinterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.team5.server.OpenAccount;

public interface RMIObject extends Remote {
  public OpenAccount openAccount = new OpenAccount();
}
