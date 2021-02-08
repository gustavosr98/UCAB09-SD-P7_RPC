package com.team5.server;

import java.rmi.RemoteException;

import com.team5.entities.Account;
import com.team5.entities.Transaction;
import com.team5.rmiinterfaces.RMIObject;

public class RMIObjectImpl implements RMIObject {
  public OpenAccount openAccount;

  public RMIObjectImpl() {
      //this.openAccount = new OpenAccount();
  }

  public void transference(Account origin, Account destiny, float amount) throws RemoteException {
    // TODO Auto-generated method stub
    if(origin == null){
      this.withdraw(destiny, amount);
    } else if (destiny == null){
      this.deposit(origin, amount);
    } else {
      this.transfer(origin, destiny, amount);
    }

  }

  public void deposit(Account account, float amount) throws RemoteException{
    
    try {
      Transaction dep = Transaction.createDeposit(amount,"Deposit", account);
      Service <Transaction> transactionService = new Service<Transaction>(Transaction.class);
      transactionService.insert(dep);

    } catch (Exception e) {
      e.printStackTrace();
      throw new RemoteException();
    }

  }

  public void withdraw(Account account, float amount) throws RemoteException {

    if (account.getCurrentBalance() < amount) throw new RemoteException();

    try {
      Transaction withd = Transaction.createWithdraw(amount,"Withdrawal", account);
      Service <Transaction> transactionService = new Service<Transaction>(Transaction.class);
      transactionService.insert(withd);

    } catch (Exception e) {
      e.printStackTrace();
      throw new RemoteException();
    }

  }

  public void transfer(Account origin, Account destiny, float amount) throws RemoteException{
    if (origin.getCurrentBalance() < amount) throw new RemoteException();

    try {
      Transaction withd = Transaction.createTransfer(amount,"Transference", origin, destiny);
      Service <Transaction> transactionService = new Service<Transaction>(Transaction.class);
      transactionService.insert(withd);

    } catch (Exception e) {
      e.printStackTrace();
      throw new RemoteException();
    }
  }

  


}
