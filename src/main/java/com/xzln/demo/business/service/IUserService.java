package com.xzln.demo.business.service;

import com.xzln.demo.business.model.User;

import java.util.List;

/**
 * @author Administrator
 */
public interface IUserService {

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();
}
