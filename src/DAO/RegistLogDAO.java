package DAO;

import HibernateArtifacts.HibernateUtil;
import POJOs.RegistLog;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegistLogDAO {
    public static List<RegistLog> showListSubject() {
        List<RegistLog> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from RegistLog";
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

    public static RegistLog searchRegistLog(String maSinhVien) {
        RegistLog sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (RegistLog) session.get(RegistLog.class, maSinhVien);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }

    public static boolean addSRegistLog(RegistLog sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (RegistLogDAO.searchRegistLog(sv.getMaSinhVien())!=null) {
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

    public static boolean updateRegistLog(RegistLog sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (RegistLogDAO.searchRegistLog(sv.getMaSinhVien()) == null) {
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

    public static boolean deleteRegistLog(String maSinhVien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        RegistLog sv = RegistLogDAO.searchRegistLog(maSinhVien);
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
