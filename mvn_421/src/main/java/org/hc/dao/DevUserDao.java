package org.hc.dao;


import org.hc.pojo.DevUser;

public interface DevUserDao {
    public DevUser findByCode(String devCode);
}
