package com.team5.server;

import com.team5.entities.UserBank;
import com.team5.entities.Account;

public class OpenAccount {
  
  public UserBank findUserByDocumentId(int documentId) throws Exception {
    try {
      UserBank accountToInsert = new UserBank(currentBalance, userBank);
      Service <UserBank> userBankService = new Service<UserBank>(UserBank.class);
      return userBankService.get(documentId);
    } catch(e) {
      e.printStackTrace();
      throw e;
    }
  }

  public UserBank createUser(String name, String username, String password) throws Exception {
    try {
      UserBank userBankToInsert = new UserBank(name, username, password);
      Service <UserBank> userService = new Service<UserBank>(UserBank.class);
      userService.insert(userBankToInsert);
      return userBankToInsert;
    } catch(e) {
      e.printStackTrace();
      throw e;
    }
  }

  public UserBank findUserByUserName(String username) throws Exception {
    try {
      UserBankService userBankService = new UserBankService();  
      UserBank userBank = userBankService.getByUserName(username);
      return userBank;
      //System.out.println(userBankService.getByUserName("test"));
      //System.out.println(userBankService.getByUserName("test").getName());
    } catch(e) {
      e.printStackTrace();
      throw e;
    }
  }

  public int findAccounts(int userId) throws Exception {
    try {
      AccountService accountService = new AccountService();  
      List<Account> accounts = accountService.getByUserId(userId);
      return accounts.size();
    } catch(e) {
      e.printStackTrace();
      throw e;
    }
  }

  public Account createAccount(float currentBalance, UserBank userBank) throws Exception {
    try {
      Account accountToInsert = new Account(currentBalance, userBank);
      Service <Account> accountService = new Service<Account>(Account.class);
      accountService.insert(accountToInsert);
      return accountToInsert;
    } catch(e) {
      e.printStackTrace();
      throw e;
    }
  }
}
