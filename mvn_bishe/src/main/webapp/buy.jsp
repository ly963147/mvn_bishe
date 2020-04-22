<%@ page import="org.hc.cart.Cart" %>
<%@ page import="org.hc.cart.CartItem" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/19
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/buy.js"></script>
<body>
<div class="box">
    <%
        String name = (String)session.getAttribute("uname");
    %>
    <div class="top">
        <div id="topleft"></div>
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
            欢迎<font color="red"> <%=name%></font>进入 【<span>网上书城</span>】
        </marquee>
    </div>
    <div id="buy"><center>
        <table width="400" cellspacing="0" height="120">
            <thead align="center">
            <tr>
                <td>书籍名称</td>
                <td>单价</td>
                <td>购买数量</td>
                <td>总价</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody align="center">
            <form action="changNum.jsp" method="post" name="frm1">
                <%
                    Cart cart= (Cart) session.getAttribute("cart");
                    for (CartItem car:
                            cart.getItems().values()) {
                %>
                <tr>
                    <td><%=car.getBookinfo().getBookName()%></td>
                    <td><%=car.getBookinfo().getBookPrice()%></td>
                    <td>
                        <input type="hidden" name="foodid" value="<%=car.getBookinfo().getBookId()%>"  />
                        <img src="images/jian.gif" onclick="jian(<%=car.getBookinfo().getBookId()%>,this)">
                        <input type="text" size="1" name="num" value="<%=car.getNum()%>" onblur="changeNum(<%=car.getBookinfo().getBookId()%>,this)" id="amount"/>
                        <img src="images/jia.gif" onclick="jia(<%=car.getBookinfo().getBookId()%>,this)">
                    </td>
                    <td><%=car.getNum()*car.getBookinfo().getBookPrice()%></td>
                    <td><a href="javascript:del(<%=car.getBookinfo().getBookId()%>)">删除</a></td>
                </tr>
                <%}%>
            </form>
            <tr  align="left">
                <td colspan="5">您的账单：选择了<%=cart.getItems().size()%>本书，共需支付<%=cart.getTotalmoney()%>元。<br /></td>
            </tr>
            <tr>
                <td colspan="5">
                    <input type="button" value="继续选购" onclick="location.href='bookAll'" />

                    <input type="button" value="清空购物车" onclick="location.href='clear.html'">		<input type="button" value="付款" onclick="location.href='pay.html?count=1'" />

                </td>
            </tr>
            </tbody>
        </table></center><br />
    </div>
    <div class="foot">
        <p class="myp"> 感谢使用 </p>
    </div>
</div>
</body>
</html>
