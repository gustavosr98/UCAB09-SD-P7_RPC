package com.team5.server;

import com.team5.entities.Account;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AccountService {
    private Class<Account> type;

    public List<Object> getByUserId(int userId) throws Exception {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.createSQLQuery("select ac.id, ac.current_balance, ac.fk_user from account ac where ac.fk_user=" + userId).list();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

}