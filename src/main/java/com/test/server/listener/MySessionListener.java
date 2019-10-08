package com.test.server.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session
 *
 * http不会
 * jsp会
 * servlet会
 * 一般用于统计在线人数
 */
public class MySessionListener implements HttpSessionListener {
//    getsession（）时候创建  jsp自带
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }
//超时30分钟，正常关闭服务器
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
