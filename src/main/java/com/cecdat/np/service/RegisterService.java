package com.cecdat.np.service;

import com.cecdat.np.dto.RegisterForm;
import com.cecdat.np.dto.enums.StatusCode;
import com.cecdat.np.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import static com.cecdat.np.dto.enums.StatusCode.REGISTER_FAIL;
import static com.cecdat.np.dto.enums.StatusCode.REGISTER_EXIST;
import static com.cecdat.np.dto.enums.StatusCode.REGISTER_OK;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/21
 * Time: 15:31
 */
@Service
@Slf4j
public class RegisterService {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;

    public StatusCode registerUser(@NotNull RegisterForm registerForm) {

        if (userService.ifExist(registerForm.getUserName())) {
            return REGISTER_EXIST;
        }

        User user = new User();
        BeanUtils.copyProperties(registerForm,user);
        log.info("register user:{}", user);
        user.setPassword(encoder.encode(user.getPassword()));

        return userService.insert(user)?REGISTER_OK: REGISTER_FAIL;
    }
}
