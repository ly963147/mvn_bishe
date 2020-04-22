<%@ page import="org.hc.util.PageBookinfo" %>
<%@ page import="org.hc.pojo.Bookinfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/18
  Time: 19:44
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
            <font color="red"><%=name%></font> | 用户等级：管理员 |
            <a href="destroy">注销</a>
        </div>
    </div>
    <div ><img src="images/000.jpeg" width="825px"  height="250px"/> </div>
    <div class="menu"> |&nbsp;
        <a href="Allbook">网站首页</a>&nbsp;|&nbsp;
        <a href="Allbooks">书籍列表</a>&nbsp;|&nbsp;
        <a href="addBook.jsp">添加新书</a>&nbsp;|&nbsp;
        <a href="userAll">用户列表</a>&nbsp;|&nbsp;
        <a href="dianpingall">点评列表</a>&nbsp;|&nbsp;</div>
    <div class="welcome">
        <marquee behavior="alternate">欢迎<font color="red"><%=name%></font>进入 【<span>网上书城</span>】</marquee>
    </div>
    <div class="main">
        <p align="center"><span>*</span>----------以下为本书城所出售书籍，欢迎选购----------<span>*</span></p>
        <ul>
            <%
                PageBookinfo pageBookinfo = (PageBookinfo) request.getAttribute("pagebookInfo");
                List<Bookinfo> list = (List<Bookinfo>) request.getAttribute("booklist");
                for (Bookinfo bookinfo:
                        list ) {
            %>
            <li>
                <table cellspacing="0">
                    <tr>
                        <td width="80"><%=bookinfo.getBookName() %></td><br/>
                        <td align="right"> ￥<span><%=bookinfo.getBookPrice() %></span></td><br/>
                        <td align="right"><a href="bookinfo?id=<%=bookinfo.getBookId() %>"> <img src="images/detail_cn.gif"  /> </a></td>
                    </tr>
                </table>
            </li>
            <%}%>
        </ul>
    </div>
    <div id="page"> 共有 <span>&nbsp;<%=pageBookinfo.getTotalPage()%>&nbsp;</span> 页，当前第 <span>&nbsp;<%=pageBookinfo.getCurrentPage()%>&nbsp;</span> 页
        <span>
               <%
                   for (int i = 1; i <=pageBookinfo.getTotalPage() ; i++) {
               %>
                <a href="bookAll?pageIndex=<%=i%>"><%=i%><a>
                        <%}%>
           </span>

        <% if(pageBookinfo.getCurrentPage()>1) {%>
        <a href="bookAll?pageIndex=1">首页</a>
        <a href="bookAll?pageIndex=<%=pageBookinfo.getCurrentPage()-1%>">上一页</a>
        <%}%>
        <% if(pageBookinfo.getCurrentPage()<pageBookinfo.getTotalPage()) {%>
        <a href="bookAll?pageIndex=<%=pageBookinfo.getCurrentPage()+1%>">下一页</a>
        <a href="bookAll?pageIndex=<%=pageBookinfo.getTotalPage()%>">尾页</a>
        <%}%>
    </div>
    <div class="foot">
        <p class="myp"> 感谢使用 </p>
    </div>
</div>
</body>
</html>
