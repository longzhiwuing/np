package com.cecdat.np.config;

import com.cecdat.np.base.BaseWebTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/21
 * Time: 13:39
 */
@Slf4j
public class SecurityConfigTest extends BaseWebTest{

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void testPasswordCoder() {
        String password = "123456";

        String pw1 = passwordEncoder.encode(password.trim());
        String pw2 = passwordEncoder.encode(password.trim());
        log.info("pw1:{}",pw1);
        log.info("pw2:{}",pw2);

        log.info("password==pw1:{}",passwordEncoder.matches(password,pw1));
        log.info("password==pw2:{}",passwordEncoder.matches(password,pw2));

    }

}