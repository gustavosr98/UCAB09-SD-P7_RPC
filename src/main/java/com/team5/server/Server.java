package com.team5.server;

import com.team5.entities.Person;

public class Server {
  public static void main( String[] args ) throws Exception {
    printRunningMessage();
    Service <Person> userService = new Service<Person>(Person.class);
    Person personToInsert = new Person("Gustavo Sanchez", "Tato");

    // INSERT
    userService.insert(personToInsert);
    // GET
    Person personToGet = userService.get(personToInsert.getId());

    System.out.println(personToInsert.getName()); 
    System.out.println(personToGet.getName()); 

    printRunningMessage();

    UserBankService userBankService = new UserBankService();
    userBankService.getUserByDocumentId("hola");
  }

  private static void printRunningMessage(){
    System.out.println("\n\n\n");
    System.out.println("***********************************");
    System.out.println("\t SERVER IS RUNNING");
    System.out.println("***********************************");
    System.out.println("\n\n\n");
  }
}
