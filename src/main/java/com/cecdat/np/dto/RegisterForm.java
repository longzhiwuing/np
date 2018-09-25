package com.cecdat.np.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/21
 * Time: 15:27
 */
@Data
public class RegisterForm {

    private String userName;

    private String password;

    private String confirmPassword;

    private String email;

    private String phone;

    private Integer cardType;

    private String cardNum;

    private String orgCode;

    private String orgName;

    private Integer userType;

}
