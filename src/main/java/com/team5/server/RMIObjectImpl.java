package com.team5.server;

import java.rmi.RemoteException;

import com.team5.entities.Account;
import com.team5.entities.Transaction;
import com.team5.rmiinterfaces.RMIObject;

public class RMIObjectImpl implements RMIObject {
  public OpenAccount openAccount;
  private Service<Transaction> transactionService;

  public RMIObjectImpl() {
    // this.openAccount = new OpenAccount();
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
}
