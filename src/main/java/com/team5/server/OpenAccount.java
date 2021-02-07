package com.team5.server;

import com.team5.entities.UserBank;
import com.team5.entities.Account;

import java.util.List;

public class OpenAccount {
  
  public UserBank findUserByDocumentId(int documentId) throws Exception {
    try {
      Service <UserBank> userBankService = new Service<UserBank>(UserBank.class);
      return userBankService.get(documentId);
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public int createUser(String name, String username, String password) throws Exception {
    try {
      UserBank userBankToInsert = new UserBank(name, username, password);
      Service <UserBank> userService = new Service<UserBank>(UserBank.class);
      return userService.insert(userBankToInsert);
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public UserBank findUserByUserName(String username) throws Exception {
    try {
      UserBankService userBankService = new UserBankService();  
      UserBank userBank = userBankService.getByUserName(username);
      return userBank;
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public int findAccounts(int userId) throws Exception {
    try {
      AccountService accountService = new AccountService();  
      List<Account> accounts = accountService.getByUserId(userId);
      return accounts.size();
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public int createAccount(float currentBalance, UserBank userBank) throws Exception {
    try {
      Account accountToInsert = new Account(currentBalance, userBank);
      Service <Account> accountService = new Service<Account>(Account.class);
      return accountService.insert(accountToInsert);
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}
