package DAO;

import HibernateArtifacts.HibernateUtil;
import POJOs.Classroom;
import POJOs.SinhVienAccount;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

public class ClassroomDAO {

    public static List<Classroom> layDanhSachLop() {
        List<Classroom> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select c from Classroom c";
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
}
