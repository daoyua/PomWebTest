<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2019/9/19
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function ajaxFunction() {
            var xmlHttp;
            try { // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e) {
                try {// Internet Explorer
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                    }
                }
            }

            return xmlHttp;
        }

        //执行请求
        function get() {
            var ajax = ajaxFunction();
            ajax.open("GET", "t?name==aa&age=18", true);

            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4 && ajax.status == 200) {
                    alert(ajax.responseText)
                }
            }

            ajax.send();

        }
        //执行请求
        function post() {
            var ajax = ajaxFunction();
            ajax.open("POST", "t", true);
            ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded")
            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4 && ajax.status == 200) {
                    alert(ajax.responseText)
                }
            }

            ajax.send("name==zz&age=19");

        }
    </script>
</head>

<body>
<h3><a href="" onclick="get()">使用ajax方式发送get请求</a></h3><br>

<h3><a href="" onclick="post()">使用ajax方式发送post请求</a></h3>
</body>
</html>
