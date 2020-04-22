package org.hc.service.impl;

import org.hc.dao.BookinfoDao;
import org.hc.dao.impl.BookinfoDaoImpl;
import org.hc.pojo.Bookinfo;
import org.hc.service.BookinfoService;
import org.hc.util.PageBookinfo;

import java.util.List;

public class BookinfoServiceImpl implements BookinfoService {
    private BookinfoDao dao= new BookinfoDaoImpl();
    @Override
    public int getCount() {
        return dao.getCount();
    }
    @Override
    public List<Bookinfo> getPageInfo(PageBookinfo pageBookinfo) {
        return dao.getPageInfo(pageBookinfo);
    }

    @Override
    public int addBooks(Bookinfo bookinfo) {
        return dao.addBooks(bookinfo);
    }

    @Override
    public int updateBooks(Bookinfo bookinfo) {
        return dao.updateBooks(bookinfo);
    }

    @Override
    public int delBooks(int id) {
        return dao.delBooks(id);
    }

    @Override
    public Bookinfo getBooks(int id) {
        return dao.getBooks(id);
    }

    @Override
    public Bookinfo getBooks(String name) {
        return dao.getBooks(name);
    }
}
