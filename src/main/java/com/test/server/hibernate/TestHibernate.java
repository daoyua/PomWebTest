package com.test.server.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;
    @BeforeAll
    public static void init(){
        //创建会话工厂
        sessionFactory = new Configuration().configure().buildSessionFactory();
//        sessionFactory = new Configuration().configure("ali_hibernate.cfg.xml").buildSessionFactory();
        // 开启会话
        session =sessionFactory.openSession();
        //开启事物
        transaction = session.beginTransaction();

    }
    // 测试结束
    @AfterAll
    public static void destory(){
        //关闭事物
        transaction.commit();
        //关闭对话
        session.close();
        // 关闭会话工厂
        sessionFactory.close();
    }
    @Test
   public void testHibernate(){
//     StuEntity stuEntity=new StuEntity();
//     stuEntity.setName("sbsbsbsbsbsb");
//     stuEnt ity.setSex("nan");
//     session.save(stuEntity);
//        CstCustomerEntity cstCustomerEntity=new CstCustomerEntity();
//        cstCustomerEntity.setCustName("CstCustomerEntityCstCustomerEntity");
//        session.save(cstCustomerEntity);

        Customer customer =new Customer();
        customer.setCust_name("bbbbbbb");
        session.save(customer);
   }
}
