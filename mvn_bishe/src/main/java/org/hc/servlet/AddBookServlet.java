package org.hc.servlet;

import org.hc.pojo.Bookinfo;
import org.hc.service.BookinfoService;
import org.hc.service.impl.BookinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

@WebServlet(name = "AddBookServlet",urlPatterns = "/addBook")
@MultipartConfig
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String name=request.getParameter("bookName");
        String remark=request.getParameter("remark");
        double bookPrice= Double.parseDouble(request.getParameter("bookPrice"));
        String author=request.getParameter("author");
        Part part =request.getPart("bookImage");
        String desc = part.getHeader("Content-Disposition");
        String after=desc.substring(desc.lastIndexOf("."),desc.length()-1);
        String fileName = UUID.randomUUID()+after;
        String path = request.getServletContext().getRealPath("/images");
        File file =new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        String allPath = file+"/"+fileName;
        InputStream is = part.getInputStream();
        FileOutputStream fos = new FileOutputStream(allPath);
        byte[] bty = new byte[1024];
        int length =0;
        while((length=is.read(bty))!=-1){
            fos.write(bty,0,length);
        }
        is.close();
        fos.close();
        Bookinfo bookinfo=new Bookinfo(name,remark,bookPrice,author,fileName);
        BookinfoService service=new BookinfoServiceImpl();
        int count = service.addBooks(bookinfo);
        if(count>0){
            response.sendRedirect("Allbook");
        }
        else {
            response.sendRedirect("addBook.jsp");
        }
        out.flush();
        out.close();
    }
}
