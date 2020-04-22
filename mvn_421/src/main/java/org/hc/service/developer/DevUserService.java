package org.hc.service.developer;


import org.hc.pojo.DevUser;

public interface DevUserService {
    public DevUser findByCode(String devCode);
}
