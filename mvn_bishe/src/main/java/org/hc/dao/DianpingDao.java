package org.hc.dao;

import org.hc.pojo.Dianping;
import org.hc.util.PageDianping;

import java.util.List;

public interface DianpingDao {
    List<Dianping> all(int id);
    int getCount();
    List<Dianping> getPageInfo(PageDianping pageDianping);
    int delDianping(int id);
}
