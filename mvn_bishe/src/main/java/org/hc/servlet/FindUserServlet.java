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
import java.util.List;

@WebServlet(name = "FindUserServlet",urlPatterns = "/find")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("uname");
        UserinfoService service = new UserinfoServiceImpl();
        Userinfo userinfo=service.getUserinfoName(name);
        request.setAttribute("user" ,userinfo);
        request.getRequestDispatcher("userinfo.jsp").forward(request,response);
        out.println();
        out.flush();
        out.close();
    }
}
