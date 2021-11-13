
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
                    +request.getContextPath()+"/";
%>
<html>
<head>
    <title>转发重定向</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>

</head>
<body>
<%--    <a href="doForward.do">发起doForward.do的请求</a><br/>--%>
    <a href="/doForward.do">发起doForward.do的请求</a><br/>
    <br/>
    <br/>
    <p>重定向redirect</p>
    <form action="doRedirect.do" method="post">
        姓名<input type="text" name="name"><br/>
        年龄<input type="text" name="age"><br/>
        操作<input type="submit" value="提交"><br/>
    </form>

</body>
</html>
