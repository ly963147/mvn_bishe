<%@ page import="org.hc.util.PageBookinfo" %>
<%@ page import="org.hc.pojo.Bookinfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/18
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>书籍列表</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script type="text/javascript">
        function funDels(id){
            if(window.confirm("您确定要删除吗？")){
                window.location="delbook?id="+id;
            }
        }
    </script>
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

    <center>
        <div class="userinfo">

            <table align="center" cellspacing="0" border="1" width="500">
                <caption><p style="color:#366;font-size:20px;" align="center">书籍列表</p></caption>
                <tr height="30">
                    <th>书名</th>
                    <th>简介</th>
                    <th>价格</th>
                    <th>作者</th>
                    <th>操作</th>
                </tr>
                <%
                    PageBookinfo pageInfo = (PageBookinfo) request.getAttribute("pagebookInfo");
                    List<Bookinfo> list = (List<Bookinfo>) request.getAttribute("booklist");
                    for (Bookinfo book:
                            list ) {
                %>
                <tr align="center">
                    <td width="10%"><%=book.getBookName() %></td>
                    <td width="60%"><%=book.getRemark() %></td>
                    <td width="10%"><%=book.getBookPrice() %></td>
                    <td width="10%"><%=book.getAuthor() %></td>
                    <td width="10%">
                        <a href="findbook?id=<%=book.getBookId() %>">修改</a>
                        <a href="javascript:funDels(<%=book.getBookId() %> )">删除</a>
                </tr>
                <%}%>
            </table><br />
        </div>
        <br/>
        <div id="page"> 共有 <span>&nbsp;<%=pageInfo.getTotalPage()%>&nbsp;</span> 页，当前第 <span>&nbsp;<%=pageInfo.getCurrentPage()%>&nbsp;</span> 页
            <span>
               <%
                   for (int i = 1; i <=pageInfo.getTotalPage() ; i++) {
               %>
                <a href="Allbooks?pageIndex=<%=i%>"><%=i%><a>
                        <%}%>
           </span>

            <% if(pageInfo.getCurrentPage()>1) {%>
            <a href="Allbooks?pageIndex=1">首页</a>
            <a href="Allbooks?pageIndex=<%=pageInfo.getCurrentPage()-1%>">上一页</a>
            <%}%>
            <% if(pageInfo.getCurrentPage()<pageInfo.getTotalPage()) {%>
            <a href="Allbooks?pageIndex=<%=pageInfo.getCurrentPage()+1%>">下一页</a>
            <a href="Allbooks?pageIndex=<%=pageInfo.getTotalPage()%>">尾页</a>
            <%}%>
        </div>
    </center>
    <div class="foot">
        <p class="myp"> 感谢使用 </p>
    </div>
</div>
</body>
</html>
