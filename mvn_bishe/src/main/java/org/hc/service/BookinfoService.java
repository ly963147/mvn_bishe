package org.hc.service;

import org.hc.pojo.Bookinfo;
import org.hc.util.PageBookinfo;

import java.util.List;

public interface BookinfoService {
    int getCount();
    List<Bookinfo> getPageInfo(PageBookinfo pageBookinfo);
    int addBooks(Bookinfo bookinfo);
    int updateBooks(Bookinfo bookinfo);
    int delBooks(int id);
    Bookinfo getBooks(int id);
    Bookinfo getBooks(String name);
}
