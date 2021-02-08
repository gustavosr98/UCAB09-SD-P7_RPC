package com.team5.rmiinterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.team5.entities.UserBank;
import com.team5.entities.Account;

public interface RMIObject extends Remote {
  public UserBank findUserById(int Id) throws RemoteException, Exception;

  public int createUser(String name, String username, String password) throws RemoteException, Exception;

  public UserBank findUserByUserName(String username) throws RemoteException, Exception;

  public int findAccounts(int userId) throws RemoteException, Exception;

  public boolean validateUser(int userBankId, String username, String password) throws RemoteException, Exception;

  public int createAccount(float currentBalance, int userBankId) throws RemoteException, Exception;
}
