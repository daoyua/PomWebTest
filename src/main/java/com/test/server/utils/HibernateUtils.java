package com.test.server.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
public static final Configuration configuration;
    public static   SessionFactory sessionFactory;
    static {
        configuration =new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();

    }
    public static Session OpenSession(){
      return   sessionFactory.openSession();
    }
}
