package org.hc.dao;

import org.hc.pojo.Bookinfo;
import org.hc.util.PageBookinfo;

import java.awt.print.Book;
import java.util.List;

public interface BookinfoDao {
    int getCount();
    List<Bookinfo> getPageInfo(PageBookinfo pageBookinfo);
    int addBooks(Bookinfo bookinfo);
    int updateBooks(Bookinfo bookinfo);
    int delBooks(int id);
    Bookinfo getBooks(int id);
    Bookinfo getBooks(String name);
}
