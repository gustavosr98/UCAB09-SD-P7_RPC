package com.team5.server;

import java.rmi.RemoteException;

import com.team5.rmiinterfaces.RMIObject;

import com.team5.entities.UserBank;
import com.team5.entities.Account;

import java.util.List;

public class RMIObjectImpl implements RMIObject {
  
  public UserBank findUserById(int id) throws RemoteException, Exception {
    try {
      UserBankService userBankService = new UserBankService();  
      UserBank userBank = userBankService.getById(id);
      return userBank;
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public boolean existUser(int id) throws RemoteException, Exception {
    try {
      UserBankService userBankService = new UserBankService();  
      UserBank userBank = userBankService.getById(id);
      if (userBank == null) {
        return false;
      } else {
        return true;
      }
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public int createUser(int id, String name, String username, String password) throws RemoteException, Exception {
    try {
      UserBank userBankToInsert = new UserBank(id, name, username, password);
      Service <UserBank> userService = new Service<UserBank>(UserBank.class);
      return userService.insert(userBankToInsert);
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public UserBank findUserByUserName(String username) throws RemoteException, Exception {
    try {
      UserBankService userBankService = new UserBankService();  
      UserBank userBank = userBankService.getByUserName(username);
      return userBank;
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public int findAccounts(int userId) throws RemoteException, Exception {
    try {
      AccountService accountService = new AccountService();  
      List<Object> accounts = accountService.getByUserId(userId);
      return accounts.size();
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public boolean validateUser(int userBankId, String username, String password) throws RemoteException, Exception {
    try {
      UserBank userBank = this.findUserById(userBankId);
      if (username.equals(userBank.getUsername()) && password.equals(userBank.getPassword())) {
          return true;
      } else {
          return false;
      }
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public int createAccount(float currentBalance, int userBankId) throws RemoteException, Exception {
    try {
      UserBank userBank = this.findUserById(userBankId);
      Account accountToInsert = new Account(currentBalance, userBank);
      Service <Account> accountService = new Service<Account>(Account.class);
      return accountService.insert(accountToInsert);
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}
