package com.team5.server;

import com.team5.entities.UserBank;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class UserBankService {
    private Class<UserBank> type;
    public void getUserByDocumentId(String documentId) throws Exception {
        Service <UserBank> userBankService = new Service<UserBank>(UserBank.class);

        UserBank userBank = get(documentId);

        System.out.println(userBank);
    }

    public UserBank get(String documentId) throws Exception {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Criteria cr = session.createCriteria(UserBank.class);
            cr.add(Restrictions.eq("document_id", documentId));
            return cr.uniqueResult();
            //Session session = HibernateUtil.getSessionFactory().openSession();
            //return (UserBank) session.load(this.type, documentId);

            //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            //Query query = session.createQuery("from user_bank where documen_id=:documentId");
            //query.setParameter("documentId", documentId);
            //return (UserBank) query.uniqueResult();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

}