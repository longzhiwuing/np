package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 科室字典
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-28
 */
@Data
@TableName("dim_dept_dict")
public class DimDeptDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构代码
     */
    @TableId
    private String orgCode;
    /**
     * 科室代码
     */
    @TableField
    private String deptCode;
    /**
     * 科室名称
     */
    @TableField
    private String deptName;
    /**
     * 上级科室
     */
    @TableField
    private String upperClass;
    /**
     * 有效标志（有效：1、无效：0，科室分有效无效，有效科室统一置为1）
     */
    @TableField
    private String validFlag;
    /**
     * 数据生成时间
     */
    @TableField
    private Date createDate;
    /**
     * 拼音码
     */
    @TableField
    private String spellCode;
    /**
     * 排序号
     */
    @TableField
    private String sortNo;
    /**
     * 备注
     */
    @TableField
    private String remark;


}
