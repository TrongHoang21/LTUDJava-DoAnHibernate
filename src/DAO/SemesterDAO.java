package DAO;

import HibernateArtifacts.HibernateUtil;
import POJOs.Semester;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SemesterDAO {
    public static List<Semester> showListSemester() {
        List<Semester> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Semester";
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

    public static Semester searchSemester(String maHocKi) {
        Semester sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (Semester) session.get(Semester.class, maHocKi);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }

    public static boolean addSemester(Semester sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SemesterDAO.searchSemester(sv.getMaHocKi())!=null) {
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

    public static boolean updateSemester(Semester sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SemesterDAO.searchSemester(sv.getMaHocKi()) == null) {
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

    public static boolean deleteSemester(String maHocKi) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Semester sv = SemesterDAO.searchSemester(maHocKi);
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
