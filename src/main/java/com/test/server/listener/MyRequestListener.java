package com.test.server.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * request
 * 访问任何服务器
 *
 *  * http不会
 *  * jsp会
 *  * servlet会
 */
public class MyRequestListener implements ServletRequestListener {
    //访问任何服务器
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("创建了MyRequestListener");
    }

    //服务器对这次请求做出了回应
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("销毁了MyRequestListener");
    }
}
