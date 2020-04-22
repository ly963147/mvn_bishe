<%@ page import="org.hc.pojo.Userinfo" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hc.util.PageUserinfo" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/28
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script type="text/javascript">
        function funDel(id){
            if(window.confirm("您确定要删除吗？")){
                window.location="del?id="+id;
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
                <caption><p style="color:#366;font-size:20px;" align="center">用户列表</p></caption>
                <tr height="30">
                    <th>用户名</th>
                    <th>用户密码</th>
                    <th>电话</th>
                    <th>真实姓名</th>
                    <th>身份证号</th>
                    <th>操作</th>
                </tr>
                <%
                    PageUserinfo pageInfo = (PageUserinfo) request.getAttribute("pageInfo");
                    List<Userinfo> list = (List<Userinfo>) request.getAttribute("list");
                    for (Userinfo user:
                            list ) {
                %>
                <tr align="center">
                    <td width="15%"><%=user.getLoginName() %></td>
                    <td width="15%"><%=user.getLoginPass() %></td>
                    <td width="25%"><%=user.getPhone() %></td>
                    <td width="10%"><%=user.getRealname() %></td>
                    <td width="25%"><%=user.getIdentify() %></td>
                    <td width="10%"><a href="javascript:funDel(<%=user.getUserId() %> )">删除</a></td>
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
                <a href="userAll?pageIndex=<%=i%>"><%=i%><a>
                        <%}%>
           </span>

            <% if(pageInfo.getCurrentPage()>1) {%>
            <a href="userAll?pageIndex=1">首页</a>
            <a href="userAll?pageIndex=<%=pageInfo.getCurrentPage()-1%>">上一页</a>
            <%}%>
            <% if(pageInfo.getCurrentPage()<pageInfo.getTotalPage()) {%>
            <a href="userAll?pageIndex=<%=pageInfo.getCurrentPage()+1%>">下一页</a>
            <a href="userAll?pageIndex=<%=pageInfo.getTotalPage()%>">尾页</a>
            <%}%>
        </div>
    </center>
    <div class="foot">
        <p class="myp"> 感谢使用 </p>
    </div>
</div>
</body>
</html>
