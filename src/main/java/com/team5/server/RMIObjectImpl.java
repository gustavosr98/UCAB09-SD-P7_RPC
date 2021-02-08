package com.team5.server;

import java.rmi.RemoteException;

import com.team5.entities.Account;
import com.team5.entities.Transaction;
import com.team5.rmiinterfaces.RMIObject;

import com.team5.entities.UserBank;
import com.team5.entities.Account;

import java.util.List;

public class RMIObjectImpl implements RMIObject {
  private Service<Transaction> transactionService;

  public RMIObjectImpl() {
    transactionService = new Service<Transaction>(Transaction.class);
  }

  public void remoteTransfer(Account origin, Account destiny, float amount) throws RemoteException {
    if (origin == null) {
      this.withdraw(destiny, amount);
    } else if (destiny == null) {
      this.deposit(origin, amount);
    } else {
      this.transfer(origin, destiny, amount);
    }
  }

  private void deposit(Account account, float amount) throws RemoteException {
    try {
      Transaction dep = Transaction.createDeposit(amount, "Deposit", account);
      transactionService.insert(dep);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RemoteException();
    }
  }

  private void withdraw(Account account, float amount) throws RemoteException {
    if (account.getCurrentBalance() < amount)
      throw new RemoteException();

    try {
      Transaction withd = Transaction.createWithdraw(amount, "Withdrawal", account);
      transactionService.insert(withd);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RemoteException();
    }
  }

  private void transfer(Account origin, Account destiny, float amount) throws RemoteException {
    if (origin.getCurrentBalance() < amount)
      throw new RemoteException();

    try {
      Transaction withd = Transaction.createTransfer(amount, "Transference", origin, destiny);
      transactionService.insert(withd);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RemoteException();
    }
  }
  
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
