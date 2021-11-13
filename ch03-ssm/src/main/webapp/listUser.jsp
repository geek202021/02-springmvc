<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
            request.getContextPath()+"/";
%>
<html>
<head>
    <title>浏览学生</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            //在页面加载后，执行ajax,获取数据
            getUserInfo();
            $("#doAjax").click(function () {
                getUserInfo();
            });
        });

        function getUserInfo() {
            $.ajax({
                url:"user/queryUsers.do",
                dataType:"json",
                success: function (resp) {
                    //resp = XMLHttpRequest.responseText;
                    //alert("resp=" + resp);
                    $("#userInfo").empty();
                    $.each(resp,function (i,n){
                        $("#userInfo").append("<tr><td>"+n.id+
                            "</td><td>"+n.name+"</td><td>"
                            +n.password+"</td></tr>");
                    })
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <p>浏览学生 <button id="doAjax">获取学生数据</button></p>
        <table>
            <thead>
                <tr>
                    <td>id</td>
                    <td>姓名</td>
                    <td>密码</td>
                </tr>
            </thead>
            <tbody id="userInfo">

            </tbody>
        </table>
    </div>
</body>
</html>
