package org.hc.util;

import org.hc.pojo.Bookinfo;

import java.util.List;

public class PageBookinfo {
    private int count;
    private int totalPage;
    private int rows=5;
    private int currentPage=1;
    private List<Bookinfo> list;

    public PageBookinfo() {
    }

    public PageBookinfo(int count, int rows, int currentPage, List<Bookinfo> list) {
        this.count = count;
        this.rows = rows;
        this.currentPage = currentPage;
        this.list = list;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
        this.totalPage =(int)(Math.ceil(count/(double)rows));
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Bookinfo> getList() {
        return list;
    }

    public void setList(List<Bookinfo> list) {
        this.list = list;
    }
}
