
package com.team5.server;

import java.io.File;

import com.team5.entities.Person;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
  
  static {
    try {
      Configuration cfg = new Configuration().configure()
        .addAnnotatedClass(Person.class)
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