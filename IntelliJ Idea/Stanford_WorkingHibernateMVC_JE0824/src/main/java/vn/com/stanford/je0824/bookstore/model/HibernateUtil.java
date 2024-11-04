package vn.com.stanford.je0824.bookstore.model;

import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    /**
     * Hàm tạo đối tượng kết nối trong Hibernate
     * @return
     */
    private static SessionFactory buildSessionFactory() {
        Configuration config = new Configuration();

        config.configure();

        return config.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory()
    {
        if(sessionFactory == null)
        {
            sessionFactory = buildSessionFactory();
        }

        return sessionFactory;
    }
}