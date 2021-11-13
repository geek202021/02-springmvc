<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>second</title>
</head>
<body>
    webapp/second.jsp,显示重定向后request作用域中的数据<br/>
    <h3>myName数据：${myName}</h3>
    <h3>myAge数据：${myAge}</h3>
    重定向后的request变了，不再是第一次请求时的request域：
    http://localhost:8080/ch04_forward_redirect/second.jsp?myName=Sisyphus&myAge=34
    <h3>myName数据：${param.myName}</h3>
    <h3>获取get请求中的参数myName = <%=request.getParameter("myName")%></h3>
    <h3>获取get请求中的参数myAge = <%=request.getParameter("myAge")%></h3>
</body>
</html>
