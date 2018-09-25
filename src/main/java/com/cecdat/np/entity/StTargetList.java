package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-28
 */
@Data
@TableName("st_target_list")
public class StTargetList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField
    private String statistical;
    @TableField
    private String statistical1;
    @TableField
    private String statistical2;
    @TableField
    private String hospitalNa;
    @TableField
    private Date date;
    @TableField
    private String errorCorre;


}
