package org.hc.servlet;

import org.hc.pojo.Bookinfo;
import org.hc.pojo.Dianping;
import org.hc.service.BookinfoService;
import org.hc.service.DianpingService;
import org.hc.service.impl.BookinfoServiceImpl;
import org.hc.service.impl.DianpingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "BookinfoServlet",urlPatterns = "/bookinfo")
public class BookinfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        BookinfoService service=new BookinfoServiceImpl();
        Bookinfo bookinfo=service.getBooks(id);
        request.setAttribute("bookinfo" ,bookinfo);
        DianpingService dianping = new DianpingServiceImpl();
        List<Dianping> list = dianping.all(id);
        request.setAttribute("list" ,list);
        request.getRequestDispatcher("book.jsp").forward(request,response);
        out.println();
        out.flush();
        out.close();
    }
}
