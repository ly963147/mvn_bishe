<%@ page import="org.hc.pojo.Bookinfo" %>
<%@ page import="org.hc.pojo.Dianping" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/19
  Time: 14:26
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
        String name = (String)session.getAttribute("uname");
    %>
    <div class="top">
        <div id="topleft">网上书城</div>
        <div id="topright"> 当前用户：
            <font color="red"><%=name%></font> | 用户等级：普通用户 |
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
            <marquee behavior="alternate">欢迎<font color="red"><%=name%></font>进入 【<span>网上书城</span>】</marquee>
        </marquee>
    </div>


    <div class="info">
        <form action="bookinfo" method="post" id="frm" onsubmit="return checkfrm(this)">
            <%
                Bookinfo bookinfo=(Bookinfo) request.getAttribute("bookinfo");
            %>
            <div id="img"><img src="images/<%=bookinfo.getBookImage() %>" width="300" height="200" class="img-thumbnail" style="border:8px #EF7000 solid;border-radius:10%;" /></div>
            <div id="info">
                <h3><%=bookinfo.getBookName() %></h3>
                <p style="color:#EF7000;">--------------------------------------------------------------------</p>
                <b>价格：<span style="font-size:30px;font-weight: bold;"><%=bookinfo.getBookPrice() %>元</span></b>
                <a href="addbuy.action?id=<%=bookinfo.getBookId() %>"><img src="images/buy_cn.gif" /></a>
                <br /><br />
                <b>简介：<%=bookinfo.getRemark() %></b>
                <br /><br />
                <b>作者：<%=bookinfo.getAuthor() %></b>
                <a href="yulan?id=<%=bookinfo.getBookId() %>"><input type="button" value="阅览" class="btn" /></a>
            </div>
        </form>
        <div id="dp">
            <p style="color:#EF7000;">------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
            <table width="100%" class="table table-striped">
                <form action="bookinfo" method="post" onsubmit="return checkfrm(this)">
                <thead>
                <tr bgcolor="#EF7000">
                    <th>点评</th>
                    <th>点评内容</th>
                    <th>点评人</th>
                    <th>点评日期</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Dianping> list = (List<Dianping>) request.getAttribute("list");
                    for (Dianping dianping:
                            list ) {
                %>
                <tr align="center">
                    <td><%=dianping.getPinjia() %></td>
                    <td><%=dianping.getDpcontent() %></td>
                    <td><%=dianping.getUserId() %></td>
                    <td><%=dianping.getDpdate() %></td>
                </tr>
                <%}%>
                </tbody>
                </form>
            </table>
        </div>
    </div>
    <div class="foot">
        <p class="myp"> 感谢使用 </p>
    </div>
</div>
</body>
</html>
