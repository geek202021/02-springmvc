
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName()
            +":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <title>ch02-url-pattern</title>
    <base href="<%=basePath%>"/>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
</head>
<body>
    <p>中央调度器：url-pattern使用/斜杠</p>
<%--    <form action="some.do" method="post">--%>
    <form action="some" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <img src="images/monkey.jpg" alt="猴子.jpg"/>

</body>
</html>
