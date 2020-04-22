<%@ page import="org.hc.util.PageDianping" %>
<%@ page import="org.hc.pojo.Dianping" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/21
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script type="text/javascript">
        function funDel2(id){
            if(window.confirm("您确定要删除吗？")){
                window.location="deldianping?id="+id;
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
                <caption><p style="color:#366;font-size:20px;" align="center">点评列表</p></caption>
                <tr height="30">
                    <th>书籍ID</th>
                    <th>评价</th>
                    <th>具体描述</th>
                    <th>评价人ID</th>
                    <th>评价时间</th>
                    <th>操作</th>
                </tr>
                <%
                    PageDianping pageInfo = (PageDianping) request.getAttribute("pageDianping");
                    List<Dianping> list = (List<Dianping>) request.getAttribute("dianpinglist");
                    for (Dianping dianping:
                            list ) {
                %>
                <tr align="center">
                    <td width="15%"><%=dianping.getBookId() %></td>
                    <td width="15%"><%=dianping.getPinjia() %></td>
                    <td width="25%"><%=dianping.getDpcontent() %></td>
                    <td width="10%"><%=dianping.getUserId() %></td>
                    <td width="25%"><%=dianping.getDpdate() %></td>
                    <td width="10%"><a href="javascript:funDel2(<%=dianping.getDid() %> )">删除</a></td>
                </tr>
                <%}%>
            </table><br />
        </div>
        <br/>
        <div id="pag" >
            共有<font color=red>&nbsp;<%=pageInfo.getTotalPage()%>&nbsp;</font>页,当前第<font color=red>&nbsp;<%=pageInfo.getCurrentPage()%>&nbsp;</font>页，
            <span>
               <%
                   for (int i = 1; i <=pageInfo.getTotalPage() ; i++) {
               %>
                <a href="dianpingall?pageIndex=<%=i%>"><%=i%><a>
                        <%}%>
           </span>

            <% if(pageInfo.getCurrentPage()>1) {%>
            <a href="dianpingall?pageIndex=1">首页</a>
            <a href="dianpingall?pageIndex=<%=pageInfo.getCurrentPage()-1%>">上一页</a>
            <%}%>
            <% if(pageInfo.getCurrentPage()<pageInfo.getTotalPage()) {%>
            <a href="dianpingall?pageIndex=<%=pageInfo.getCurrentPage()+1%>">下一页</a>
            <a href="dianpingall?pageIndex=<%=pageInfo.getTotalPage()%>">尾页</a>
            <%}%>
        </div>
    </center>
    <div class="foot">
        <p class="myp"> 感谢使用 </p>
    </div>
</div>
</body>
</html>
