package org.hc.servlet;

import org.hc.pojo.Bookinfo;
import org.hc.pojo.Userinfo;
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

@WebServlet(name = "UpdateBookServlet",urlPatterns = "/updatebook")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("bookId");
        String name = request.getParameter("bookName");
        String remark = request.getParameter("remark");
        Double price = Double.valueOf(request.getParameter("bookPrice"));
        String author = request.getParameter("author");
        Bookinfo book = new Bookinfo(Integer.parseInt(id),name,remark,price,author);
        BookinfoService service = new BookinfoServiceImpl();
        int count = service.updateBooks(book);
        if (count > 0) {
            response.sendRedirect("Allbooks");
        } else {
            response.sendRedirect("Allbook");
        }
        out.println();
        out.flush();
        out.close();
    }
}
