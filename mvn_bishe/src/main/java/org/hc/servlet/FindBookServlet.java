package org.hc.servlet;

import org.hc.pojo.Bookinfo;
import org.hc.service.BookinfoService;
import org.hc.service.impl.BookinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FindBookServlet",urlPatterns = "/findbook")
public class FindBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        BookinfoService service = new BookinfoServiceImpl();
        Bookinfo bookinfo = service.getBooks(id);
        request.setAttribute("book" ,bookinfo);
        request.getRequestDispatcher("bookinfo.jsp").forward(request,response);
        out.println();
        out.flush();
        out.close();
    }
}
