package org.hc.dao;

import org.hc.pojo.Userinfo;
import org.hc.util.PageUserinfo;

import java.util.List;

public interface UserinfoDao {
    List<Userinfo> all(String name);
    int addUsers(Userinfo users);
    int updateUsers(Userinfo users);
    int delUsers(int id);
    Userinfo getUsers(int id);
    int login(Userinfo users);
    Userinfo getUserinfoName(String loginName);
    int getCount();  //总个数
    List<Userinfo> getPageInfo(PageUserinfo pageInfo);  //当前页的数据
}
