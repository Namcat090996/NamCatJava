package vn.com.stanford.stanford_bookstore_sb_je0824.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    /**
     * Hàm tạo đối tượng kết noi trong Hibernate
     * @return
     */
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
