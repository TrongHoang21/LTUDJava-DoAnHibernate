package DAO;

import HibernateArtifacts.HibernateUtil;
import POJOs.Subject;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SubjectDAO {
    public static List<Subject> showListSubject() {
        List<Subject> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Subject";
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

    public static Subject searchSubject(String maSo) {
        Subject sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (Subject) session.get(Subject.class, maSo);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }

    public static boolean addSubject(Subject sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SubjectDAO.searchSubject(sv.getMaMonHoc())!=null) {
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

    public static boolean updateSubject(Subject sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SubjectDAO.searchSubject(sv.getMaMonHoc()) == null) {
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

    public static boolean deleteClassroom(String maMonHoc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Subject sv = SubjectDAO.searchSubject(maMonHoc);
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
