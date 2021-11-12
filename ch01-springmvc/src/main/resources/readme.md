## SpringMVC请求处理的过程
1.简单的处理过程：用户发起请求some.do--->Tomcat接收了请求---DispatcherServlet--分配MyController(doSome()返回mv对象)--mv显示给用户了。

2.用户发起some.do---DispatcherServlet(Servlet接收请求)---转给MyController


