package com.xzln.demo.business.dao;

import com.xzln.demo.business.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface IUserDao {

    /**
     * 查询所有用户信息
     * @return List<User>
     */
    List<User> findAllUser();
}
