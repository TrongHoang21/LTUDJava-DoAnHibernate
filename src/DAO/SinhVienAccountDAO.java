package DAO;

import HibernateArtifacts.*;
import POJOs.SinhVienAccount;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class SinhVienAccountDAO {

    public static List<SinhVienAccount> layDanhSachSinhVien() {
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
}
