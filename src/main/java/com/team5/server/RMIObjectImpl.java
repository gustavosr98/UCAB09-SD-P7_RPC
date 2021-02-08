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
  
  public void withdrawal(Account account, float amount) throws RemoteException {
    // TODO Auto-generated method stub

  }

  public void tranference(Account origin, Account destiny, float amount) throws RemoteException {
    // TODO Auto-generated method stub

  }


}
