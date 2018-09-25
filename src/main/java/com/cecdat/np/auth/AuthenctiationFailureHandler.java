/**
 * 
 */
package com.cecdat.np.auth;

import com.cecdat.np.dto.enums.StatusCode;
import com.cecdat.np.exception.VcodeErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.cecdat.np.dto.enums.StatusCode.LOGIN_ERROR;
import static com.cecdat.np.dto.enums.StatusCode.LOGIN_UNKNOW_ERROR;
import static com.cecdat.np.dto.enums.StatusCode.VCODE_ERROR;

/**
 * @author zhailiang
 *
 */
@Component
@Slf4j
public class AuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
		
		log.error("登录失败! exception:{}  exception.msg:{}",exception.getClass().getSimpleName(),exception.getMessage());

		StatusCode code = LOGIN_UNKNOW_ERROR;
        if (exception instanceof BadCredentialsException||exception instanceof UsernameNotFoundException) {
		    code = LOGIN_ERROR;
        }

		if (exception instanceof VcodeErrorException) {
        	code = VCODE_ERROR;
		}

        String url = String.format("/login?status=%s", code);
        getRedirectStrategy().sendRedirect(request,response,url);

	}

}
