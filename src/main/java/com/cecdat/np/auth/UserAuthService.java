package com.cecdat.np.auth;

import com.cecdat.np.entity.User;
import com.cecdat.np.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@SuppressWarnings("AlibabaRemoveCommentedCode")
@Service
@Slf4j
public class UserAuthService implements UserDetailsService {
  
    @Autowired
    UserService userService;
  
    @Override  
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userService.selectByUserName(userName);

        if (user == null){
            throw new UsernameNotFoundException("用户不存在");
        }

       /* List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));*/

        UserInfo userInfo = new UserInfo(user.getUserName(),user.getPassword(),"ROLE_USER",user.getStatus()==1);

        /*User user = userService.getByEmail(s);
        if (user == null){  
            throw new UsernameNotFoundException("用户不存在");  
        }  
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //对应的权限添加  
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));  
        *//*AnyUser anyUser = new AnyUser(s, user.getPassword(), authorities);
        anyUser.setId(user.getId());  
        anyUser.setNickname(user.getNickname());  
        return anyUser;  *//*

        User user = new User();*/

        return userInfo;
    }

    public UserInfo getUserInfo() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        UserInfo userInfo = null;
        try {
            userInfo = (UserInfo) auth.getPrincipal();
        } catch (Exception e) {
            log.error("无法获取登录用户信息,auth.getPrincipal():{}", auth.getPrincipal());
        }
        return userInfo;
    }
  
}  