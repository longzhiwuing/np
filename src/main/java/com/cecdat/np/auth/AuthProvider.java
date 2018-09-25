package com.cecdat.np.auth;

import com.cecdat.np.exception.VcodeErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;


@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        VcodeWebAuthenticationDetails details = (VcodeWebAuthenticationDetails) authentication.getDetails();
        String vcode = details.getVcode();
        String sessionVcode = details.getSessionVcode();

        if (!Objects.equals(vcode, sessionVcode)) {
            throw new VcodeErrorException("验证码错误");
        }

        // 获取表单输入中返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UserInfo userInfo = (UserInfo) userDetailService.loadUserByUsername(userName);
        if (userInfo == null) {
            throw new BadCredentialsException("用户名不存在");
        }

        //这里还可以加一些其他信息的判断，比如用户账号已停用等判断

        if (!encoder.matches(password, userInfo.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // 这里直接改成retrun true;表示是支持这个执行
        return true;
    }
}