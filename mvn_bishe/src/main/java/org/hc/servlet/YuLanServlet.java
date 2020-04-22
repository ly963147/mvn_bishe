package org.hc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "YuLanServlet",urlPatterns = "/yulan")
public class YuLanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        if(id==1){
            response.sendRedirect("yuelan1.html");
        }
        else if(id==3){
            response.sendRedirect("yuelan2.html");
        }
        else if(id==8){
            response.sendRedirect("yuelan.html");
        }
        out.println();
        out.flush();
        out.close();
    }
}
