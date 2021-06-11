package DAO;

import HibernateArtifacts.*;
import POJOs.SinhVienAccount;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SinhVienAccountDAO {

    public static List<SinhVienAccount> showListSinhVien() {
        List<SinhVienAccount> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SinhVienAccount";
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

    public static SinhVienAccount searchSinhVien(String maSinhVien) {
        SinhVienAccount sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (SinhVienAccount) session.get(SinhVienAccount.class, maSinhVien);
        } catch (HibernateException ex) {
        //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }

    public static boolean addSinhVien(SinhVienAccount sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SinhVienAccountDAO.searchSinhVien(sv.getMaSinhVien())!=null) {
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

    public static boolean updateSinhVien(SinhVienAccount sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SinhVienAccountDAO.searchSinhVien(sv.getMaSinhVien()) == null) {
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

    public static boolean deleteSinhVien(String maSinhVien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        SinhVienAccount sv = SinhVienAccountDAO.searchSinhVien(maSinhVien);
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
