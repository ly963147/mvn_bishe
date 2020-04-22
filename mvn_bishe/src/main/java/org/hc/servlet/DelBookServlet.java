package org.hc.servlet;

import org.hc.service.BookinfoService;
import org.hc.service.impl.BookinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DelBookServlet",urlPatterns = "/delbook")
public class DelBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        BookinfoService service=new BookinfoServiceImpl();
        int count = service.delBooks(id);
        if (count>0){
            response.sendRedirect("Allbooks");
        }else {
            response.sendRedirect("Allbook");
        }
        out.println();
        out.flush();
        out.close();
    }
}
