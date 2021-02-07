
package com.team5.server;

import java.io.File;

import com.team5.entities.Person;
import com.team5.entities.User;
import com.team5.entities.Account;
import com.team5.entities.Transaction;
import com.team5.entities.Deposit;
import com.team5.entities.Withdrawal;
import com.team5.entities.Transference;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
  
  static {
    try {
      Configuration cfg = new Configuration().configure()
        .addAnnotatedClass(Person.class)
        .addAnnotatedClass(User.class)
        .addAnnotatedClass(Account.class)
        .addAnnotatedClass(Transaction.class)
        .addAnnotatedClass(Deposit.class)
        .addAnnotatedClass(Withdrawal.class)
        .addAnnotatedClass(Transference.class)
      ;
      
      sessionFactory = cfg.buildSessionFactory();
    } catch (Throwable ex) {
      ex.printStackTrace();
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }
  
  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
  
  public static void shutdown() {
    getSessionFactory().close();
  }
}