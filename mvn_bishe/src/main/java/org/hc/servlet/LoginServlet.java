package org.hc.servlet;

import org.hc.pojo.Userinfo;
import org.hc.service.UserinfoService;
import org.hc.service.impl.UserinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("uname");
        String pass = request.getParameter("upass");
        Userinfo users=new Userinfo(name,pass);
        UserinfoService usersService=new UserinfoServiceImpl();
        int count = usersService.isLogin(users);
        Userinfo userinfo=usersService.getUserinfoName(name);
        HttpSession session = request.getSession();
        session.setAttribute("uname",name);
        session.setAttribute("userinfo",userinfo);
        if(count>0){
            out.println(1);
            if(name.equals("huangche")){
                response.sendRedirect("Allbook");
            }
            else {
                response.sendRedirect("bookAll");
            }
        }else{
            out.println(0);
            response.sendRedirect("login.html");
        }
        out.println();
        out.flush();
        out.close();
    }
}
