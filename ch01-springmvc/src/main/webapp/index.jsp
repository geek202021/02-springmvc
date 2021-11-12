
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一个SpringMVC</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btnAjax").click(function () {
                $.ajax({
                    // url:"test/return-void-ajax.do",
                    // url:"test/doStudentJson.do",
                    // url:"test/doListJsonArray.do",
                    url:"test/doStringData.do",
                    data:{
                        name:"lisi",
                        age:20
                    },
                    // dataType:"json",
                    dataType:"text",
                    success:function (resp) {
                        //resp = XMLHttpRequest.responseText;
                        // alert("resp==" + resp.name + "==" + resp.age);
                        // $.each(resp, function (i,n) {
                        //     //i是变量，n是成员{"name":李四同学,"age":30}
                        //     alert("n name=" + n.name + "===age=" + n.age);
                        // });
                        alert("resp==" + resp);
                    }
                })
            });
        });
    </script>
</head>
<body>
    <a href="test/some.do">发起test/some.do的请求</a><br/>
    <a href="test/second.do">发起test/second.do的请求</a><br/>
    <p>逐个接收请求参数，请求参数名和形参名一样</p>
    <form action="test/third.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <br/>
    <p>控制器方法返回String，表示逻辑名称</p>
    <form action="test/fourth.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <br/>
    <button id="btnAjax">发起ajax请求</button>
</body>
</html>
