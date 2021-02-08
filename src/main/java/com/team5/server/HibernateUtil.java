
package com.team5.server;

import com.team5.entities.UserBank;
import com.team5.entities.Account;
import com.team5.entities.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;

  static {
    try {
      Configuration cfg = new Configuration().configure()
        .addAnnotatedClass(UserBank.class)
        .addAnnotatedClass(Account.class)
        .addAnnotatedClass(Transaction.class)
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