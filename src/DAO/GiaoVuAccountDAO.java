package DAO;

import HibernateArtifacts.HibernateUtil;
import POJOs.GiaoVuAccount;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;



public class GiaoVuAccountDAO  {

    public static List<GiaoVuAccount> showListGiaoVu() {
        List<GiaoVuAccount> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from GiaoVuAccount";
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

    public static GiaoVuAccount searchGiaoVu(String maSo) {
        GiaoVuAccount sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (GiaoVuAccount) session.get(GiaoVuAccount.class, maSo);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }

    public static boolean addGiaoVu(GiaoVuAccount sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (GiaoVuAccountDAO.searchGiaoVu(sv.getMaSo())!=null) {
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

    public static boolean updateGiaoVu(GiaoVuAccount sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (GiaoVuAccountDAO.searchGiaoVu(sv.getMaSo()) == null) {
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

    public static boolean deleteGiaoVu(String maSo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        GiaoVuAccount sv = GiaoVuAccountDAO.searchGiaoVu(maSo);
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
