package com.team5.rmiinterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.team5.entities.Account;
import com.team5.server.OpenAccount;

public interface RMIObject extends Remote {
  public OpenAccount openAccount = new OpenAccount();

  public void deposit(Account account, float amount) throws RemoteException;

  public void withdrawal(Account account, float amount) throws RemoteException;

  public void tranference(Account origin, Account destiny, float amount) throws RemoteException;

}
