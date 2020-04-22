package org.hc.service.impl;

import org.hc.dao.UserinfoDao;
import org.hc.dao.impl.UserinfoDaoImpl;
import org.hc.pojo.Userinfo;
import org.hc.service.UserinfoService;
import org.hc.util.PageUserinfo;

import java.util.List;

public class UserinfoServiceImpl implements UserinfoService {
    private UserinfoDao dao= new UserinfoDaoImpl();
    @Override
    public List<Userinfo> all(String name) {
        return dao.all(name);
    }
    @Override
    public int addUsers(Userinfo users) {
        return dao.addUsers(users);
    }
    @Override
    public int updateUsers(Userinfo users) {
        return dao.updateUsers(users);
    }
    @Override
    public int delUsers(int id) {
        return dao.delUsers(id);
    }
    @Override
    public Userinfo getUsers(int id) {
        return dao.getUsers(id);
    }
    @Override
    public int isLogin(Userinfo user) {
        return dao.login(user);
    }
    @Override
    public Userinfo getUserinfoName(String loginName) {
        return dao.getUserinfoName(loginName);
    }

    @Override
    public int getCount() {
        return dao.getCount();
    }

    @Override
    public List<Userinfo> getPageInfo(PageUserinfo pageInfo) {
        return dao.getPageInfo(pageInfo);
    }
}
