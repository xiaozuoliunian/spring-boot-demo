package com.xzln.demo.service;

import com.xzln.demo.model.User;

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
