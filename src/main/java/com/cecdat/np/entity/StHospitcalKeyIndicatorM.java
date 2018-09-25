package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 记录各家医院每月每个系统的数据量
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-27
 */
@Data
@TableName("st_hospitcal_key_indicator_m")
public class StHospitcalKeyIndicatorM implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 医院唯一标识
     */
    @TableId
    private String hospitalId;
    /**
     * 医院名称
     */
    @TableField
    private String hospitalName;
    /**
     * 医院系统名称，目前仅有HIS，LIS，PACS,EMR,其他
     */
    @TableField
    private String hisSysName;
    /**
     * 医院系统，每个月的数据总量
     */
    @TableField
    private Double otherCountMonth;
    /**
     * 统计年月
     */
    @TableField
    private String yerMonth;
    /**
     * 是否治理标志位，0，未治理；1，已治理
     */
    @TableField
    private Integer doneFlag;


}
