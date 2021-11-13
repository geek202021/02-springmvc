
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
                    +request.getContextPath()+"/";
%>
<html>
<head>
    <title>拦截器</title>
    <base href="<%=basePath%>">

</head>
<body>
    <p>拦截器</p>
    <form action="show.do" method="post">
        姓名<input type="text" name="name"><br/>
        年龄<input type="text" name="age"><br/>
        操作<input type="submit" value="提交"><br/>
    </form>
</body>
</html>
