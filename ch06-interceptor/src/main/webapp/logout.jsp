<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出</title>
</head>
<body>
  退出系统！
  <%
    session.removeAttribute("username");
  %>
</body>
</html>
