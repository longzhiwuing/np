package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 员工字典
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-28
 */
@Data
@TableName("dim_staff_dict")
public class DimStaffDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构代码
     */
    @TableId
    private String orgCode;
    /**
     * 员工代码
     */
    @TableField
    private String staffNo;
    /**
     * 员工姓名
     */
    @TableField
    private String staffName;
    /**
     * 员工工作牌号
     */
    @TableField
    private String employeNo;
    /**
     * 行政科室代码
     */
    @TableField
    private String deptCode;
    /**
     * 医疗小组
     */
    @TableField
    private String groupNo;
    /**
     * 工作类别（医生/护士/医技）
     */
    @TableField
    private String workKind;
    /**
     * 在职状态（在编/合同/临时/返聘）
     */
    @TableField
    private String reigningCode;
    /**
     * 出生日期
     */
    @TableField
    private Date birthDate;
    /**
     * 工作时间
     */
    @TableField
    private Date workingDate;
    /**
     * 进本单位时间
     */
    @TableField
    private Date enterDate;
    /**
     * 植物
     */
    @TableField
    private String dutyCode;
    /**
     * 任职时间
     */
    @TableField
    private Date dutyDate;
    /**
     * 离职时间
     */
    @TableField
    private Date leaveDate;
    /**
     * 性别
     */
    @TableField
    private String sex;
    /**
     * 技术职称
     */
    @TableField
    private String titleCode;
    /**
     * 职工数
     */
    @TableField
    private String staffRens;
    /**
     * 在编人数
     */
    @TableField
    private String staffPayrollRens;
    /**
     * 卫生技术人数
     */
    @TableField
    private String staffTechnologyRens;
    /**
     * 医生人数
     */
    @TableField
    private String staffDoctorRens;
    /**
     * 护理人数
     */
    @TableField
    private String staffNurseRens;
    /**
     * 医技人数
     */
    @TableField
    private String staffCureRens;
    /**
     * 药剂人数
     */
    @TableField
    private String staffDrugRens;
    /**
     * 其他卫生技术人数
     */
    @TableField
    private String staffTechnologyOther;
    /**
     * 非卫生技术人数
     */
    @TableField
    private String staffNotechnologyRens;
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
