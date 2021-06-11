package DAO;

import HibernateArtifacts.HibernateUtil;
import POJOs.RegistSession;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegistSessionDAO {
    public static List<RegistSession> showListRegistSession() {
        List<RegistSession> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select c from RegistSession c";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.out.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public static RegistSession searchRegistSession(String maSesion) {
        RegistSession sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (RegistSession) session.get(RegistSession.class, maSesion);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }

    public static boolean addRegistSession(RegistSession sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (RegistSessionDAO.searchRegistSession(sv.getMaSession())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sv);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public static boolean updateRegistSession(RegistSession sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (RegistSessionDAO.searchRegistSession(sv.getMaSession()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(sv);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    public static boolean deleteRegistSession(String maSession) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        RegistSession sv = RegistSessionDAO.searchRegistSession(maSession);
        if(sv==null){
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(sv);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
