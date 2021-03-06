package DAO;

import HibernateArtifacts.HibernateUtil;
import POJOs.Classroom;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClassroomDAO {

    public static List<Classroom> showListClassroom() {
        List<Classroom> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Classroom";
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

    public static Classroom searchClassroom(String maSo) {
        Classroom sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (Classroom) session.get(Classroom.class, maSo);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }

    public static boolean addClassroom(Classroom sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ClassroomDAO.searchClassroom(sv.getMaLop())!=null) {
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

    public static boolean updateClassroom(Classroom sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ClassroomDAO.searchClassroom(sv.getMaLop()) == null) {
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

    public static boolean deleteClassroom(String maLop) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Classroom sv = ClassroomDAO.searchClassroom(maLop);
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
