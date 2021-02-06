package com.team5.server;

import org.hibernate.SessionFactory;

public class Server {
  public static void main( String[] args ){
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    printRunningMessage();
  }

  private static void printRunningMessage(){
    System.out.println("\n\n\n");
    System.out.println("***********************************");
    System.out.println("\t SERVER IS RUNNING");
    System.out.println("***********************************");
    System.out.println("\n\n\n");
  }
}
