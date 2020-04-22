package org.hc.service;

import org.hc.pojo.Dianping;
import org.hc.util.PageDianping;

import java.util.List;

public interface DianpingService {
    List<Dianping> all(int id);
    int getCount();
    List<Dianping> getPageInfo(PageDianping pageDianping);
    int delDianping(int id);
}
