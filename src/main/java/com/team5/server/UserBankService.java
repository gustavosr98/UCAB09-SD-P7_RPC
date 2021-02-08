package com.team5.server;

import com.team5.entities.UserBank;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class UserBankService {
    private Class<UserBank> type;

    public UserBank getById(Integer id) throws Exception {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria cr = session.createCriteria(UserBank.class);
            cr.add(Restrictions.eq("id", id));
            return (UserBank) cr.uniqueResult();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public UserBank getByUserName(String username) throws Exception {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria cr = session.createCriteria(UserBank.class);
            cr.add(Restrictions.eq("username", username));
            return (UserBank) cr.uniqueResult();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

}