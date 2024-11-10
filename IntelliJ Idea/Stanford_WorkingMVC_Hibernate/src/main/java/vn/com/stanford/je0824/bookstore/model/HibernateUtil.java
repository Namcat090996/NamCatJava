package vn.com.stanford.je0824.bookstore.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        Configuration config = new Configuration();

        config.configure();

        return config.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null)
        {
            sessionFactory = buildSessionFactory();
        }

        return sessionFactory;
    }
}
