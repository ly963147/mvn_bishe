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

@WebServlet(name = "UpdateUserServlet",urlPatterns = "/update")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("userid");
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        String real = request.getParameter("realname");
        String identity = request.getParameter("identity");
        String phone = request.getParameter("phone");
        Userinfo user = new Userinfo(Integer.parseInt(id),name,pass,phone,real,identity);
        UserinfoService service = new UserinfoServiceImpl();
        int count = service.updateUsers(user);
        if (count > 0) {
            HttpSession session = request.getSession();
            session.removeAttribute("uname");
            session.removeAttribute("userinfo");
            session.setAttribute("uname",name);
            Userinfo userinfo=service.getUserinfoName(name);
            session.setAttribute("userinfo",userinfo);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
        out.println();
        out.flush();
        out.close();
    }
}
