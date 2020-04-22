package org.hc.cart;

import org.hc.pojo.Bookinfo;

public class CartItem {
    private Bookinfo bookinfo;
    private int num;
    public CartItem() {
    }
    public CartItem(Bookinfo bookinfo, int num) {
        this.bookinfo = bookinfo;
        this.num = num;
    }
    public Bookinfo getBookinfo() {
        return bookinfo;
    }
    public void setBookinfo(Bookinfo bookinfo) {
        this.bookinfo = bookinfo;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public String toString() {
        return "CartItem{" +
                "bookinfo=" + bookinfo +
                ", num=" + num +
                '}';
    }
}
