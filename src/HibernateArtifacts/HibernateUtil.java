package HibernateArtifacts;

import DAO.SinhVienAccountDAO;
import POJOs.Classroom;
import POJOs.SinhVienAccount;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Properties;


public class HibernateUtil {
    private static SessionFactory sessionFactory ;
    static {
        try {
            //Configuration configuration = new Configuration();

             //Hibernate settings equivalent to hibernate.cfg.xml's properties
//            Properties settings = new Properties();
//            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
//            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/Hibernate?characterEncoding=UTF-8");
//            settings.put(Environment.USER, "hoang");
//            settings.put(Environment.PASS, "laptrinhjava");
//            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//
//            settings.put(Environment.SHOW_SQL, "true");
//
//            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
//            settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//
//            configuration.setProperties(settings);
//
//            configuration.addAnnotatedClass(Classroom.class);
//
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

      //      sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            try {
                Configuration configuration = new Configuration();
                sessionFactory = configuration.configure().buildSessionFactory();
            } catch (Throwable ex) {
                ex.printStackTrace();
            }

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}