<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/18
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>添加书籍</title>
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
    <div class="hezi" style="height:320px;">
        <p>添加新书</p><br />
        <hr /><br />
        <form action="addBook" method="post" enctype="multipart/form-data" onsubmit="return checkfrm(this)">
            <table>
                <tr>
                    <td>书&nbsp;&nbsp;名：</td>
                    <td><input type="text" name="bookName" class="tname" /></td>
                </tr>
                <tr>
                    <td>简&nbsp;&nbsp;介：</td>
                    <td><input type="text" name="remark" class="tname" /></td>
                </tr>
                <tr>
                    <td>价&nbsp;&nbsp;格：</td>
                    <td><input type="text" name="bookPrice" class="tname" /></td>
                </tr>
                <tr>
                    <td>作&nbsp;&nbsp;者：</td>
                    <td><input type="text" name="author"  class="tname"/></td>
                </tr>
                <tr>
                    <td>上传图片：</td>
                    <td><input type="file" name="bookImage" class="tname" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="添加" class="btn" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="foot">
        <p class="myp"> 感谢使用 </p>
    </div>
</div>
</body>
</html>
