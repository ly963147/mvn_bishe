<%@ page import="org.hc.pojo.Userinfo" %>
<%@ page import="org.hc.pojo.Bookinfo" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/18
  Time: 20:40
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
        <div id="topleft"></div>
        <div id="topright"> 当前用户：
            <font color="red"><%=name%></font> | 用户等级：管理员 |
            <a href="destroy">注销</a>
        </div>
    </div>
    <div class="menu"> |&nbsp;
        <a href="Allbook">网站首页</a>&nbsp;|&nbsp;
        <a href="Allbooks">书籍列表</a>&nbsp;|&nbsp;
        <a href="addBook.jsp">添加新书</a>&nbsp;|&nbsp;
        <a href="userAll">用户列表</a>&nbsp;|&nbsp;
        <a href="dianpingall">点评列表</a>&nbsp;|&nbsp;</div>
    <div class="welcome">
        <marquee behavior="alternate">欢迎<font color="red"><%=name%></font>进入 【<span>网上书城</span>】</marquee>
    </div>
    <div class="userinfo">
        <%
           Bookinfo bookinfo=(Bookinfo) request.getAttribute("book");
        %>
        <br />
        <p style="color:blue;font-size:30px;" align="center">书籍信息</p>
        <br />
        <table align="center" cellspacing="0" border="1" width="300" height="200">
            <form action="updatebook" method="post" onsubmit="return checkfrm(this)">
                <tr>
                    <td align="right">书籍编号：</td>
                    <td><input type="text" name="bookId" readonly="readonly" value="<%=bookinfo.getBookId()%>" /></td>
                </tr>
                <tr>
                    <td align="right">书 籍 名：</td>
                    <td><input type="text" name="bookName" value="<%=bookinfo.getBookName()%>" /></td>
                </tr>
                <tr>
                    <td align="right">简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介：</td>
                    <td><input type="text" name="remark" value="<%=bookinfo.getRemark()%>" /></td>
                </tr>
                <tr>
                    <td align="right">价格：</td>
                    <td><input type="text" name="bookPrice" value="<%=bookinfo.getBookPrice()%>" /></td>
                </tr>
                <tr>
                    <td align="right">作者：</td>
                    <td><input type="text" name="author" value="<%=bookinfo.getAuthor()%>" /></td>
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
