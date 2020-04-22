package org.hc.servlet;

import org.hc.pojo.Userinfo;
import org.hc.service.UserinfoService;
import org.hc.service.impl.UserinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ZhuceServlet",urlPatterns = "/addUser")
public class ZhuceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name=request.getParameter("uname");
        String pass=request.getParameter("pass1");
        String phone=request.getParameter("tel");
        Userinfo users=new Userinfo(name,pass,phone);
        UserinfoService usersService=new UserinfoServiceImpl();
        int count=usersService.addUsers(users);
        if (count>0){
            response.sendRedirect("login.html");
        }else {
            response.sendRedirect("zhuce.html");
        }
    }
}
