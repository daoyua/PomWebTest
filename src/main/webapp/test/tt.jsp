<%@ page import="com.test.server.listener.Student" %>
<%@ page import="com.test.server.listener.dunhua" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%
        Student student=new Student();
        session.setAttribute("name",student);
        session.removeAttribute("name");

        dunhua dunhua =new dunhua();
        dunhua dunhua1 = (com.test.server.listener.dunhua) session.getAttribute("dunhua");
    %>
</head>
<body>

</body>
</html>
