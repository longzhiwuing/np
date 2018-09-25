package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-07-17
 */
@Data
@TableName("sys_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    @TableField
    private String name;


}
