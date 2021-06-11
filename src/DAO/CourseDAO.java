package DAO;

import HibernateArtifacts.HibernateUtil;
import POJOs.Course;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDAO {
    public static List<Course> showListCourse() {
        List<Course> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select c from Course c";
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

    public static Course searchCourse(String maSinhVien) {
        Course sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (Course) session.get(Course.class, maSinhVien);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }

    public static boolean addCourse(Course sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (CourseDAO.searchCourse(sv.getMaCourse())!=null) {
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

    public static boolean updateCourse(Course sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (CourseDAO.searchCourse(sv.getMaCourse()) == null) {
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

    public static boolean deleteCourse(String maCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Course sv = CourseDAO.searchCourse(maCourse);
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