package org.hc.servlet;

import org.hc.pojo.Userinfo;
import org.hc.service.UserinfoService;
import org.hc.service.impl.UserinfoServiceImpl;
import org.hc.util.PageUserinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserAllServlet",urlPatterns = "/userAll")
public class UserAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserinfoService userinfoService=new UserinfoServiceImpl();
        int count=userinfoService.getCount();
        PageUserinfo pageInfo =new PageUserinfo();
        int pageIndex=1;
        String str=request.getParameter("pageIndex");
        pageIndex=(str==null)?(1):(Integer.parseInt(str));
        int pageSize=5;
        pageInfo.setCurrentPage(pageIndex);
        pageInfo.setRows(pageSize);
        pageInfo.setCount(count);
        System.out.println("total=>"+pageInfo.getTotalPage());
        List<Userinfo> list=userinfoService.getPageInfo(pageInfo);
        request.setAttribute("list",list);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("userAll.jsp").forward(request,response);
    }
}
