package org.hc.servlet;

import org.hc.pojo.Dianping;
import org.hc.service.DianpingService;
import org.hc.service.impl.DianpingServiceImpl;
import org.hc.util.PageDianping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DianpingAllServlet",urlPatterns = "/dianpingall")
public class DianpingAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        DianpingService bookinfoService=new DianpingServiceImpl();
        int count=bookinfoService.getCount();
        PageDianping pageDianping =new PageDianping();
        int pageIndex=1;
        String str=request.getParameter("pageIndex");
        pageIndex=(str==null)?(1):(Integer.parseInt(str));
        int pageSize=5;
        pageDianping.setCurrentPage(pageIndex);
        pageDianping.setRows(pageSize);
        pageDianping.setCount(count);
        System.out.println("total=>"+pageDianping.getTotalPage());
        List<Dianping> list=bookinfoService.getPageInfo(pageDianping);
        request.setAttribute("dianpinglist",list);
        request.setAttribute("pageDianping",pageDianping);
        request.getRequestDispatcher("dianpingall.jsp").forward(request,response);
    }
}
