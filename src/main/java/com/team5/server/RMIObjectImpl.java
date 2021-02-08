package com.team5.server;

import java.rmi.RemoteException;

import com.team5.rmiinterfaces.RMIObject;

public class RMIObjectImpl implements RMIObject {
  public OpenAccount openAccount;

  public RMIObjectImpl() {
      //this.openAccount = new OpenAccount();
  }
}
