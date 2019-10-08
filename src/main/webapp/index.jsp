<%@ page import="com.test.server.listener.dunhua" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<%
    //测试监听
//session.setAttribute("name","aaa");
//session.setAttribute("name","bb");
//session.removeAttribute("name");

    dunhua dunhua =new dunhua();
    session.setAttribute("dunhua",dunhua);
%>
<h2>Hello World!</h2>
</body>
</html>
