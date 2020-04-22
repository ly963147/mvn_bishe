package org.hc.servlet;

import org.hc.service.DianpingService;
import org.hc.service.impl.DianpingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DelDianpingServlet",urlPatterns = "/deldianping")
public class DelDianpingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        DianpingService service=new DianpingServiceImpl();
        int count = service.delDianping(id);
        if (count>0){
            response.sendRedirect("dianpingall");
        }else {
            response.sendRedirect("Allbook");
        }
        out.println();
        out.flush();
        out.close();
    }
}
