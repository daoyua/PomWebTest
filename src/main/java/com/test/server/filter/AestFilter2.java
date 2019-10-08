package com.test.server.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AestFilter2" ,urlPatterns = "/*")
public class AestFilter2 implements Filter {
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("来到过滤器3");
        chain.doFilter(req, resp);//等同于放行
    }

    public void init(FilterConfig config) throws ServletException {

        System.out.println("过滤器3创建");
    }

}
