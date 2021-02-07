package com.team5.server;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Service<Entity> {
  private Class<Entity> type;

  public Service(Class<Entity> type) { this.type = type; }

  public void insert(Entity entity){
    Transaction transaction = null;

    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      transaction = session.beginTransaction();

      session.save(entity);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }

  public List <Entity> getAll(){
    Transaction transaction = null;

    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      return session.createCriteria(this.type).list();
    
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw e;
    }
  }

  public Entity get(Integer id){
    Transaction transaction = null;

    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      return (Entity) session.load(this.type, id);

    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw e;
    }
  }

  public void update(Entity entity){
    Transaction transaction = null;

    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.update(entity);

    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw e;
    }

  }

  public void delete(Integer id){
    Transaction transaction = null;

    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Entity entity = this.get(id);
      session.delete(entity);

    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw e;
    }
  }


}