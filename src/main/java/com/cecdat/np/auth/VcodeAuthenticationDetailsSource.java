package com.cecdat.np.auth;

import lombok.Data;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class VcodeAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new VcodeWebAuthenticationDetails(context);
    }

}

@Data
class VcodeWebAuthenticationDetails extends WebAuthenticationDetails {

    private String vcode;

    private String sessionVcode;

    public VcodeWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.vcode = request.getParameter("vcode");
        this.sessionVcode = (String)request.getSession().getAttribute("vcode");
    }
}