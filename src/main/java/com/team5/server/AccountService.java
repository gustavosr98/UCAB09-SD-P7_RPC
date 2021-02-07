package com.team5.server;

import com.team5.entities.Account;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class AccountService {
    private Class<Account> type;

    public List<Account> getByUserDocumentId(int userId) throws Exception {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria cr = session.createCriteria(Account.class);
            cr.add(Restrictions.eq("fk_user", userId));
            return (Account) cr.list();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

}