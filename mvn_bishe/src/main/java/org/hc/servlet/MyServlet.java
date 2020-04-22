package org.hc.servlet;

import org.hc.cart.Cart;
import org.hc.cart.CartItem;
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
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet(name = "MyServlet", urlPatterns = "*.action")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        String fileName = path.substring(1, path.lastIndexOf("."));
        try {
            Method method = this.getClass().getDeclaredMethod(fileName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void allbuy(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        Cart cart= (Cart) session.getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            session.setAttribute("cart",cart);
        }
        response.sendRedirect("buy.jsp");
    }
    protected void  addbuy(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        BookinfoService service=new BookinfoServiceImpl();
        Bookinfo bookinfo=service.getBooks(id);
        HttpSession session=request.getSession();
        Cart cart= (Cart) session.getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            session.setAttribute("cart",cart);
        }
        addbook(bookinfo,cart);
        response.sendRedirect("buy.jsp");
    }
    private void addbook(Bookinfo bookinfo,Cart cart){
        Map<String,CartItem> items=cart.getItems();
        CartItem cartItem=items.get(bookinfo.getBookId()+"");
        if (cartItem==null){
            cartItem=new CartItem(bookinfo,1);
            items.put((bookinfo.getBookId()+""),cartItem);
        }else {
            cartItem.setNum(cartItem.getNum()+1);
        }
    }
    protected void cart(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        Cart cart= (Cart) session.getAttribute("cart");
        String param=request.getParameter("param");
        switch (param){
            case "1":
                String id=request.getParameter("id");
                String num=request.getParameter("num");
                cart.getItems().get(id).setNum(Integer.parseInt(num));
                System.out.println(id+num);
                break;
            case "2":
                String id2=request.getParameter("id");
                cart.getItems().remove(id2);
                break;
            case "3":
                cart.getItems().clear();
                System.out.println("清空");
                break;
        }
        response.sendRedirect("buy.jsp");
    }
}
