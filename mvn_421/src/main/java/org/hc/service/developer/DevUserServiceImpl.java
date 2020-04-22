package org.hc.service.developer;

import org.hc.dao.DevUserDao;
import org.hc.pojo.DevUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;

@Service
@Transactional
public class DevUserServiceImpl implements DevUserService{
    @Resource
    private DevUserDao devUserDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public DevUser findByCode(String devCode) {
        return devUserDao.findByCode(devCode);
    }
}
