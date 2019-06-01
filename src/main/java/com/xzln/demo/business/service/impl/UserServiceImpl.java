package com.xzln.demo.business.service.impl;

import com.xzln.demo.business.dao.IUserDao;
import com.xzln.demo.business.model.User;
import com.xzln.demo.business.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements IUserService{

    @Resource
    private IUserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAllUser();
    }

}
