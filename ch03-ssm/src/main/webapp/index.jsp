<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<html>
<head>
    <title>SSM</title>
    <base href="<%=basePath%>"/>
</head>
<body>
    <div align="center">
        <p>SSM整合开发的例子</p>
        <table>
            <tr>
                <td><a href="addUser.jsp">注册用户</a></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><a href="listUser.jsp">查看用户</a></td>
            </tr>
        </table>
    </div>
</body>
</html>
