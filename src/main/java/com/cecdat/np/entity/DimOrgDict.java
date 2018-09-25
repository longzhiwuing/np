package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 机构字典
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-28
 */
@Data
@TableName("dim_org_dict")
public class DimOrgDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构代码
     */
    @TableId
    private String orgCode;
    /**
     * 机构自定义编码
     */
    @TableField
    private String orgNo;
    /**
     * 机构名称
     */
    @TableField
    private String orgName;
    /**
     * 机构类型（医院、卫生院、社区）
     */
    @TableField
    private String orgType;
    /**
     * 机构类别
     */
    @TableField
    private String orgClass;
    /**
     * 省份代码（province_dict）
     */
    @TableField
    private String provinceCode;
    /**
     * 城市代码（city_dict）
     */
    @TableField
    private String cityCode;
    /**
     * 医院等级代码
     */
    @TableField
    private String orgGradeCode;
    /**
     * 医院等级名称（三级甲等、三级乙等）
     */
    @TableField
    private String orgGradeName;
    /**
     * 有效状态（有效：1、无效：0，机构分有效无效，有效机构统一置为1）
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
