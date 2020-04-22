<%@ page import="org.hc.pojo.Userinfo" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/14
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="box">
    <%
        Userinfo userinfo=(Userinfo) request.getAttribute("user");
    %>
    <div class="top">
        <div id="topleft"></div>
        <div id="topright"> 当前用户：
            <font color="red"><%=userinfo.getLoginName()%></font> | 用户等级：普通用户 |
            <a href="find">用户管理</a> |
            <a href="allbuy.action"><img src="images/buycar.jpg" /></a> |
            <a href="destroy">注销</a>
            <a href="login">登陆</a>
            <a href="zhuce.html">注册</a>
        </div>
    </div>
    <div class="menu"> |&nbsp;
        <a href="bookAll">网站首页</a> </div>
    <div class="welcome">
        <marquee behavior="alternate">
            欢迎<font color="red"> <%=userinfo.getLoginName()%></font>进入 【<span>网上书城</span>】
        </marquee>
    </div>
    <div class="userinfo">

        <br />
        <p style="color:blue;font-size:30px;" align="center">用户信息</p>
        <br />
        <table align="center" cellspacing="0" border="1" width="300" height="200">
            <form action="update" method="post" onsubmit="return checkfrm(this)">
            <tr>
                <td align="right">用户编号：</td>
                <td><input type="text" name="userid" readonly="readonly" value="<%=userinfo.getUserId()%>" /></td>
            </tr>
            <tr>
                <td align="right">用 户 名：</td>
                <td><input type="text" name="username" value="<%=userinfo.getLoginName()%>" /></td>
            </tr>
            <tr>
                <td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                <td><input type="text" name="password" value="<%=userinfo.getLoginPass()%>" /></td>
            </tr>
            <tr>
                <td align="right">真实姓名：</td>
                <td><input type="text" name="realname" value="<%=userinfo.getRealname()%>" /></td>
            </tr>
            <tr>
                <td align="right">身份证号：</td>
                <td><input type="text" name="identity" value="<%=userinfo.getIdentify()%>" /></td>
            </tr>
            <tr>
                <td align="right">联系方式：</td>
                <td><input type="text" name="phone" value="<%=userinfo.getPhone()%>" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="修改信息" />
                    <input type="button" value="取&nbsp;消" />
                </td>
            </tr>
            </form>
        </table><br />
    </div>

    <div class="foot">
        <p class="myp"> 感谢使用 </p>
    </div>
</div>
</body>
</html>
