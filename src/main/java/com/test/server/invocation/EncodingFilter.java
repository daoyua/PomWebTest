package com.test.server.invocation;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class EncodingFilter implements Filter {

    public EncodingFilter() {
    }

	public void destroy() {
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//��request����ת��ΪHttpServletRequest
		final HttpServletRequest req=(HttpServletRequest)request;
		//��JDK���ڴ������ɴ������:��ǿ��req�����ϵ�getParameter(name);API
		HttpServletRequest myReq=(HttpServletRequest)Proxy.newProxyInstance(EncodingFilter.class.getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				Object obj=null;
				
				if(method.getName().equalsIgnoreCase("getParameter")){
					//��ȡ��������ʽ
					String md=req.getMethod();
					if("get".equalsIgnoreCase(md)){
						//get��ʽ������
						//����req�����ϵ�getParameter����
						String v=(String)method.invoke(req, args);
						//ת��
						String vv=new String(v.getBytes("iso-8859-1"),"utf-8");
						return vv;
						
					}else{
						//post��ʽ������
						req.setCharacterEncoding("utf-8");
						obj=method.invoke(req, args);
					}
					
					
				}else{
					obj=method.invoke(req, args);
				}
				return obj;
			}
		});
		//��ӡ��������ϣ��
		System.out.println(myReq.hashCode());
		//������������
		chain.doFilter(myReq, response);
	}



}
