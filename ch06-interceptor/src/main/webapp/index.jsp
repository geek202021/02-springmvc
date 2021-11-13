
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
                    +request.getContextPath()+"/";
%>
<html>
<head>
    <title>异常处理&拦截器</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>

</head>
<body>
    <p>异常处理</p>
    <form action="some.do" method="post">
        姓名<input type="text" name="name"><br/>
        年龄<input type="text" name="age"><br/>
        操作<input type="submit" value="提交"><br/>
    </form>
    <hr/>
    <p>拦截器</p>
    <form action="second.do" method="post">
        姓名<input type="text" name="name"><br/>
        年龄<input type="text" name="age"><br/>
        操作<input type="submit" value="提交"><br/>
    </form>
</body>
</html>
