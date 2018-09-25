package com.cecdat.np.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/23
 * Time: 19:43
 */
public class VcodeErrorException extends AuthenticationException {
    public VcodeErrorException(String msg, Throwable t) {
        super(msg, t);
    }

    public VcodeErrorException(String msg) {
        super(msg);
    }
}
