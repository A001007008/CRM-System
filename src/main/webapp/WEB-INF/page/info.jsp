<%--
  Created by IntelliJ IDEA.
  User: my-deepin
  Date: 18-4-7
  Time: 下午9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<link rel="stylesheet" href="<%=basePath%>/lib/bootstrap.min.css"/>
<script src="<%=basePath%>/lib/jquery-3.3.1.min.js"></script>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    window.onload=function () {
        var time =2;
        var timer = setInterval(function(){
            time--;
            if(time==0){
                clearInterval(timer);
                location.href="<%=basePath%>/customer/toListPage";
            }

        },1000);
    }
</script>
<body>
<!-- 导航栏 -->
<div class="sidebar text-left">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand">SSM整合</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li><a href="<%=basePath%>/customer/toSavePage.do"><strong>添加信息功能</strong></a></li>
                    <li><a href="<%=basePath%>/customer/toListPage.do"><strong>分页查询功能</strong></a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<br/>
<br/>
<br/>
<h1 class="text-center">${message}</h1>


</body>
</html>
