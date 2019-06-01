package com.xzln.demo.business.controller;

import com.xzln.demo.business.model.User;
import com.xzln.demo.business.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/list")
    public String list(Model model){
        // 查询数据库所有用户
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user";
    }
}
