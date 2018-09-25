package com.cecdat.np.auth;

import com.cecdat.np.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        RequestCache requestCache = new HttpSessionRequestCache();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        //request.getSession().setAttribute("username",user.getUserName());
        String url = null;
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if(savedRequest != null){
            url = savedRequest.getRedirectUrl();
        }
        log.info("用户:{}登录成功，登录IP为{},跳转url:{}",userDetails.getUsername(),request.getRemoteAddr(),url);
        if(url == null){
            getRedirectStrategy().sendRedirect(request,response,"/index");
        }
        super.onAuthenticationSuccess(request, response, authentication);

    }
}  