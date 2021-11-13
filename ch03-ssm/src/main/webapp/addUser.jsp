<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                        request.getContextPath()+"/";
%>
<html>
<head>
    <title>添加</title>
    <base href="<%=basePath%>"
</head>
<body>
    <p>注册学生</p>
    <form action="user/addUser.do" method="post">
        <table>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="password"/></td>
            </tr>
            <tr>
                <td>操作：</td>
                <td><input type="submit" value="注册"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
