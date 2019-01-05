package com.xcy.springbootmybatisplus.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xcy.springbootmybatisplus.dao.UserMapper;
import com.xcy.springbootmybatisplus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xcy
 * @date 2018/12/19 11:52
 * @description 使用mybatis Plus 完成基础的 CRUD
 * @since V1.0.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userDao;

    //http://localhost:8881/user/getUserList
    @GetMapping("getUserList")
    public List<User> getUserList() {
        return userDao.getUserList();
    }


    //http://localhost:8881/user/getUserListByName?userName=jack
    //条件查询
    @GetMapping("getUserListByName")
    public List<User> getUserListByName(String userName) {
        Map map = new HashMap();
        map.put("user_name", userName);
        return userDao.selectByMap(map);
    }

    //http://localhost:8881/user/saveUser?userName=jerry2&userAge=11
    //保存用户
    @GetMapping("saveUser")
    public String saveUser(String userName, String userAge, String userAddress) {
        User user = new User(userName, userAge, userAddress);
        Integer index = userDao.insert(user);
        if (index > 0) {
            return "新增用户成功。";
        } else {
            return "新增用户失败。";
        }
    }

    //http://localhost:8881/user/updateUser?id=1&userName=jerry&userAge=111
    //修改用户
    @GetMapping("updateUser")
    public String updateUser(Integer id, String userName, String userAge, String userAddress) {
        User user = new User(id, userName, userAge);
        Integer index = userDao.updateById(user);
        if (index > 0) {
            return "修改用户成功，影响行数" + index + "行。";
        } else {
            return "修改用户失败，影响行数" + index + "行。";
        }
    }


    //http://localhost:8881/user/getUserById?userId=1
    //根据Id查询User
    @GetMapping("getUserById")
    public User getUserById(Integer userId) {
        return userDao.selectById(userId);
    }

    //http://localhost:8881/user/getUserListByPage?pageNumber=1&pageSize=2
    //条件分页查询
    @GetMapping("getUserListByPage")
    public List<User> getUserListByPage(Integer pageNumber, Integer pageSize) {
        Page<User> page = new Page<>(pageNumber, pageSize);
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", "jerry");
        return userDao.selectPage(page, entityWrapper);
    }

}
