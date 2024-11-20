package vn.com.stanford.je0824.bookstore.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    //Declare variables
    private static SessionFactory sessionFactory;

    //Function to build session factory from charged configuration
    private static SessionFactory buildSessionFactory() {

        //Declare configuration
        Configuration config = new Configuration();

        //Charge configuration from hibernate configuration file
        config.configure("hibernate.cfg.xml");

        //Return result
        return config.buildSessionFactory();
    }

    //Functon to get session factory (singleton)
    public static SessionFactory getSessionFactory()
    {
        //If session factory didn't exist before
        if(sessionFactory == null)
        {
            sessionFactory = buildSessionFactory();
        }

        //Return result
        return sessionFactory;
    }
}
