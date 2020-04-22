package org.hc.service.impl;

import org.hc.dao.DianpingDao;
import org.hc.dao.impl.DianpingDaoImpl;
import org.hc.pojo.Dianping;
import org.hc.service.DianpingService;
import org.hc.util.PageDianping;

import java.util.List;

public class DianpingServiceImpl implements DianpingService {
    private DianpingDao dao = new DianpingDaoImpl();
    @Override
    public List<Dianping> all(int id) {
        return dao.all(id);
    }

    @Override
    public int getCount() {
        return dao.getCount();
    }

    @Override
    public List<Dianping> getPageInfo(PageDianping pageDianping) {
        return dao.getPageInfo(pageDianping);
    }

    @Override
    public int delDianping(int id) {
        return dao.delDianping(id);
    }
}
