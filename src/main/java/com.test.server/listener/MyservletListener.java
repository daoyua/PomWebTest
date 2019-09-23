package com.test.server.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * application servletcontext
 * session httpsession  request httpservletrequest
 *
 *  *
 * */

public class MyservletListener implements ServletContextListener {
//    启动服务器
    //一般用于项目初始化操作
    //执行自定义任务调度，执行某个任务
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("创建了MyservletListener");
    }
//销毁服务器
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("销毁了MyservletListener");
    }
}
