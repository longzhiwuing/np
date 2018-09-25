package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 记录医院的基本信息
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-25
 */
@Data
@TableName("st_hospitcal_info")
public class StHospitcalInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 医院的唯一标识，统一编码
     */
    @TableId
    private String hospitalId;
    /**
     * 医院名称
     */
    @TableField
    private String hospitalName;
    /**
     * 医院等级
     */
    @TableField
    private String hospitalLevel;
    /**
     * 医院所属省市
     */
    @TableField
    private String hospitalProvince;
    /**
     * 医院所属区县
     */
    @TableField
    private String hospitalDistrict;


}
