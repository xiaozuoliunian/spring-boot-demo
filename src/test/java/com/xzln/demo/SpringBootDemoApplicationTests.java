package com.xzln.demo;

import com.xzln.demo.common.jms.AyMoodProducer;
import com.xzln.demo.business.model.User;
import com.xzln.demo.business.service.IUserService;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private IUserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private AyMoodProducer ayMoodProducer;

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

    //@Test
    public void testMybatis(){
        List<User> userList = userService.findAll();
        for (User user : userList){
            System.out.println("【id】："+user.getId()+"；【name】："+user.getName()+"；【password】："+user.getPassword());
        }
    }

    //@Test
    public void testRedis(){
        // 增key:name, value:ay
        redisTemplate.opsForValue().set("name", "ay");
        String value = (String) redisTemplate.opsForValue().get("name");
        System.out.println("增加：name ,值为："+ value);

        // 更新
        redisTemplate.opsForValue().set("name", "gx");
        String gx = (String) redisTemplate.opsForValue().get("name");
        String gx1 = stringRedisTemplate.opsForValue().get("name");
        System.out.println("更新：name, 值为：" + gx);
        System.out.println("更新：name, 值为：" + gx1);

        // 删除
        redisTemplate.delete("name");
        String sc = (String) redisTemplate.opsForValue().get("name");
        System.out.println("删除：name, 值为：" + sc);
    }

    @Test
    public void testActiveMQ(){
        Destination destination = new ActiveMQQueue("ay.queue");

    }
}
