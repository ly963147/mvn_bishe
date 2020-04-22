package org.hc.servlet;

import org.hc.pojo.Bookinfo;
import org.hc.service.BookinfoService;
import org.hc.service.impl.BookinfoServiceImpl;
import org.hc.util.PageBookinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllBooksServlet",urlPatterns = "/Allbooks")
public class AllBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        BookinfoService bookinfoService=new BookinfoServiceImpl();
        int count=bookinfoService.getCount();
        PageBookinfo pageBookinfo =new PageBookinfo();
        int pageIndex=1;
        String str=request.getParameter("pageIndex");
        pageIndex=(str==null)?(1):(Integer.parseInt(str));
        int pageSize=4;
        pageBookinfo.setCurrentPage(pageIndex);
        pageBookinfo.setRows(pageSize);
        pageBookinfo.setCount(count);
        System.out.println("total=>"+pageBookinfo.getTotalPage());
        List<Bookinfo> list=bookinfoService.getPageInfo(pageBookinfo);
        request.setAttribute("booklist",list);
        request.setAttribute("pagebookInfo",pageBookinfo);
        request.getRequestDispatcher("bookAll.jsp").forward(request,response);
    }
}
