package com.cecdat.np.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cecdat.np.entity.User;
import com.cecdat.np.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User 表数据服务层接口实现类
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    UserMapper userMapper;

    public User selectByUserName(String userName) {

        User user = new User();
        user.setUserName(userName);
        return userMapper.selectOne(user);
    }

    public boolean ifExist(String username) {
        Wrapper<User> ew = new EntityWrapper<>();
        ew.where("user_name={0}", username);
        return userMapper.selectCount(ew) > 0;

    }
}