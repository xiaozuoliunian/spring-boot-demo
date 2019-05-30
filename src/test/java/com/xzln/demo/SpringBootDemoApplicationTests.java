package com.xzln.demo;

import com.xzln.demo.model.User;
import com.xzln.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private IUserService userService;

    //@Test
    public void mySqlTest(){
        String sql = "select id, name, password from ay_user";
        List<User> userList = jdbcTemplate.query(sql, (resultSet, i) -> {
            User user = new User();
            user.setId(resultSet.getString("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            return user;
        });
        System.out.println("数据库查询成功！结果如下：");
        for(User user : userList){
            System.out.println("【id】："+user.getId()+"；【name】："+user.getName()+"；【password】："+user.getPassword());
        }
    }

    @Test
    public void testMybatis(){
        List<User> userList = userService.findAll();
        for (User user : userList){
            System.out.println("【id】："+user.getId()+"；【name】："+user.getName()+"；【password】："+user.getPassword());
        }
    }

    @Test
    public void contextLoads() {
    }

}
