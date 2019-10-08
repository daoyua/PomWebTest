package com.test.server.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

//不用注册
public class dunhua implements HttpSessionActivationListener , Serializable {
    //钝化
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("钝化");
    }

    //活化
    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("活化");
    }
}
