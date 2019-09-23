<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<%
    //测试监听
session.setAttribute("name","aaa");
session.setAttribute("name","bb");
session.removeAttribute("name");
%>
<h2>Hello World!</h2>
</body>
</html>
