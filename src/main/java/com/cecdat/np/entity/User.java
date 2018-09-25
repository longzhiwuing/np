package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("sys_user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    @TableField
    private String userName;

    @TableField
    private String password;

    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableField
    private String email;

    @TableField
    private String phone;

    @TableField
    private Integer cardType;

    @TableField
    private String cardNum;

    @TableField
    private String orgCode;

    @TableField
    private String orgName;

    @TableField
    private Integer userType;
}