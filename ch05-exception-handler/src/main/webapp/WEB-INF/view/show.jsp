<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>show-jsp</title>
</head>
<body>
  WEB-INF/view/show.jsp,显示request作用域中的数据<br/>
    <h3>myName数据：${myName}</h3>
    <h3>myAge数据：${myAge}</h3>
  原本应该去second.jsp页面，此时preHandler返回为true,
  拦截器MyInterceptor中的postHandle方法执行，对请求做二次处理：
    <h3>myDate数据：${myDate}</h3>
</body>
</html>
