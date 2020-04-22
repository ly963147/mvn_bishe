package org.hc.service;

import org.hc.pojo.Userinfo;
import org.hc.util.PageUserinfo;

import java.util.List;

public interface UserinfoService {
    List<Userinfo> all(String name);
    int addUsers(Userinfo users);
    int updateUsers(Userinfo users);
    int delUsers(int id);
    Userinfo getUsers(int id);
    int isLogin(Userinfo user);
    Userinfo getUserinfoName(String loginName);
    int getCount();
    List<Userinfo> getPageInfo(PageUserinfo pageInfo);
}
