package com.cecdat.np.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cecdat.np.base.BaseWebTest;
import com.cecdat.np.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/19
 * Time: 17:17
 */
@Slf4j
public class UserServiceTest extends BaseWebTest{

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;

    Wrapper<User> wrapper;

    User user;

    @Before
    public void before() {
        wrapper = new EntityWrapper<>();
        user = new User();
    }

    @Test
    public void testCount() {
        int count = userService.selectCount(wrapper);
        log.info("user.size:{}",count);
    }

    @Test
    public void testSelect() {
        wrapper.where("user_name={0}", "zs");
        User user = userService.selectOne(wrapper);

        log.info("user:{}",user);
    }

    @Test
    public void testSelectByUserName() {
        user = userService.selectByUserName("zs");

        log.info("user:{}",user);
    }

    @Test
    @Transactional
    public void testInsertUser() {
        user.setUserName("aaa");
        user.setPassword("123456");
        user.setCreateTime(Calendar.getInstance().getTime());
        user.setPassword(encoder.encode(user.getPassword()));
        boolean insertResult = userService.insert(user);

        log.info("insert:{}",insertResult);
    }

    @Test
    public void testUpdateUser() {
        wrapper.where("user_name={0}", "zs");
        user.setOrgCode("1234");
        boolean updateResult = userService.update(user, wrapper);

        log.info("update:{}",updateResult);
    }

    @Test
    public void testIfExist() {
        boolean ifExist = userService.ifExist("zs");

        assertTrue(ifExist);
    }

}